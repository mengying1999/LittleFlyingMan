package com.lfm.activity.mapper;

import com.lfm.activity.domain.ActAddress;

import java.util.List;

/**
 * 地址Mapper接口
 *
 * @author zjz
 * @date 2020-11-07
 */
public interface ActAddressMapper
{
    /**
     * 查询地址
     *
     * @param addressId 地址ID
     * @return 地址
     */
    public ActAddress selectActAddressById(Long addressId);

    /**
     * 查询地址列表
     *
     * @param actAddress 地址
     * @return 地址集合
     */
    public List<ActAddress> selectActAddressList(ActAddress actAddress);

    /**
     * 新增地址
     *
     * @param actAddress 地址
     * @return 结果
     */
    public int insertActAddress(ActAddress actAddress);

    /**
     * 修改地址
     *
     * @param actAddress 地址
     * @return 结果
     */
    public int updateActAddress(ActAddress actAddress);

    /**
     * 删除地址
     *
     * @param addressId 地址ID
     * @return 结果
     */
    public int deleteActAddressById(Long addressId);

    /**
     * 批量删除地址
     *
     * @param addressIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteActAddressByIds(Long[] addressIds);
}
