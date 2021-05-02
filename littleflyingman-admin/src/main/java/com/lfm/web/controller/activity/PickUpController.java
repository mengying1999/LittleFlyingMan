package com.lfm.web.controller.activity;

import java.util.List;

import com.lfm.activity.domain.Washing;
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
import com.lfm.activity.domain.PickUp;
import com.lfm.activity.service.IPickUpService;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.common.core.page.TableDataInfo;

/**
 * 打印订单Controller
 * 
 * @author zjz
 * @date 2021-05-02
 */
@RestController
@RequestMapping("/activity/up")
public class PickUpController extends BaseController
{
    @Autowired
    private IPickUpService pickUpService;

    /**
     * 查询取件订单列表
     */
    @PreAuthorize("@ss.hasPermi('activity:up:list')")
    @GetMapping("/list")
    public TableDataInfo list(PickUp pickUp)
    {
        startPage();
        List<PickUp> list = pickUpService.selectPickUpList(pickUp);
        return getDataTable(list);
    }

    /**
     * 导出取件订单列表
     */
    @PreAuthorize("@ss.hasPermi('activity:up:export')")
    @Log(title = "取件订单", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(PickUp pickUp)
    {
        List<PickUp> list = pickUpService.selectPickUpList(pickUp);
        ExcelUtil<PickUp> util = new ExcelUtil<PickUp>(PickUp.class);
        return util.exportExcel(list, "up");
    }

    /**
     * 获取取件订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('activity:up:query')")
    @GetMapping(value = "/{pickUpId}")
    public AjaxResult getInfo(@PathVariable("pickUpId") Long pickUpId)
    {
        return AjaxResult.success(pickUpService.selectPickUpById(pickUpId));
    }

    /**
     * 新增取件订单
     */
    @PreAuthorize("@ss.hasPermi('activity:up:add')")
    @Log(title = "取件订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PickUp pickUp)
    {
        return toAjax(pickUpService.insertPickUp(pickUp));
    }

    /**
     * 修改取件订单
     */
    @PreAuthorize("@ss.hasPermi('activity:up:edit')")
    @Log(title = "取件订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PickUp pickUp)
    {
        return toAjax(pickUpService.updatePickUp(pickUp));
    }


    /**
     *  修改为清洗状态
     */
    @ApiOperation("修改为派送状态")
    @PreAuthorize("@ss.hasPermi('activity:up:edit')")
    @Log(title = "修改为派送状态", businessType = BusinessType.UPDATE)
    @PutMapping("editDeliveryStatus")
    public AjaxResult editDeliveryStatus(@RequestBody PickUp pickUp)
    {
        return toAjax(pickUpService.updateDeliveryStatus(pickUp));
    }

    /**
     *  修改为取消状态
     */
    @ApiOperation("修改为取消状态")
    @PreAuthorize("@ss.hasPermi('activity:up:edit')")
    @Log(title = "修改为取消状态", businessType = BusinessType.UPDATE)
    @PutMapping("editCancelStatus")
    public AjaxResult editCancelStatus(@RequestBody PickUp pickUp)
    {
        return toAjax(pickUpService.updateCancelStatus(pickUp));
    }


    /**
     * 删除取件订单
     */
    @PreAuthorize("@ss.hasPermi('activity:up:remove')")
    @Log(title = "取件订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{pickUpIds}")
    public AjaxResult remove(@PathVariable Long[] pickUpIds)
    {
        return toAjax(pickUpService.deletePickUpByIds(pickUpIds));
    }
}
