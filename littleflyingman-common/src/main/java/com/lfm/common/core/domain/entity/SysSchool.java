package com.lfm.common.core.domain.entity;

import com.lfm.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * 学校表 sys_school
 *
 */
public class SysSchool extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学校ID */
    private Long schoolId;

    /** 学校名称 */
    private String schoolName;

    /** 学校状态:0正常,1停用 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public Long getSchoolId()
    {
        return schoolId;
    }

    public void setSchoolId(Long schoolId)
    {
        this.schoolId = schoolId;
    }

    @NotBlank(message = "学院名称不能为空")
    @Size(min = 0, max = 30, message = "学院名称长度不能超过30个字符")
    public String getSchoolName()
    {
        return schoolName;
    }

    public void setSchoolName(String schoolName)
    {
        this.schoolName = schoolName;
    }


    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("schoolId", getSchoolId())
            .append("schoolName", getSchoolName())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
