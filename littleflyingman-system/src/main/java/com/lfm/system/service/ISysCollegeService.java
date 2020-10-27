package com.lfm.system.service;

import com.lfm.common.core.domain.TreeSelect;
import com.lfm.common.core.domain.entity.SysCollege;
import com.lfm.common.core.domain.entity.SysCollege;

import java.util.List;

/**
 * 学院管理 服务层
 * 
 *
 */
public interface ISysCollegeService
{
    /**
     * 查询学院管理数据
     * 
     * @param college 学院信息
     * @return 学院信息集合
     */
    public List<SysCollege> selectCollegeList(SysCollege college);

    /**
     * 构建前端所需要树结构
     * 
     * @param colleges 学院列表
     * @return 树结构列表
     */
    public List<SysCollege> buildCollegeTree(List<SysCollege> colleges);

    /**
     * 构建前端所需要下拉树结构
     * 
     * @param colleges 学院列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildCollegeTreeSelect(List<SysCollege> colleges);

    /**
     * 根据角色ID查询学院树信息
     * 
     * @param roleId 角色ID
     * @return 选中学院列表
     */
    public List<Integer> selectCollegeListByRoleId(Long roleId);

    /**
     * 根据学院ID查询信息
     * 
     * @param collegeId 学院ID
     * @return 学院信息
     */
    public SysCollege selectCollegeById(Long collegeId);

    /**
     * 根据ID查询所有子学院（正常状态）
     * 
     * @param collegeId 学院ID
     * @return 子学院数
     */
//    public int selectNormalChildrenCollegeById(Long collegeId);

    /**
     * 是否存在学院子节点
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    public boolean hasChildByCollegeId(Long collegeId);

    /**
     * 查询学院是否存在用户
     * 
     * @param collegeId 学院ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkCollegeExistUser(Long collegeId);

    /**
     * 校验学院名称是否唯一
     * 
     * @param college 学院信息
     * @return 结果
     */
    public String checkCollegeNameUnique(SysCollege college);

    /**
     * 新增保存学院信息
     * 
     * @param college 学院信息
     * @return 结果
     */
    public int insertCollege(SysCollege college);

    /**
     * 修改保存学院信息
     * 
     * @param college 学院信息
     * @return 结果
     */
//    public int updateCollege(SysCollege college);

    /**
     * 删除学院管理信息
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    public int deleteCollegeById(Long collegeId);

    /**
     * 获取学校列表
     * @param college
     * @return
     */
    List<SysCollege> selectShoolCollegeList(SysCollege college);
}
