package com.lfm.system.mapper;

import com.lfm.system.domain.SysRoleSchool;

import java.util.List;

/**
 * 角色与学院关联表 数据层
 * 
 *
 */
public interface SysRoleSchoolMapper
{
    /**
     * 通过角色ID删除角色和学院关联
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteRoleSchoolByRoleId(Long roleId);

    /**
     * 批量删除角色学院关联信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRoleSchool(Long[] ids);

    /**
     * 查询学院使用数量
     * 
     * @param schoolId 学院ID
     * @return 结果
     */
    public int selectCountRoleSchoolBySchoolId(Long schoolId);

    /**
     * 批量新增角色学院信息
     * 
     * @param roleSchoolList 角色学院列表
     * @return 结果
     */
    public int batchRoleSchool(List<SysRoleSchool> roleSchoolList);
}
