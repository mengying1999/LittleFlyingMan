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
import com.lfm.activity.domain.ActPackage;
import com.lfm.activity.service.IActPackageService;
import com.lfm.common.utils.poi.ExcelUtil;
import com.lfm.common.core.page.TableDataInfo;

/**
 * 包裹订单信息Controller
 *
 * @author zjz
 * @date 2020-11-09
 */
@RestController
@RequestMapping("/activity/package")
public class ActPackageController extends BaseController
{
    @Autowired
    private IActPackageService actPackageService;

    /**
     * 查询包裹订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('activity:package:list')")
    @GetMapping("/list")
    public TableDataInfo list(ActPackage actPackage)
    {
        startPage();
        List<ActPackage> list = actPackageService.selectActPackageList(actPackage);
        return getDataTable(list);
    }

    /**
     * 导出包裹订单信息列表
     */
    @PreAuthorize("@ss.hasPermi('activity:package:export')")
    @Log(title = "包裹订单信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ActPackage actPackage)
    {
        List<ActPackage> list = actPackageService.selectActPackageList(actPackage);
        ExcelUtil<ActPackage> util = new ExcelUtil<ActPackage>(ActPackage.class);
        return util.exportExcel(list, "package");
    }

    /**
     * 获取包裹订单信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('activity:package:query')")
    @GetMapping(value = "/{packageId}")
    public AjaxResult getInfo(@PathVariable("packageId") Long packageId)
    {
        return AjaxResult.success(actPackageService.selectActPackageById(packageId));
    }

    /**
     * 新增包裹订单信息
     */
    @PreAuthorize("@ss.hasPermi('activity:package:add')")
    @Log(title = "包裹订单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ActPackage actPackage)
    {
        return toAjax(actPackageService.insertActPackage(actPackage));
    }

    /**
     * 修改包裹订单信息
     */
    @PreAuthorize("@ss.hasPermi('activity:package:edit')")
    @Log(title = "包裹订单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ActPackage actPackage)
    {
        return toAjax(actPackageService.updateActPackage(actPackage));
    }

    /**
     * 删除包裹订单信息
     */
    @PreAuthorize("@ss.hasPermi('activity:package:remove')")
    @Log(title = "包裹订单信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{packageIds}")
    public AjaxResult remove(@PathVariable Long[] packageIds)
    {
        return toAjax(actPackageService.deleteActPackageByIds(packageIds));
    }
}
