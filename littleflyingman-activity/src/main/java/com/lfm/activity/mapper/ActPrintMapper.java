package com.lfm.activity.mapper;

import java.util.List;
import com.lfm.activity.domain.ActPrint;

/**
 * 打印订单Mapper接口
 *
 * @author zjz
 * @date 2020-11-07
 */
public interface ActPrintMapper
{
    /**
     * 查询打印订单
     *
     * @param printId 打印订单ID
     * @return 打印订单
     */
    public ActPrint selectActPrintById(Long printId);

    /**
     * 查询打印订单列表
     *
     * @param actPrint 打印订单
     * @return 打印订单集合
     */
    public List<ActPrint> selectActPrintList(ActPrint actPrint);

    /**
     * 新增打印订单
     *
     * @param actPrint 打印订单
     * @return 结果
     */
    public int insertActPrint(ActPrint actPrint);

    /**
     * 修改打印订单
     *
     * @param actPrint 打印订单
     * @return 结果
     */
    public int updateActPrint(ActPrint actPrint);

    /**
     * 删除打印订单
     *
     * @param printId 打印订单ID
     * @return 结果
     */
    public int deleteActPrintById(Long printId);

    /**
     * 批量删除打印订单
     *
     * @param printIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteActPrintByIds(Long[] printIds);
}
