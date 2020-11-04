package com.lfm.web.controller.system;

import com.lfm.common.annotation.Log;
import com.lfm.common.constant.UserConstants;
import com.lfm.common.core.controller.BaseController;
import com.lfm.common.core.domain.AjaxResult;
import com.lfm.common.core.domain.entity.SysCollege;
import com.lfm.common.enums.BusinessType;
import com.lfm.common.utils.SecurityUtils;
import com.lfm.common.utils.StringUtils;
import com.lfm.system.service.ISysCollegeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/system/college")
public class SysCollegeController extends BaseController
{
    @Autowired
    private ISysCollegeService collegeService;

    /**
     * 获取学校列表
     */
    @ApiOperation("获取学校列表")
    @PreAuthorize("@ss.hasPermi('system:college:shoolList')")
    @GetMapping("/shoolList")
    public AjaxResult shoollist(SysCollege college)
    {
        List<SysCollege> colleges = collegeService.selectShoolCollegeList(college);
        return AjaxResult.success(colleges);
    }




    /**
     * 获取学院列表
     */
    @PreAuthorize("@ss.hasPermi('system:college:list')")
    @GetMapping("/list")
    public AjaxResult list(SysCollege college)
    {
        List<SysCollege> colleges = collegeService.selectCollegeList(college);
        return AjaxResult.success(colleges);
    }

    /**
     * 查询学院列表（排除节点）
     */
    @PreAuthorize("@ss.hasPermi('system:college:list')")
    @GetMapping("/list/exclude/{collegeId}")
    public AjaxResult excludeChild(@PathVariable(value = "collegeId", required = false) Long collegeId)
    {
        List<SysCollege> colleges = collegeService.selectCollegeList(new SysCollege());
        Iterator<SysCollege> it = colleges.iterator();
        while (it.hasNext())
        {
            SysCollege d = (SysCollege) it.next();
            if (d.getCollegeId().intValue() == collegeId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), collegeId + ""))
            {
                it.remove();
            }
        }
        return AjaxResult.success(colleges);
    }

    /**
     * 根据学院编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:college:query')")
    @GetMapping(value = "/{collegeId}")
    public AjaxResult getInfo(@PathVariable Long collegeId)
    {
        return AjaxResult.success(collegeService.selectCollegeById(collegeId));
    }

    /**
     * 获取学院下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysCollege college)
    {
        List<SysCollege> colleges = collegeService.selectCollegeList(college);
        return AjaxResult.success(collegeService.buildCollegeTreeSelect(colleges));
    }

    /**
     * 加载对应角色学院列表树
     */
    @GetMapping(value = "/roleCollegeTreeselect/{roleId}")
    public AjaxResult roleCollegeTreeselect(@PathVariable("roleId") Long roleId)
    {
        List<SysCollege> colleges = collegeService.selectCollegeList(new SysCollege());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", collegeService.selectCollegeListByRoleId(roleId));
        ajax.put("colleges", collegeService.buildCollegeTreeSelect(colleges));
        return ajax;
    }

    /**
     * 新增学院
     */
    @PreAuthorize("@ss.hasPermi('system:college:add')")
    @Log(title = "学院管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysCollege college)
    {
        if (UserConstants.NOT_UNIQUE.equals(collegeService.checkCollegeNameUnique(college)))
        {
            return AjaxResult.error("新增学院'" + college.getCollegeName() + "'失败，学院名称已存在");
        }
        college.setCreateBy(SecurityUtils.getUsername());
        return toAjax(collegeService.insertCollege(college));
    }

    /**
     * 修改学院
     */
    @PreAuthorize("@ss.hasPermi('system:college:edit')")
    @Log(title = "学院管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysCollege college)
    {
        if (UserConstants.NOT_UNIQUE.equals(collegeService.checkCollegeNameUnique(college)))
        {
            return AjaxResult.error("修改学院'" + college.getCollegeName() + "'失败，学院名称已存在");
        }
        else if (college.getParentId().equals(college.getCollegeId()))
        {
            return AjaxResult.error("修改学院'" + college.getCollegeName() + "'失败，上级学院不能是自己");
        }
        else if (StringUtils.equals(UserConstants.DEPT_DISABLE, college.getStatus())
                && collegeService.selectNormalChildrenCollegeById(college.getCollegeId()) > 0)
        {
            return AjaxResult.error("该学院包含未停用的子学院！");
        }
        college.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(collegeService.updateCollege(college));
    }

    /**
     * 删除学院
     */
    @PreAuthorize("@ss.hasPermi('system:college:remove')")
    @Log(title = "学院管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{collegeId}")
    public AjaxResult remove(@PathVariable Long collegeId)
    {
        if (collegeService.hasChildByCollegeId(collegeId))
        {
            return AjaxResult.error("存在下级学院,不允许删除");
        }
        if (collegeService.checkCollegeExistUser(collegeId))
        {
            return AjaxResult.error("学院存在用户,不允许删除");
        }
        return toAjax(collegeService.deleteCollegeById(collegeId));
    }
}
