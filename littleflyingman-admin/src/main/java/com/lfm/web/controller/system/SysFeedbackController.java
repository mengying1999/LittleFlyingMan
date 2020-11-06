package com.lfm.web.controller.system;

import com.lfm.common.annotation.Log;
import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.AjaxResult;
import com.lfm.common.core.domain.entity.SysDictType;
import com.lfm.common.core.page.TableDataInfo;
import com.lfm.common.enums.BusinessType;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.system.domain.SysFeedback;
import com.lfm.system.service.ISysDictTypeService;
import com.lfm.system.service.ISysFeedbackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 反馈Controller
 *
 * @author zjz
 * @date 2020-11-04
 */
@Api("反馈管理")
@RestController
@RequestMapping("/system/feedback")
public class SysFeedbackController extends BaseController
{
    @Autowired
    private ISysFeedbackService sysFeedbackService;

    /**
     * 查询反馈列表
     */
    @ApiOperation("获取反馈列表")
    @PreAuthorize("@ss.hasPermi('system:feedback:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFeedback sysFeedback)
    {
        startPage();
        List<SysFeedback> list = sysFeedbackService.selectSysFeedbackList(sysFeedback);
        return getDataTable(list);
    }

    /**
     * 导出反馈列表
     */
    @ApiOperation("导出反馈列表")
    @PreAuthorize("@ss.hasPermi('system:feedback:export')")
    @Log(title = "反馈", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(SysFeedback sysFeedback)
    {
        List<SysFeedback> list = sysFeedbackService.selectSysFeedbackList(sysFeedback);
        ExcelUtil<SysFeedback> util = new ExcelUtil<SysFeedback>(SysFeedback.class);
        return util.exportExcel(list, "feedback");
    }

    /**
     * 获取反馈详细信息
     */
    @ApiOperation("获取反馈详情信息")
    @PreAuthorize("@ss.hasPermi('system:feedback:query')")
    @GetMapping(value = "/{feedbackId}")
    public AjaxResult getInfo(@PathVariable("feedbackId") Long feedbackId)
    {
        return AjaxResult.success(sysFeedbackService.selectSysFeedbackById(feedbackId));
    }

    /**
     * 新增反馈
     */
    @ApiOperation("新增反馈信息")
    @PreAuthorize("@ss.hasPermi('system:feedback:add')")
    @Log(title = "反馈", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFeedback sysFeedback)
    {
        return toAjax(sysFeedbackService.insertSysFeedback(sysFeedback));
    }

    /**
     * 修改反馈
     */
    @ApiOperation("修改反馈信息")
    @PreAuthorize("@ss.hasPermi('system:feedback:edit')")
    @Log(title = "反馈", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFeedback sysFeedback)
    {
        return toAjax(sysFeedbackService.updateSysFeedback(sysFeedback));
    }

    /**
     * 删除反馈
     */
    @PreAuthorize("@ss.hasPermi('system:feedback:remove')")
    @Log(title = "反馈", businessType = BusinessType.DELETE)
    @DeleteMapping("/{feedbackIds}")
    public AjaxResult remove(@PathVariable Long[] feedbackIds)
    {
        return toAjax(sysFeedbackService.deleteSysFeedbackByIds(feedbackIds));
    }
}
