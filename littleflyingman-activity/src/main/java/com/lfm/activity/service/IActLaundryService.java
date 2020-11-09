package com.lfm.activity.service;

import java.util.List;
import com.lfm.activity.domain.ActLaundry;

/**
 * 洗衣订单信息Service接口
 *
 * @author zjz
 * @date 2020-11-09
 */
public interface IActLaundryService
{
    /**
     * 查询洗衣订单信息
     *
     * @param laundryId 洗衣订单信息ID
     * @return 洗衣订单信息
     */
    public ActLaundry selectActLaundryById(Long laundryId);

    /**
     * 查询洗衣订单信息列表
     *
     * @param actLaundry 洗衣订单信息
     * @return 洗衣订单信息集合
     */
    public List<ActLaundry> selectActLaundryList(ActLaundry actLaundry);

    /**
     * 新增洗衣订单信息
     *
     * @param actLaundry 洗衣订单信息
     * @return 结果
     */
    public int insertActLaundry(ActLaundry actLaundry);

    /**
     * 修改洗衣订单信息
     *
     * @param actLaundry 洗衣订单信息
     * @return 结果
     */
    public int updateActLaundry(ActLaundry actLaundry);

    /**
     * 批量删除洗衣订单信息
     *
     * @param laundryIds 需要删除的洗衣订单信息ID
     * @return 结果
     */
    public int deleteActLaundryByIds(Long[] laundryIds);

    /**
     * 删除洗衣订单信息信息
     *
     * @param laundryId 洗衣订单信息ID
     * @return 结果
     */
    public int deleteActLaundryById(Long laundryId);
}