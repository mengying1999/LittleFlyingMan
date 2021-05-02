package com.lfm.activity.mapper;

import java.util.List;
import com.lfm.activity.domain.PickUp;

/**
 * 打印订单Mapper接口
 * 
 * @author zjz
 * @date 2021-05-02
 */
public interface PickUpMapper 
{
    /**
     * 查询打印订单
     * 
     * @param pickUpId 打印订单ID
     * @return 打印订单
     */
    public PickUp selectPickUpById(Long pickUpId);

    /**
     * 查询打印订单列表
     * 
     * @param pickUp 打印订单
     * @return 打印订单集合
     */
    public List<PickUp> selectPickUpList(PickUp pickUp);

    /**
     * 新增打印订单
     * 
     * @param pickUp 打印订单
     * @return 结果
     */
    public int insertPickUp(PickUp pickUp);

    /**
     * 修改打印订单
     * 
     * @param pickUp 打印订单
     * @return 结果
     */
    public int updatePickUp(PickUp pickUp);

    /**
     * 删除打印订单
     * 
     * @param pickUpId 打印订单ID
     * @return 结果
     */
    public int deletePickUpById(Long pickUpId);

    /**
     * 批量删除打印订单
     * 
     * @param pickUpIds 需要删除的数据ID
     * @return 结果
     */
    public int deletePickUpByIds(Long[] pickUpIds);
}
