package com.lfm.web.controller.activity;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lfm.common.annotation.Log;
import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.AjaxResult;
import com.lfm.common.enums.BusinessType;
import com.lfm.activity.domain.ActTask;
import com.lfm.activity.service.IActTaskService;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.common.core.page.TableDataInfo;

/**
 * 任务信息Controller
 *
 * @author zjz
 * @date 2020-11-09
 */
@RestController
@RequestMapping("/activity/task")
public class ActTaskController extends BaseController
{
    @Autowired
    private IActTaskService actTaskService;

    /**
     * 查询任务信息列表
     */
    @PreAuthorize("@ss.hasPermi('activity:task:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActTask actTask)
    {
        startPage();
        List<ActTask> list = actTaskService.selectActTaskList(actTask);
        return getDataTable(list);
    }

    /**
     * 导出任务信息列表
     */
    @PreAuthorize("@ss.hasPermi('activity:task:export')")
    @Log(title = "任务信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ActTask actTask)
    {
        List<ActTask> list = actTaskService.selectActTaskList(actTask);
        ExcelUtil<ActTask> util = new ExcelUtil<ActTask>(ActTask.class);
        return util.exportExcel(list, "task");
    }

    /**
     * 获取任务信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('activity:task:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(actTaskService.selectActTaskById(taskId));
    }

    /**
     * 新增任务信息
     */
    @PreAuthorize("@ss.hasPermi('activity:task:add')")
    @Log(title = "任务信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActTask actTask)
    {
        return toAjax(actTaskService.insertActTask(actTask));
    }

    /**
     * 修改任务信息
     */
    @PreAuthorize("@ss.hasPermi('activity:task:edit')")
    @Log(title = "任务信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActTask actTask)
    {
        return toAjax(actTaskService.updateActTask(actTask));
    }

    /**
     * 删除任务信息
     */
    @PreAuthorize("@ss.hasPermi('activity:task:remove')")
    @Log(title = "任务信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds)
    {
        return toAjax(actTaskService.deleteActTaskByIds(taskIds));
    }
}
