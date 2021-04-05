package com.lfm.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色和学院关联 sys_role_school
 * 
 *
 */
public class SysRoleSchool
{
    /** 角色ID */
    private Long roleId;
    
    /** 学院ID */
    private Long schoolId;

    public Long getRoleId()
    {
        return roleId;
    }

    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getSchoolId()
    {
        return schoolId;
    }

    public void setSchoolId(Long schoolId)
    {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("schoolId", getSchoolId())
            .toString();
    }
}
