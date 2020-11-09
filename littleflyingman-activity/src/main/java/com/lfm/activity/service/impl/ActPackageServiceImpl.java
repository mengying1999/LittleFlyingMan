package com.lfm.activity.service.impl;

import java.util.List;
import com.lfm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lfm.activity.mapper.ActPackageMapper;
import com.lfm.activity.domain.ActPackage;
import com.lfm.activity.service.IActPackageService;

/**
 * 包裹订单信息Service业务层处理
 *
 * @author zjz
 * @date 2020-11-09
 */
@Service
public class ActPackageServiceImpl implements IActPackageService
{
    @Autowired
    private ActPackageMapper actPackageMapper;

    /**
     * 查询包裹订单信息
     *
     * @param packageId 包裹订单信息ID
     * @return 包裹订单信息
     */
    @Override
    public ActPackage selectActPackageById(Long packageId)
    {
        return actPackageMapper.selectActPackageById(packageId);
    }

    /**
     * 查询包裹订单信息列表
     *
     * @param actPackage 包裹订单信息
     * @return 包裹订单信息
     */
    @Override
    public List<ActPackage> selectActPackageList(ActPackage actPackage)
    {
        return actPackageMapper.selectActPackageList(actPackage);
    }

    /**
     * 新增包裹订单信息
     *
     * @param actPackage 包裹订单信息
     * @return 结果
     */
    @Override
    public int insertActPackage(ActPackage actPackage)
    {
        actPackage.setCreateTime(DateUtils.getNowDate());
        return actPackageMapper.insertActPackage(actPackage);
    }

    /**
     * 修改包裹订单信息
     *
     * @param actPackage 包裹订单信息
     * @return 结果
     */
    @Override
    public int updateActPackage(ActPackage actPackage)
    {
        actPackage.setUpdateTime(DateUtils.getNowDate());
        return actPackageMapper.updateActPackage(actPackage);
    }

    /**
     * 批量删除包裹订单信息
     *
     * @param packageIds 需要删除的包裹订单信息ID
     * @return 结果
     */
    @Override
    public int deleteActPackageByIds(Long[] packageIds)
    {
        return actPackageMapper.deleteActPackageByIds(packageIds);
    }

    /**
     * 删除包裹订单信息信息
     *
     * @param packageId 包裹订单信息ID
     * @return 结果
     */
    @Override
    public int deleteActPackageById(Long packageId)
    {
        return actPackageMapper.deleteActPackageById(packageId);
    }
}
