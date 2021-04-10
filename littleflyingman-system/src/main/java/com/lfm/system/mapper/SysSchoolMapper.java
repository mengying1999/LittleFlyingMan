package com.lfm.system.mapper;

import com.lfm.common.core.domain.entity.SysSchool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学院管理 数据层
 * 
 *
 */
public interface SysSchoolMapper
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
     * @return 结果
     */
    public int checkSchoolExistUser(Long schoolId);

    /**
     * 校验学院名称是否唯一
     *
     * @param schoolName 学院名称
     * @return 结果
     */
    public SysSchool checkSchoolNameUnique(@Param("schoolName") String schoolName);

    /**
     * 新增学院信息
     * 
     * @param school 学院信息
     * @return 结果
     */
    public int insertSchool(SysSchool school);

    /**
     * 修改学院信息
     * 
     * @param school 学院信息
     * @return 结果
     */
    public int updateSchool(SysSchool school);

    /**
     * 修改所在学院的父级学院状态
     * 
     * @param school 学院
     */
    public void updateSchoolStatus(SysSchool school);


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
    public List<Integer> selectSchoolListByRoleId(@Param("roleId") Long roleId);

}
