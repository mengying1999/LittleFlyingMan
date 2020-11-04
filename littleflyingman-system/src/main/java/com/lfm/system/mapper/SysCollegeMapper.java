package com.lfm.system.mapper;

import com.lfm.common.core.domain.entity.SysCollege;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学院管理 数据层
 * 
 *
 */
public interface SysCollegeMapper
{
    /**
     * 查询学院管理数据
     * 
     * @param college 学院信息
     * @return 学院信息集合
     */
    public List<SysCollege> selectCollegeList(SysCollege college);

    /**
     * 根据角色ID查询学院树信息
     * 
     * @param roleId 角色ID
     * @param collegeCheckStrictly 学院树选择项是否关联显示
     * @return 选中学院列表
     */
    public List<Integer> selectCollegeListByRoleId(@Param("roleId") Long roleId, @Param("collegeCheckStrictly") boolean collegeCheckStrictly);

    /**
     * 根据学院ID查询信息
     * 
     * @param collegeId 学院ID
     * @return 学院信息
     */
    public SysCollege selectCollegeById(Long collegeId);

    /**
     * 根据ID查询所有子学院
     * 
     * @param collegeId 学院ID
     * @return 学院列表
     */
    public List<SysCollege> selectChildrenCollegeById(Long collegeId);

    /**
     * 根据ID查询所有子学院（正常状态）
     * 
     * @param collegeId 学院ID
     * @return 子学院数
     */
    public int selectNormalChildrenCollegeById(Long collegeId);

    /**
     * 是否存在子节点
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    public int hasChildByCollegeId(Long collegeId);

    /**
     * 查询学院是否存在用户
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    public int checkCollegeExistUser(Long collegeId);

    /**
     * 校验学院名称是否唯一
     * 
     * @param collegeName 学院名称
     * @param parentId 父学院ID
     * @return 结果
     */
    public SysCollege checkCollegeNameUnique(@Param("collegeName") String collegeName, @Param("parentId") Long parentId);

    /**
     * 新增学院信息
     * 
     * @param college 学院信息
     * @return 结果
     */
    public int insertCollege(SysCollege college);

    /**
     * 修改学院信息
     * 
     * @param college 学院信息
     * @return 结果
     */
    public int updateCollege(SysCollege college);

    /**
     * 修改所在学院的父级学院状态
     * 
     * @param college 学院
     */
    public void updateCollegeStatus(SysCollege college);

    /**
     * 修改子元素关系
     * 
     * @param colleges 子元素
     * @return 结果
     */
    public int updateCollegeChildren(@Param("colleges") List<SysCollege> colleges);

    /**
     * 删除学院管理信息
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    public int deleteCollegeById(Long collegeId);

}
