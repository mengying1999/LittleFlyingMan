package com.lfm.web.controller.feedback;

import com.lfm.common.annotation.Log;
import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.AjaxResult;
import com.lfm.common.core.page.TableDataInfo;
import com.lfm.common.enums.BusinessType;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.feedback.domain.Feedback;
import com.lfm.feedback.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 反馈管理Controller
 * 
 * @author zjz
 * @date 2020-10-24
 */
@RestController
@RequestMapping("/feedback/feedback")
public class FeedbackController extends BaseController
{
    @Autowired
    private IFeedbackService feedbackService;

    /**
     * 查询反馈管理列表
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(Feedback feedback)
    {
        startPage();
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        return getDataTable(list);
    }

    /**
     * 导出反馈管理列表
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:export')")
    @Log(title = "反馈管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Feedback feedback)
    {
        List<Feedback> list = feedbackService.selectFeedbackList(feedback);
        ExcelUtil<Feedback> util = new ExcelUtil<Feedback>(Feedback.class);
        return util.exportExcel(list, "feedback");
    }

    /**
     * 获取反馈管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(feedbackService.selectFeedbackById(id));
    }

    /**
     * 新增反馈管理
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:add')")
    @Log(title = "反馈管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.insertFeedback(feedback));
    }

    /**
     * 修改反馈管理
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:edit')")
    @Log(title = "反馈管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Feedback feedback)
    {
        return toAjax(feedbackService.updateFeedback(feedback));
    }

    /**
     * 删除反馈管理
     */
    @PreAuthorize("@ss.hasPermi('feedback:feedback:remove')")
    @Log(title = "反馈管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(feedbackService.deleteFeedbackByIds(ids));
    }
}
