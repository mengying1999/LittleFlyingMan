package com.lfm.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色和学院关联 sys_role_college
 * 
 *
 */
public class SysRoleCollege
{
    /** 角色ID */
    private Long roleId;
    
    /** 学院ID */
    private Long collegeId;

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getCollegeId()
    {
        return collegeId;
    }

    public void setCollegeId(Long collegeId)
    {
        this.collegeId = collegeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("collegeId", getCollegeId())
            .toString();
    }
}
