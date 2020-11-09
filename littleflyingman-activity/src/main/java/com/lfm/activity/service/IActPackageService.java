package com.lfm.activity.service;

import java.util.List;
import com.lfm.activity.domain.ActPackage;

/**
 * 包裹订单信息Service接口
 *
 * @author zjz
 * @date 2020-11-09
 */
public interface IActPackageService
{
    /**
     * 查询包裹订单信息
     *
     * @param packageId 包裹订单信息ID
     * @return 包裹订单信息
     */
    public ActPackage selectActPackageById(Long packageId);

    /**
     * 查询包裹订单信息列表
     *
     * @param actPackage 包裹订单信息
     * @return 包裹订单信息集合
     */
    public List<ActPackage> selectActPackageList(ActPackage actPackage);

    /**
     * 新增包裹订单信息
     *
     * @param actPackage 包裹订单信息
     * @return 结果
     */
    public int insertActPackage(ActPackage actPackage);

    /**
     * 修改包裹订单信息
     *
     * @param actPackage 包裹订单信息
     * @return 结果
     */
    public int updateActPackage(ActPackage actPackage);

    /**
     * 批量删除包裹订单信息
     *
     * @param packageIds 需要删除的包裹订单信息ID
     * @return 结果
     */
    public int deleteActPackageByIds(Long[] packageIds);

    /**
     * 删除包裹订单信息信息
     *
     * @param packageId 包裹订单信息ID
     * @return 结果
     */
    public int deleteActPackageById(Long packageId);
}