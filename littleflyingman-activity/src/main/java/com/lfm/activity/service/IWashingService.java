package com.lfm.activity.service;

import java.util.List;
import com.lfm.activity.domain.Washing;

/**
 * 洗衣订单Service接口
 * 
 * @author zjz
 * @date 2021-05-02
 */
public interface IWashingService 
{
    /**
     * 查询洗衣订单
     * 
     * @param washingId 洗衣订单ID
     * @return 洗衣订单
     */
    public Washing selectWashingById(Long washingId);

    /**
     * 查询洗衣订单列表
     * 
     * @param washing 洗衣订单
     * @return 洗衣订单集合
     */
    public List<Washing> selectWashingList(Washing washing);

    /**
     * 新增洗衣订单
     * 
     * @param washing 洗衣订单
     * @return 结果
     */
    public int insertWashing(Washing washing);

    /**
     * 修改洗衣订单
     * 
     * @param washing 洗衣订单
     * @return 结果
     */
    public int updateWashing(Washing washing);

    /**
     * 批量删除洗衣订单
     * 
     * @param washingIds 需要删除的洗衣订单ID
     * @return 结果
     */
    public int deleteWashingByIds(Long[] washingIds);

    /**
     * 删除洗衣订单信息
     * 
     * @param washingId 洗衣订单ID
     * @return 结果
     */
    public int deleteWashingById(Long washingId);

    public int updateTakeStatus(Washing washing);

    public int updateFetchStatus(Washing washing);

    public int updateWashingStatus(Washing washing);

    public int updateDeliveryStatus(Washing washing);

    public int updateCancelStatus(Washing washing);
}
