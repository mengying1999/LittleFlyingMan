package com.lfm.web.controller.system;

import com.lfm.common.annotation.Log;
import com.lfm.common.constant.UserConstants;
import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.AjaxResult;
import com.lfm.common.core.domain.entity.SysSchool;
import com.lfm.common.core.domain.entity.SysUser;
import com.lfm.common.core.page.TableDataInfo;
import com.lfm.common.enums.BusinessType;
import com.lfm.common.utils.SecurityUtils;
import com.lfm.common.utils.StringUtils;
import com.lfm.system.service.ISysSchoolService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

/**
 * 学院信息
 * 
 *
 */
@Api("学院信息管理")
@RestController
@RequestMapping("/system/school")
public class SysSchoolController extends BaseController
{
    @Autowired
    private ISysSchoolService schoolService;

    /**
     * 获取学校列表
     */
    @ApiOperation("获取学校列表")
    @PreAuthorize("@ss.hasPermi('system:school:shoolList')")
    @GetMapping("/list")
    public TableDataInfo list(@ApiParam(value = "查询学校列表")SysSchool school)
    {
        startPage();
        List<SysSchool> list = schoolService.selectSchoolList(school);
        return getDataTable(list);
    }

//    /**
//     * 查询学院列表（排除节点）
//     */
//    @PreAuthorize("@ss.hasPermi('system:school:list')")
//    @GetMapping("/list/exclude/{schoolId}")
//    public AjaxResult excludeChild(@PathVariable(value = "schoolId", required = false) Long schoolId)
//    {
//        List<SysSchool> schools = schoolService.selectSchoolList(new SysSchool());
//        Iterator<SysSchool> it = schools.iterator();
//        while (it.hasNext())
//        {
//            SysSchool d = (SysSchool) it.next();
////            if (d.getSchoolId().intValue() == schoolId
////                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), schoolId + ""))
////            {
////                it.remove();
////            }
//        }
//        return AjaxResult.success(schools);
//    }

    /**
     * 根据学院编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:school:query')")
    @GetMapping(value = "/{schoolId}")
    public AjaxResult getInfo(@PathVariable Long schoolId)
    {
        return AjaxResult.success(schoolService.selectSchoolById(schoolId));
    }

    /**
     * 新增学院
     */
    @PreAuthorize("@ss.hasPermi('system:school:add')")
    @Log(title = "学院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysSchool school)
    {
        if (UserConstants.NOT_UNIQUE.equals(schoolService.checkSchoolNameUnique(school)))
        {
            return AjaxResult.error("新增学院'" + school.getSchoolName() + "'失败，学院名称已存在");
        }
        school.setCreateBy(SecurityUtils.getUsername());
        return toAjax(schoolService.insertSchool(school));
    }

    /**
     * 修改学院
     */
    @PreAuthorize("@ss.hasPermi('system:school:edit')")
    @Log(title = "学院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysSchool school)
    {
        if (UserConstants.NOT_UNIQUE.equals(schoolService.checkSchoolNameUnique(school)))
        {
            return AjaxResult.error("修改学院'" + school.getSchoolName() + "'失败，学院名称已存在");
        }
        school.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(schoolService.updateSchool(school));
    }

    /**
     * 删除学院
     */
    @PreAuthorize("@ss.hasPermi('system:school:remove')")
    @Log(title = "学院管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{schoolId}")
    public AjaxResult remove(@PathVariable Long schoolId)
    {
        if (schoolService.checkSchoolExistUser(schoolId))
        {
            return AjaxResult.error("学院存在用户,不允许删除");
        }
        return toAjax(schoolService.deleteSchoolById(schoolId));
    }
}
