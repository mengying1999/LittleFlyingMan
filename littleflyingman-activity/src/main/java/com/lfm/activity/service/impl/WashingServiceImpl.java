package com.lfm.activity.service.impl;

import java.util.Date;
import java.util.List;

import com.lfm.activity.domain.ActPrint;
import com.lfm.activity.domain.DshOrder;
import com.lfm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lfm.activity.mapper.WashingMapper;
import com.lfm.activity.domain.Washing;
import com.lfm.activity.service.IWashingService;

/**
 * 洗衣订单Service业务层处理
 * 
 * @author zjz
 * @date 2021-05-02
 */
@Service
public class WashingServiceImpl implements IWashingService 
{
    @Autowired
    private WashingMapper washingMapper;

    @Autowired
    private DelayService delayService;

    /**
     * 查询洗衣订单
     * 
     * @param washingId 洗衣订单ID
     * @return 洗衣订单
     */
    @Override
    public Washing selectWashingById(Long washingId)
    {
        return washingMapper.selectWashingById(washingId);
    }

    /**
     * 查询洗衣订单列表
     * 
     * @param washing 洗衣订单
     * @return 洗衣订单
     */
    @Override
    public List<Washing> selectWashingList(Washing washing)
    {
        return washingMapper.selectWashingList(washing);
    }

    /**
     * 新增洗衣订单
     * 
     * @param washing 洗衣订单
     * @return 结果
     */
    @Override
    public int insertWashing(Washing washing)
    {
        washing.setCreateTime(DateUtils.getNowDate());
        return washingMapper.insertWashing(washing);
    }

    /**
     * 修改洗衣订单
     * 
     * @param washing 洗衣订单
     * @return 结果
     */
    @Override
    public int updateWashing(Washing washing)
    {
        washing.setUpdateTime(DateUtils.getNowDate());
        return washingMapper.updateWashing(washing);
    }

    /**
     * 批量删除洗衣订单
     * 
     * @param washingIds 需要删除的洗衣订单ID
     * @return 结果
     */
    @Override
    public int deleteWashingByIds(Long[] washingIds)
    {
        return washingMapper.deleteWashingByIds(washingIds);
    }

    /**
     * 删除洗衣订单信息
     * 
     * @param washingId 洗衣订单ID
     * @return 结果
     */
    @Override
    public int deleteWashingById(Long washingId)
    {
        return washingMapper.deleteWashingById(washingId);
    }

    /**
     * 更改为接单状态
     * @param washing
     * @return
     */
    @Override
    public int updateTakeStatus(Washing washing) {
        Washing temp = washingMapper.selectWashingById(washing.getWashingId());
        if("1".equals(temp.getStatus())){
            washing.setTakeTime(new Date());
            washing.setStatus("2");
            int flag = washingMapper.updateWashing(washing);
            if (flag == 1){
                // 接单后，创建一个1天之内没有取衣就取消订单
                DshOrder dshOrder = new DshOrder("W"+washing.getWashingId(),24 * 60 * 60 * 1000,5);
                delayService.add(dshOrder);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateFetchStatus(Washing washing) {
        Washing temp = washingMapper.selectWashingById(washing.getWashingId());
        if("2".equals(temp.getStatus())){
            washing.setFetchTime(new Date());
            washing.setStatus("3");
            int flag = washingMapper.updateWashing(washing);
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateWashingStatus(Washing washing) {
        Washing temp = washingMapper.selectWashingById(washing.getWashingId());
        if("3".equals(temp.getStatus())){
            washing.setWashingTime(new Date());
            washing.setStatus("4");
            int flag = washingMapper.updateWashing(washing);
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateDeliveryStatus(Washing washing) {
        Washing temp = washingMapper.selectWashingById(washing.getWashingId());
        if("4".equals(temp.getStatus())){
            washing.setDeliveryTime(new Date());
            washing.setStatus("5");
            int flag = washingMapper.updateWashing(washing);
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateCancelStatus(Washing washing) {
        Washing temp = washingMapper.selectWashingById(washing.getWashingId());
        if("0".equals(temp.getStatus()) || "1".equals(temp.getStatus()) ||"2".equals(temp.getStatus())){
            washing.setCancelTime(new Date());
            washing.setStatus("7");
            if (!"0".equals(temp.getStatus())){
                // 调用取消订单的接口
                delayService.alipayRefundRequest("W" + temp.getWashingId(),"",temp.getFee());
            }
            int flag = washingMapper.updateWashing(washing);
        } else {
            return 0;
        }
        return 1;
    }


}
