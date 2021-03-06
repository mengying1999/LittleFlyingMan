package com.lfm.activity.mapper;


import com.lfm.activity.domain.SysFeedback;

import java.util.List;

/**
 * 反馈Mapper接口
 *
 * @author zjz
 * @date 2020-11-04
 */
public interface SysFeedbackMapper
{
    /**
     * 查询反馈
     *
     * @param feedbackId 反馈ID
     * @return 反馈
     */
    public SysFeedback selectSysFeedbackById(Long feedbackId);

    /**
     * 查询反馈列表
     *
     * @param sysFeedback 反馈
     * @return 反馈集合
     */
    public List<SysFeedback> selectSysFeedbackList(SysFeedback sysFeedback);

    /**
     * 新增反馈
     *
     * @param sysFeedback 反馈
     * @return 结果
     */
    public int insertSysFeedback(SysFeedback sysFeedback);

    /**
     * 修改反馈
     *
     * @param sysFeedback 反馈
     * @return 结果
     */
    public int updateSysFeedback(SysFeedback sysFeedback);

    /**
     * 删除反馈
     *
     * @param feedbackId 反馈ID
     * @return 结果
     */
    public int deleteSysFeedbackById(Long feedbackId);

    /**
     * 批量删除反馈
     *
     * @param feedbackIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFeedbackByIds(Long[] feedbackIds);
}
