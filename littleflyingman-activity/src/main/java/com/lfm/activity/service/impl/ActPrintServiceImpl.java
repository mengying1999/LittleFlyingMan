package com.lfm.activity.service.impl;

import java.util.List;
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
}
