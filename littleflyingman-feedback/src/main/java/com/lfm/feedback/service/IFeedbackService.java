package com.lfm.feedback.service;

import java.util.List;
import com.lfm.feedback.domain.Feedback;

/**
 * 反馈管理Service接口
 * 
 * @author zjz
 * @date 2020-10-24
 */
public interface IFeedbackService 
{
    /**
     * 查询反馈管理
     * 
     * @param id 反馈管理ID
     * @return 反馈管理
     */
    public Feedback selectFeedbackById(Long id);

    /**
     * 查询反馈管理列表
     * 
     * @param feedback 反馈管理
     * @return 反馈管理集合
     */
    public List<Feedback> selectFeedbackList(Feedback feedback);

    /**
     * 新增反馈管理
     * 
     * @param feedback 反馈管理
     * @return 结果
     */
    public int insertFeedback(Feedback feedback);

    /**
     * 修改反馈管理
     * 
     * @param feedback 反馈管理
     * @return 结果
     */
    public int updateFeedback(Feedback feedback);

    /**
     * 批量删除反馈管理
     * 
     * @param ids 需要删除的反馈管理ID
     * @return 结果
     */
    public int deleteFeedbackByIds(Long[] ids);

    /**
     * 删除反馈管理信息
     * 
     * @param id 反馈管理ID
     * @return 结果
     */
    public int deleteFeedbackById(Long id);
}
