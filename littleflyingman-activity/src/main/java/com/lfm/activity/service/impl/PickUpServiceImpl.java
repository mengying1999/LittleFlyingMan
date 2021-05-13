package com.lfm.activity.service.impl;

import java.util.Date;
import java.util.List;

import com.lfm.activity.domain.Washing;
import com.lfm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import com.lfm.activity.mapper.PickUpMapper;
import com.lfm.activity.domain.PickUp;
import com.lfm.activity.service.IPickUpService;

/**
 * 打印订单Service业务层处理
 * 
 * @author zjz
 * @date 2021-05-02
 */
@Service
public class PickUpServiceImpl implements IPickUpService 
{
    @Autowired
    private PickUpMapper pickUpMapper;

    @Autowired
    private DelayService delayService;

    /**
     * 查询打印订单
     * 
     * @param pickUpId 打印订单ID
     * @return 打印订单
     */
    @Override
    public PickUp selectPickUpById(Long pickUpId)
    {
        return pickUpMapper.selectPickUpById(pickUpId);
    }

    /**
     * 查询打印订单列表
     * 
     * @param pickUp 打印订单
     * @return 打印订单
     */
    @Override
    public List<PickUp> selectPickUpList(PickUp pickUp)
    {
        return pickUpMapper.selectPickUpList(pickUp);
    }

    /**
     * 新增打印订单
     * 
     * @param pickUp 打印订单
     * @return 结果
     */
    @Override
    public int insertPickUp(PickUp pickUp)
    {
        pickUp.setCreateTime(DateUtils.getNowDate());
        return pickUpMapper.insertPickUp(pickUp);
    }

    /**
     * 修改打印订单
     * 
     * @param pickUp 打印订单
     * @return 结果
     */
    @Override
    public int updatePickUp(PickUp pickUp)
    {
        pickUp.setUpdateTime(DateUtils.getNowDate());
        return pickUpMapper.updatePickUp(pickUp);
    }

    /**
     * 批量删除打印订单
     * 
     * @param pickUpIds 需要删除的打印订单ID
     * @return 结果
     */
    @Override
    public int deletePickUpByIds(Long[] pickUpIds)
    {
        return pickUpMapper.deletePickUpByIds(pickUpIds);
    }

    /**
     * 删除打印订单信息
     * 
     * @param pickUpId 打印订单ID
     * @return 结果
     */
    @Override
    public int deletePickUpById(Long pickUpId)
    {
        return pickUpMapper.deletePickUpById(pickUpId);
    }

    @Override
    public int updateDeliveryStatus(PickUp pickUp) {
        PickUp temp = pickUpMapper.selectPickUpById(pickUp.getPickUpId());
        if("1".equals(temp.getStatus())){
            pickUp.setDeliveryTime(new Date());
            pickUp.setStatus("2");
            int flag = pickUpMapper.updatePickUp(pickUp);
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateCancelStatus(PickUp pickUp) {
        PickUp temp = pickUpMapper.selectPickUpById(pickUp.getPickUpId());
        if("0".equals(temp.getStatus()) || "1".equals(temp.getStatus())){
            pickUp.setCancelTime(new Date());
            pickUp.setStatus("4");
            int flag = pickUpMapper.updatePickUp(pickUp);
            if (flag == 0){
                return 0;
            }
            if (!"0".equals(temp.getStatus())){
                // 调用取消订单的接口
                delayService.alipayRefundRequest("P" + temp.getPickUpId(),"",temp.getFee());
            }
        } else {
            return 0;
        }
        return 1;
    }

}
