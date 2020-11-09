package com.lfm.activity.service.impl;

import java.util.List;
import com.lfm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lfm.activity.mapper.ActLaundryMapper;
import com.lfm.activity.domain.ActLaundry;
import com.lfm.activity.service.IActLaundryService;

/**
 * 洗衣订单信息Service业务层处理
 *
 * @author zjz
 * @date 2020-11-09
 */
@Service
public class ActLaundryServiceImpl implements IActLaundryService
{
    @Autowired
    private ActLaundryMapper actLaundryMapper;

    /**
     * 查询洗衣订单信息
     *
     * @param laundryId 洗衣订单信息ID
     * @return 洗衣订单信息
     */
    @Override
    public ActLaundry selectActLaundryById(Long laundryId)
    {
        return actLaundryMapper.selectActLaundryById(laundryId);
    }

    /**
     * 查询洗衣订单信息列表
     *
     * @param actLaundry 洗衣订单信息
     * @return 洗衣订单信息
     */
    @Override
    public List<ActLaundry> selectActLaundryList(ActLaundry actLaundry)
    {
        return actLaundryMapper.selectActLaundryList(actLaundry);
    }

    /**
     * 新增洗衣订单信息
     *
     * @param actLaundry 洗衣订单信息
     * @return 结果
     */
    @Override
    public int insertActLaundry(ActLaundry actLaundry)
    {
        actLaundry.setCreateTime(DateUtils.getNowDate());
        return actLaundryMapper.insertActLaundry(actLaundry);
    }

    /**
     * 修改洗衣订单信息
     *
     * @param actLaundry 洗衣订单信息
     * @return 结果
     */
    @Override
    public int updateActLaundry(ActLaundry actLaundry)
    {
        actLaundry.setUpdateTime(DateUtils.getNowDate());
        return actLaundryMapper.updateActLaundry(actLaundry);
    }

    /**
     * 批量删除洗衣订单信息
     *
     * @param laundryIds 需要删除的洗衣订单信息ID
     * @return 结果
     */
    @Override
    public int deleteActLaundryByIds(Long[] laundryIds)
    {
        return actLaundryMapper.deleteActLaundryByIds(laundryIds);
    }

    /**
     * 删除洗衣订单信息信息
     *
     * @param laundryId 洗衣订单信息ID
     * @return 结果
     */
    @Override
    public int deleteActLaundryById(Long laundryId)
    {
        return actLaundryMapper.deleteActLaundryById(laundryId);
    }
}
