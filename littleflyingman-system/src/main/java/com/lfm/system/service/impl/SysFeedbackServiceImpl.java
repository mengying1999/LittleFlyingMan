package com.lfm.system.service.impl;

import com.lfm.system.domain.SysFeedback;
import com.lfm.system.mapper.SysDictDataMapper;
import com.lfm.system.mapper.SysFeedbackMapper;
import com.lfm.system.service.ISysFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysFeedbackServiceImpl implements ISysFeedbackService {

    @Autowired
    private SysFeedbackMapper feedbackMapper;

    /**
     * 查询反馈管理数据
     *
     * @param feedback 反馈信息
     * @return 反馈信息集合
     */
    @Override
    public List<SysFeedback> selectFeedbackList(SysFeedback feedback) {
        return feedbackMapper.selectFeedbackList(feedback);

    }
}
