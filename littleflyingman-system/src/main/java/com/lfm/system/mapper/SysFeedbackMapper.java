package com.lfm.system.mapper;

import com.lfm.system.domain.SysFeedback;

import java.util.List;

public interface SysFeedbackMapper {

    /**
     * 查询反馈管理数据
     * @param feedback
     * @return
     */
    public List<SysFeedback> selectFeedbackList(SysFeedback feedback);
}
