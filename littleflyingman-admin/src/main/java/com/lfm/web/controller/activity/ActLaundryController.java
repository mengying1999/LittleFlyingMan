package com.lfm.web.controller.activity;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
import com.lfm.activity.domain.ActLaundry;
import com.lfm.activity.service.IActLaundryService;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.common.core.page.TableDataInfo;

/**
 * 洗衣订单信息Controller
 *
 * @author zjz
 * @date 2020-11-09
 */
@Api("洗衣订单管理")
@RestController
@RequestMapping("/activity/laundry")
public class ActLaundryController extends BaseController
{
    @Autowired
    private IActLaundryService actLaundryService;

    /**
     * 查询洗衣订单信息列表
     */
    @ApiOperation("查询洗衣订单信息列表")
    @PreAuthorize("@ss.hasPermi('activity:laundry:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActLaundry actLaundry)
    {
        startPage();
        List<ActLaundry> list = actLaundryService.selectActLaundryList(actLaundry);
        return getDataTable(list);
    }

    /**
     * 导出洗衣订单信息列表
     */
    @ApiOperation("导出洗衣订单信息列表")
    @PreAuthorize("@ss.hasPermi('activity:laundry:export')")
    @Log(title = "洗衣订单信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ActLaundry actLaundry)
    {
        List<ActLaundry> list = actLaundryService.selectActLaundryList(actLaundry);
        ExcelUtil<ActLaundry> util = new ExcelUtil<ActLaundry>(ActLaundry.class);
        return util.exportExcel(list, "laundry");
    }

    /**
     * 获取洗衣订单信息详细信息
     */
    @ApiOperation("获取洗衣订单信息详细信息")
    @PreAuthorize("@ss.hasPermi('activity:laundry:query')")
    @GetMapping(value = "/{laundryId}")
    public AjaxResult getInfo(@PathVariable("laundryId") Long laundryId)
    {
        return AjaxResult.success(actLaundryService.selectActLaundryById(laundryId));
    }

    /**
     * 新增洗衣订单信息
     */
    @ApiOperation("新增洗衣订单信息")
    @PreAuthorize("@ss.hasPermi('activity:laundry:add')")
    @Log(title = "洗衣订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActLaundry actLaundry)
    {
        return toAjax(actLaundryService.insertActLaundry(actLaundry));
    }

    /**
     * 修改洗衣订单信息
     */
    @ApiOperation("修改洗衣订单信息")
    @PreAuthorize("@ss.hasPermi('activity:laundry:edit')")
    @Log(title = "洗衣订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActLaundry actLaundry)
    {
        return toAjax(actLaundryService.updateActLaundry(actLaundry));
    }

    /**
     * 删除洗衣订单信息
     */
    @ApiOperation("删除洗衣订单信息")
    @PreAuthorize("@ss.hasPermi('activity:laundry:remove')")
    @Log(title = "洗衣订单信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{laundryIds}")
    public AjaxResult remove(@PathVariable Long[] laundryIds)
    {
        return toAjax(actLaundryService.deleteActLaundryByIds(laundryIds));
    }
}
