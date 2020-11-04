package com.lfm.web.controller.system;

import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.entity.SysDictType;
import com.lfm.common.core.page.TableDataInfo;
import com.lfm.system.domain.SysFeedback;
import com.lfm.system.service.ISysDictTypeService;
import com.lfm.system.service.ISysFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 反馈管理
 */
@RestController
@RequestMapping("/system/feedback")
public class SysFeedbackController extends BaseController {
    @Autowired
    private ISysFeedbackService iSysFeedbackService;

    /**
     * 获取反馈列表
     * @param sysFeedback
     * @return
     */
    @PreAuthorize("@ss.hasPermi('system:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFeedback feedback)
    {
        startPage();
        List<SysFeedback> list = iSysFeedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }
}
