package com.lfm.system.service.impl;

import com.lfm.common.annotation.DataScope;
import com.lfm.common.constant.UserConstants;
import com.lfm.common.core.domain.TreeSelect;
import com.lfm.common.core.domain.entity.SysCollege;
import com.lfm.common.core.domain.entity.SysRole;
import com.lfm.common.exception.CustomException;
import com.lfm.common.utils.StringUtils;
import com.lfm.system.mapper.SysCollegeMapper;
import com.lfm.system.mapper.SysRoleMapper;
import com.lfm.system.service.ISysCollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 学院管理 服务实现
 * 
 *
 */
@Service
public class SysCollegeServiceImpl implements ISysCollegeService
{
    @Autowired
    private SysCollegeMapper collegeMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 查询学院管理数据
     * 
     * @param college 学院信息
     * @return 学院信息集合
     */
    @Override
    @DataScope(collegeAlias = "d")
    public List<SysCollege> selectCollegeList(SysCollege college)
    {
        return collegeMapper.selectCollegeList(college);
    }

    /**
     * 构建前端所需要树结构
     * 
     * @param colleges 学院列表
     * @return 树结构列表
     */
    @Override
    public List<SysCollege> buildCollegeTree(List<SysCollege> colleges)
    {
        List<SysCollege> returnList = new ArrayList<SysCollege>();
        List<Long> tempList = new ArrayList<Long>();
        for (SysCollege college : colleges)
        {
            tempList.add(college.getCollegeId());
        }
        for (Iterator<SysCollege> iterator = colleges.iterator(); iterator.hasNext();)
        {
            SysCollege college = (SysCollege) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(college.getParentId()))
            {
                recursionFn(colleges, college);
                returnList.add(college);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = colleges;
        }
        return returnList;
    }

    /**
     * 构建前端所需要下拉树结构
     * 
     * @param colleges 学院列表
     * @return 下拉树结构列表
     */
    @Override
    public List<TreeSelect> buildCollegeTreeSelect(List<SysCollege> colleges)
    {
        List<SysCollege> collegeTrees = buildCollegeTree(colleges);
        return collegeTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    /**
     * 根据角色ID查询学院树信息
     * 
     * @param roleId 角色ID
     * @return 选中学院列表
     */
    @Override
    public List<Integer> selectCollegeListByRoleId(Long roleId)
    {
        SysRole role = roleMapper.selectRoleById(roleId);
        return collegeMapper.selectCollegeListByRoleId(roleId, role.isCollegeCheckStrictly());
    }

    /**
     * 根据学院ID查询信息
     * 
     * @param collegeId 学院ID
     * @return 学院信息
     */
    @Override
    public SysCollege selectCollegeById(Long collegeId)
    {
        return collegeMapper.selectCollegeById(collegeId);
    }

    /**
     * 根据ID查询所有子学院（正常状态）
     *
     * @param collegeId 学院ID
     * @return 子学院数
     */
    @Override
    public int selectNormalChildrenCollegeById(Long collegeId)
    {
        return collegeMapper.selectNormalChildrenCollegeById(collegeId);
    }

    /**
     * 是否存在子节点
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    @Override
    public boolean hasChildByCollegeId(Long collegeId)
    {
        int result = collegeMapper.hasChildByCollegeId(collegeId);
        return result > 0 ? true : false;
    }

    /**
     * 查询学院是否存在用户
     * 
     * @param collegeId 学院ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkCollegeExistUser(Long collegeId)
    {
        int result = collegeMapper.checkCollegeExistUser(collegeId);
        return result > 0 ? true : false;
    }

    /**
     * 校验学院名称是否唯一
     * 
     * @param college 学院信息
     * @return 结果
     */
    @Override
    public String checkCollegeNameUnique(SysCollege college)
    {
        Long collegeId = StringUtils.isNull(college.getCollegeId()) ? -1L : college.getCollegeId();
        SysCollege info = collegeMapper.checkCollegeNameUnique(college.getCollegeName(), college.getParentId());
        if (StringUtils.isNotNull(info) && info.getCollegeId().longValue() != collegeId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存学院信息
     * 
     * @param college 学院信息
     * @return 结果
     */
    @Override
    public int insertCollege(SysCollege college)
    {
        SysCollege info = collegeMapper.selectCollegeById(college.getParentId());
        // 如果父节点不为正常状态,则不允许新增子节点
        if (!UserConstants.DEPT_NORMAL.equals(info.getStatus()))
        {
            throw new CustomException("学院停用，不允许新增");
        }
//        college.setAncestors(info.getAncestors() + "," + college.getParentId());
        return collegeMapper.insertCollege(college);
    }

    /**
     * 修改保存学院信息
     *
     * @param college 学院信息
     * @return 结果
     */
    @Override
    public int updateCollege(SysCollege college)
    {
        SysCollege newParentCollege = collegeMapper.selectCollegeById(college.getParentId());
        SysCollege oldCollege = collegeMapper.selectCollegeById(college.getCollegeId());
        if (StringUtils.isNotNull(newParentCollege) && StringUtils.isNotNull(oldCollege))
        {
            String newAncestors = newParentCollege.getAncestors() + "," + newParentCollege.getCollegeId();
            String oldAncestors = oldCollege.getAncestors();
            college.setAncestors(newAncestors);
            updateCollegeChildren(college.getCollegeId(), newAncestors, oldAncestors);
        }
        int result = collegeMapper.updateCollege(college);
        if (UserConstants.DEPT_NORMAL.equals(college.getStatus()))
        {
            // 如果该学院是启用状态，则启用该学院的所有上级学院
            updateParentCollegeStatus(college);
        }
        return result;
    }

    /**
     * 修改该学院的父级学院状态
     * 
     * @param college 当前学院
     */
    private void updateParentCollegeStatus(SysCollege college)
    {
        String updateBy = college.getUpdateBy();
        college = collegeMapper.selectCollegeById(college.getCollegeId());
        college.setUpdateBy(updateBy);
        collegeMapper.updateCollegeStatus(college);
    }

    /**
     * 修改子元素关系
     *
     * @param collegeId 被修改的学院ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateCollegeChildren(Long collegeId, String newAncestors, String oldAncestors)
    {
        List<SysCollege> children = collegeMapper.selectChildrenCollegeById(collegeId);
        for (SysCollege child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            collegeMapper.updateCollegeChildren(children);
        }
    }

    /**
     * 删除学院管理信息
     * 
     * @param collegeId 学院ID
     * @return 结果
     */
    @Override
    public int deleteCollegeById(Long collegeId)
    {
        return collegeMapper.deleteCollegeById(collegeId);
    }

    @Override
    public List<SysCollege> selectShoolCollegeList(SysCollege college) {
        college.setParentId((long) 0);
        return collegeMapper.selectCollegeList(college);
    }

    /**
     * 递归列表
     */
    private void recursionFn(List<SysCollege> list, SysCollege t)
    {
        // 得到子节点列表
        List<SysCollege> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysCollege tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SysCollege> getChildList(List<SysCollege> list, SysCollege t)
    {
        List<SysCollege> tlist = new ArrayList<SysCollege>();
        Iterator<SysCollege> it = list.iterator();
        while (it.hasNext())
        {
            SysCollege n = (SysCollege) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getCollegeId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysCollege> list, SysCollege t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
