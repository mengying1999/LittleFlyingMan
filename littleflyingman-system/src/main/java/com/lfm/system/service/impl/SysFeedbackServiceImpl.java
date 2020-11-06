package com.lfm.system.service.impl;

import com.lfm.common.utils.DateUtils;
import com.lfm.system.domain.SysFeedback;
import com.lfm.system.mapper.SysDictDataMapper;
import com.lfm.system.mapper.SysFeedbackMapper;
import com.lfm.system.service.ISysFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 反馈Service业务层处理
 *
 * @author zjz
 * @date 2020-11-04
 */
@Service
public class SysFeedbackServiceImpl implements ISysFeedbackService
{
    @Autowired
    private SysFeedbackMapper sysFeedbackMapper;

    /**
     * 查询反馈
     *
     * @param feedbackId 反馈ID
     * @return 反馈
     */
    @Override
    public SysFeedback selectSysFeedbackById(Long feedbackId)
    {
        return sysFeedbackMapper.selectSysFeedbackById(feedbackId);
    }

    /**
     * 查询反馈列表
     *
     * @param sysFeedback 反馈
     * @return 反馈
     */
    @Override
    public List<SysFeedback> selectSysFeedbackList(SysFeedback sysFeedback)
    {
        return sysFeedbackMapper.selectSysFeedbackList(sysFeedback);
    }

    /**
     * 新增反馈
     *
     * @param sysFeedback 反馈
     * @return 结果
     */
    @Override
    public int insertSysFeedback(SysFeedback sysFeedback)
    {
        sysFeedback.setCreateTime(DateUtils.getNowDate());
        return sysFeedbackMapper.insertSysFeedback(sysFeedback);
    }

    /**
     * 修改反馈
     *
     * @param sysFeedback 反馈
     * @return 结果
     */
    @Override
    public int updateSysFeedback(SysFeedback sysFeedback)
    {
        sysFeedback.setUpdateTime(DateUtils.getNowDate());
        return sysFeedbackMapper.updateSysFeedback(sysFeedback);
    }

    /**
     * 批量删除反馈
     *
     * @param feedbackIds 需要删除的反馈ID
     * @return 结果
     */
    @Override
    public int deleteSysFeedbackByIds(Long[] feedbackIds)
    {
        return sysFeedbackMapper.deleteSysFeedbackByIds(feedbackIds);
    }

    /**
     * 删除反馈信息
     *
     * @param feedbackId 反馈ID
     * @return 结果
     */
    @Override
    public int deleteSysFeedbackById(Long feedbackId)
    {
        return sysFeedbackMapper.deleteSysFeedbackById(feedbackId);
    }
}