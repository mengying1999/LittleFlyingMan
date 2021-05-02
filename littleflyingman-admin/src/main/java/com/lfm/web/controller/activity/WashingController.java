package com.lfm.web.controller.activity;

import java.util.List;

import com.lfm.activity.domain.ActPrint;
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
import com.lfm.activity.domain.Washing;
import com.lfm.activity.service.IWashingService;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.common.core.page.TableDataInfo;

/**
 * 洗衣订单Controller
 * 
 * @author zjz
 * @date 2021-05-02
 */
@Api("洗衣订单管理")
@RestController
@RequestMapping("/activity/washing")
public class WashingController extends BaseController
{
    @Autowired
    private IWashingService washingService;

    /**
     * 查询洗衣订单列表
     */
    @PreAuthorize("@ss.hasPermi('activity:washing:list')")
    @GetMapping("/list")
    public TableDataInfo list(Washing washing)
    {
        startPage();
        List<Washing> list = washingService.selectWashingList(washing);
        return getDataTable(list);
    }

    /**
     * 导出洗衣订单列表
     */
    @PreAuthorize("@ss.hasPermi('activity:washing:export')")
    @Log(title = "洗衣订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(Washing washing)
    {
        List<Washing> list = washingService.selectWashingList(washing);
        ExcelUtil<Washing> util = new ExcelUtil<Washing>(Washing.class);
        return util.exportExcel(list, "washing");
    }

    /**
     * 获取洗衣订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('activity:washing:query')")
    @GetMapping(value = "/{washingId}")
    public AjaxResult getInfo(@PathVariable("washingId") Long washingId)
    {
        return AjaxResult.success(washingService.selectWashingById(washingId));
    }

    /**
     * 新增洗衣订单
     */
    @PreAuthorize("@ss.hasPermi('activity:washing:add')")
    @Log(title = "洗衣订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Washing washing)
    {
        return toAjax(washingService.insertWashing(washing));
    }

    /**
     * 修改洗衣订单
     */
    @PreAuthorize("@ss.hasPermi('activity:washing:edit')")
    @Log(title = "洗衣订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Washing washing)
    {
        return toAjax(washingService.updateWashing(washing));
    }


    /**
     *  修改为打印状态
     */
    @ApiOperation("修改为接单状态")
    @PreAuthorize("@ss.hasPermi('activity:washing:edit')")
    @Log(title = "修改为接单状态", businessType = BusinessType.UPDATE)
    @PutMapping("editTakeStatus")
    public AjaxResult editTakeStatus(@RequestBody Washing washing)
    {
        return toAjax(washingService.updateTakeStatus(washing));
    }


    /**
     *  修改为取衣状态
     */
    @ApiOperation("修改为取衣状态")
    @PreAuthorize("@ss.hasPermi('activity:washing:edit')")
    @Log(title = "修改为取衣状态", businessType = BusinessType.UPDATE)
    @PutMapping("editFetchStatus")
    public AjaxResult editFetchStatus(@RequestBody Washing washing)
    {
        return toAjax(washingService.updateFetchStatus(washing));
    }

    /**
     *  修改为清洗状态
     */
    @ApiOperation("修改为清洗状态")
    @PreAuthorize("@ss.hasPermi('activity:washing:edit')")
    @Log(title = "修改为清洗状态", businessType = BusinessType.UPDATE)
    @PutMapping("editWashingStatus")
    public AjaxResult editWashingStatus(@RequestBody Washing washing)
    {
        return toAjax(washingService.updateWashingStatus(washing));
    }

    /**
     *  修改为清洗状态
     */
    @ApiOperation("修改为派送状态")
    @PreAuthorize("@ss.hasPermi('activity:washing:edit')")
    @Log(title = "修改为派送状态", businessType = BusinessType.UPDATE)
    @PutMapping("editDeliveryStatus")
    public AjaxResult editDeliveryStatus(@RequestBody Washing washing)
    {
        return toAjax(washingService.updateDeliveryStatus(washing));
    }


    /**
     *  修改为取消状态
     */
    @ApiOperation("修改为取消状态")
    @PreAuthorize("@ss.hasPermi('activity:washing:edit')")
    @Log(title = "修改为取消状态", businessType = BusinessType.UPDATE)
    @PutMapping("editCancelStatus")
    public AjaxResult editCancelStatus(@RequestBody Washing washing)
    {
        return toAjax(washingService.updateCancelStatus(washing));
    }

    /**
     * 删除洗衣订单
     */
    @PreAuthorize("@ss.hasPermi('activity:washing:remove')")
    @Log(title = "洗衣订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{washingIds}")
    public AjaxResult remove(@PathVariable Long[] washingIds)
    {
        return toAjax(washingService.deleteWashingByIds(washingIds));
    }
}
