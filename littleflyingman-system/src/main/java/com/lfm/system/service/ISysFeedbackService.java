package com.lfm.system.service;

import com.lfm.common.core.domain.entity.SysDictType;
import com.lfm.system.domain.SysFeedback;

import java.util.List;

/**
 * 反馈管理 服务层
 */
public interface ISysFeedbackService {

    /**
     * 查询反馈管理数据
     *
     * @param feedback 反馈信息
     * @return 反馈信息集合
     */
    public List<SysFeedback> selectFeedbackList(SysFeedback feedback);
}
