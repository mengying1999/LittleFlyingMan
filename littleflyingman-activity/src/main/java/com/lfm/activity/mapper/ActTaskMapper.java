package com.lfm.activity.mapper;

import java.util.List;
import com.lfm.activity.domain.ActTask;

/**
 * 任务信息Mapper接口
 *
 * @author zjz
 * @date 2020-11-09
 */
public interface ActTaskMapper
{
    /**
     * 查询任务信息
     *
     * @param taskId 任务信息ID
     * @return 任务信息
     */
    public ActTask selectActTaskById(Long taskId);

    /**
     * 查询任务信息列表
     *
     * @param actTask 任务信息
     * @return 任务信息集合
     */
    public List<ActTask> selectActTaskList(ActTask actTask);

    /**
     * 新增任务信息
     *
     * @param actTask 任务信息
     * @return 结果
     */
    public int insertActTask(ActTask actTask);

    /**
     * 修改任务信息
     *
     * @param actTask 任务信息
     * @return 结果
     */
    public int updateActTask(ActTask actTask);

    /**
     * 删除任务信息
     *
     * @param taskId 任务信息ID
     * @return 结果
     */
    public int deleteActTaskById(Long taskId);

    /**
     * 批量删除任务信息
     *
     * @param taskIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteActTaskByIds(Long[] taskIds);
}
