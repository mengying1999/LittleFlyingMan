package com.lfm.system.service;

import com.lfm.common.core.domain.TreeSelect;
import com.lfm.common.core.domain.entity.SysSchool;
import com.lfm.common.core.domain.entity.SysSchool;

import java.util.List;

/**
 * 学院管理 服务层
 * 
 *
 */
public interface ISysSchoolService
{
    /**
     * 查询学院管理数据
     * 
     * @param school 学院信息
     * @return 学院信息集合
     */
    public List<SysSchool> selectSchoolList(SysSchool school);


    /**
     * 根据学院ID查询信息
     * 
     * @param schoolId 学院ID
     * @return 学院信息
     */
    public SysSchool selectSchoolById(Long schoolId);



    /**
     * 查询学院是否存在用户
     * 
     * @param schoolId 学院ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkSchoolExistUser(Long schoolId);

    /**
     * 校验学院名称是否唯一
     * 
     * @param school 学院信息
     * @return 结果
     */
    public String checkSchoolNameUnique(SysSchool school);

    /**
     * 新增保存学院信息
     * 
     * @param school 学院信息
     * @return 结果
     */
    public int insertSchool(SysSchool school);

    /**
     * 修改保存学院信息
     * 
     * @param school 学院信息
     * @return 结果
     */
    public int updateSchool(SysSchool school);

    /**
     * 删除学院管理信息
     * 
     * @param schoolId 学院ID
     * @return 结果
     */
    public int deleteSchoolById(Long schoolId);

    /**
     * 根据角色ID查询学校信息
     *
     * @param roleId 角色ID
     * @return 选中学院列表
     */
    public List<Integer> selectSchoolListByRoleId(Long roleId);
}
