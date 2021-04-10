package com.lfm.system.service.impl;

import com.lfm.common.annotation.DataScope;
import com.lfm.common.constant.UserConstants;
import com.lfm.common.core.domain.TreeSelect;
import com.lfm.common.core.domain.entity.SysSchool;
import com.lfm.common.core.domain.entity.SysRole;
import com.lfm.common.exception.CustomException;
import com.lfm.common.utils.StringUtils;
import com.lfm.system.mapper.SysSchoolMapper;
import com.lfm.system.mapper.SysRoleMapper;
import com.lfm.system.service.ISysSchoolService;
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
public class SysSchoolServiceImpl implements ISysSchoolService
{
    @Autowired
    private SysSchoolMapper schoolMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 查询学院管理数据
     * 
     * @param school 学院信息
     * @return 学院信息集合
     */
    @Override
    @DataScope(schoolAlias = "d")
    public List<SysSchool> selectSchoolList(SysSchool school)
    {
        return schoolMapper.selectSchoolList(school);
    }

    /**
     * 根据学院ID查询信息
     * 
     * @param schoolId 学院ID
     * @return 学院信息
     */
    @Override
    public SysSchool selectSchoolById(Long schoolId)
    {
        return schoolMapper.selectSchoolById(schoolId);
    }


    /**
     * 查询学院是否存在用户
     * 
     * @param schoolId 学院ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkSchoolExistUser(Long schoolId)
    {
        int result = schoolMapper.checkSchoolExistUser(schoolId);
        return result > 0 ? true : false;
    }

    /**
     * 校验学院名称是否唯一
     * 
     * @param school 学院信息
     * @return 结果
     */
    @Override
    public String checkSchoolNameUnique(SysSchool school)
    {
        Long schoolId = StringUtils.isNull(school.getSchoolId()) ? -1L : school.getSchoolId();
        SysSchool info = schoolMapper.checkSchoolNameUnique(school.getSchoolName());
        if (StringUtils.isNotNull(info) && info.getSchoolId().longValue() != schoolId.longValue())
        {
            return UserConstants.NOT_UNIQUE;
        }
        return UserConstants.UNIQUE;
    }

    /**
     * 新增保存学院信息
     * 
     * @param school 学院信息
     * @return 结果
     */
    @Override
    public int insertSchool(SysSchool school)
    {
        return schoolMapper.insertSchool(school);
    }

    /**
     * 修改保存学院信息
     *
     * @param school 学院信息
     * @return 结果
     */
    @Override
    public int updateSchool(SysSchool school)
    {
        int result = schoolMapper.updateSchool(school);
        return result;
    }

    /**
     * 删除学院管理信息
     * 
     * @param schoolId 学院ID
     * @return 结果
     */
    @Override
    public int deleteSchoolById(Long schoolId)
    {
        return schoolMapper.deleteSchoolById(schoolId);
    }

    @Override
    public List<Integer> selectSchoolListByRoleId(Long roleId) {
        SysRole role = roleMapper.selectRoleById(roleId);
        return schoolMapper.selectSchoolListByRoleId(roleId);
    }

}
