package com.lfm.activity.service.impl;

import java.util.Date;
import java.util.List;

import com.lfm.activity.domain.DshOrder;
import com.lfm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lfm.activity.mapper.ActPrintMapper;
import com.lfm.activity.domain.ActPrint;
import com.lfm.activity.service.IActPrintService;

/**
 * 打印订单Service业务层处理
 *
 * @author zjz
 * @date 2020-11-08
 */
@Service
public class ActPrintServiceImpl implements IActPrintService
{
    @Autowired
    private ActPrintMapper actPrintMapper;

    @Autowired
    private DelayService delayService;

    /**
     * 查询打印订单
     *
     * @param printId 打印订单ID
     * @return 打印订单
     */
    @Override
    public ActPrint selectActPrintById(Long printId)
    {
        return actPrintMapper.selectActPrintById(printId);
    }

    /**
     * 查询打印订单列表
     *
     * @param actPrint 打印订单
     * @return 打印订单
     */
    @Override
    public List<ActPrint> selectActPrintList(ActPrint actPrint)
    {
        return actPrintMapper.selectActPrintList(actPrint);
    }

    /**
     * 新增打印订单
     *
     * @param actPrint 打印订单
     * @return 结果
     */
    @Override
    public int insertActPrint(ActPrint actPrint)
    {
        actPrint.setCreateTime(DateUtils.getNowDate());
        return actPrintMapper.insertActPrint(actPrint);
    }

    /**
     * 修改打印订单
     *
     * @param actPrint 打印订单
     * @return 结果
     */
    @Override
    public int updateActPrint(ActPrint actPrint)
    {
        actPrint.setUpdateTime(DateUtils.getNowDate());
        return actPrintMapper.updateActPrint(actPrint);
    }

    /**
     * 批量删除打印订单
     *
     * @param printIds 需要删除的打印订单ID
     * @return 结果
     */
    @Override
    public int deleteActPrintByIds(Long[] printIds)
    {
        return actPrintMapper.deleteActPrintByIds(printIds);
    }

    /**
     * 删除打印订单信息
     *
     * @param printId 打印订单ID
     * @return 结果
     */
    @Override
    public int deleteActPrintById(Long printId)
    {
        return actPrintMapper.deleteActPrintById(printId);
    }

    @Override
    public int updatePrintStatus(ActPrint actPrint) {
        ActPrint temp = actPrintMapper.selectActPrintById(actPrint.getPrintId());
        if(temp.getStatus() == "1"){
            actPrint.setPrintTime(new Date());
            actPrint.setStatus("2");
            int flag = actPrintMapper.updateActPrint(actPrint);
            if (flag == 0){
                // 接单后，创建一个1天之内没有配送就自动取消订单的定时器
                DshOrder dshOrder = new DshOrder("R"+actPrint.getPrintId(),24 * 60 * 60 * 1000,2);
                delayService.add(dshOrder);
            } else {
                return 1;
            }
        } else {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateDeliveryStatus(ActPrint actPrint) {
        ActPrint temp = actPrintMapper.selectActPrintById(actPrint.getPrintId());
        if(temp.getStatus() == "2"){
            actPrint.setStatus("3");
            actPrint.setDeliveryTime(new Date());
            int flag = actPrintMapper.updateActPrint(actPrint);
            if (flag == 0){
                // 配送后，创建一个1天之内没有收货就自动取消订单的定时器
                DshOrder dshOrder = new DshOrder("R"+actPrint.getPrintId(),24 * 60 * 60 * 1000,3);
                delayService.add(dshOrder);
            } else {
                return 1;
            }
        } else {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateFinishStatus(ActPrint actPrint) {
        ActPrint temp = actPrintMapper.selectActPrintById(actPrint.getPrintId());
        if(temp.getStatus() == "3"){
            actPrint.setStatus("4");
            actPrint.setFinishTime(new Date());
            int flag = actPrintMapper.updateActPrint(actPrint);
        } else {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateCancelStatus(ActPrint actPrint) {
        ActPrint temp = actPrintMapper.selectActPrintById(actPrint.getPrintId());
        if(temp.getStatus() == "0" || temp.getStatus() == "1" || temp.getStatus() == "2"){
            actPrint.setCancelTime(new Date());
            actPrint.setStatus("5");
            int flag = actPrintMapper.updateActPrint(actPrint);
            if (flag == 0 && temp.getStatus() != "0"){
                // 调用取消订单的接口
                delayService.alipayRefundRequest("R" + actPrint.getPrintId(),"",actPrint.getFee());
            }
        } else {
            return 1;
        }
        return 0;
    }

}
