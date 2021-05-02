package com.lfm.activity.service.impl;

import java.util.Date;
import java.util.List;

import com.lfm.activity.domain.DshOrder;
import com.lfm.activity.domain.PickUp;
import com.lfm.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lfm.activity.mapper.ActTaskMapper;
import com.lfm.activity.domain.ActTask;
import com.lfm.activity.service.IActTaskService;

/**
 * 任务信息Service业务层处理
 * 
 * @author zjz
 * @date 2021-05-02
 */
@Service
public class ActTaskServiceImpl implements IActTaskService 
{
    @Autowired
    private ActTaskMapper actTaskMapper;
    @Autowired
    private DelayService delayService;
    /**
     * 查询任务信息
     * 
     * @param taskId 任务信息ID
     * @return 任务信息
     */
    @Override
    public ActTask selectActTaskById(Long taskId)
    {
        return actTaskMapper.selectActTaskById(taskId);
    }

    /**
     * 查询任务信息列表
     * 
     * @param actTask 任务信息
     * @return 任务信息
     */
    @Override
    public List<ActTask> selectActTaskList(ActTask actTask)
    {
        return actTaskMapper.selectActTaskList(actTask);
    }

    /**
     * 新增任务信息
     * 
     * @param actTask 任务信息
     * @return 结果
     */
    @Override
    public int insertActTask(ActTask actTask)
    {
        actTask.setCreateTime(DateUtils.getNowDate());
        return actTaskMapper.insertActTask(actTask);
    }

    /**
     * 修改任务信息
     * 
     * @param actTask 任务信息
     * @return 结果
     */
    @Override
    public int updateActTask(ActTask actTask)
    {
        actTask.setUpdateTime(DateUtils.getNowDate());
        return actTaskMapper.updateActTask(actTask);
    }

    /**
     * 批量删除任务信息
     * 
     * @param taskIds 需要删除的任务信息ID
     * @return 结果
     */
    @Override
    public int deleteActTaskByIds(Long[] taskIds)
    {
        return actTaskMapper.deleteActTaskByIds(taskIds);
    }

    /**
     * 删除任务信息信息
     * 
     * @param taskId 任务信息ID
     * @return 结果
     */
    @Override
    public int deleteActTaskById(Long taskId)
    {
        return actTaskMapper.deleteActTaskById(taskId);
    }

    @Override
    public int updateAgree(ActTask actTask) {
        ActTask temp = actTaskMapper.selectActTaskById(actTask.getTaskId());
        if("0".equals(temp.getStatus())){
            actTask.setCheckTime(new Date());
            actTask.setStatus("1");
            int flag = actTaskMapper.updateActTask(actTask);
        } else {
            return 0;
        }
        return 1;
    }

    @Override
    public int updateCancel(ActTask actTask) {
        ActTask temp = actTaskMapper.selectActTaskById(actTask.getTaskId());
        if("0".equals(temp.getStatus())){
            actTask.setCheckTime(new Date());
            actTask.setCancelTime(new Date());
            actTask.setStatus("5");
            int flag = actTaskMapper.updateActTask(actTask);
        } else {
            return 0;
        }
        return 1;
    }
}
