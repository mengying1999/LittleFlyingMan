package com.lfm.activity.service;

import java.util.List;
import com.lfm.activity.domain.ActTask;

/**
 * 任务信息Service接口
 * 
 * @author zjz
 * @date 2021-05-02
 */
public interface IActTaskService 
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
     * 批量删除任务信息
     * 
     * @param taskIds 需要删除的任务信息ID
     * @return 结果
     */
    public int deleteActTaskByIds(Long[] taskIds);

    /**
     * 删除任务信息信息
     * 
     * @param taskId 任务信息ID
     * @return 结果
     */
    public int deleteActTaskById(Long taskId);

    public int updateAgree(ActTask actTask);

    public int updateCancel(ActTask actTask);
}
