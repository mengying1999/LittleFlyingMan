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
 * 学院表 sys_college
 *
 */
public class SysCollege extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学院ID */
    private Long collegeId;

    /** 学校ID */
    private Long parentId;

    /** 祖级列表 */
    private String ancestors;

    /** 学院名称 */
    private String collegeName;

    /** 显示顺序 */
    private String orderNum;

    /** 学院状态:0正常,1停用 */
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 子学院 */
    private List<SysCollege> children = new ArrayList<SysCollege>();

    public Long getCollegeId()
    {
        return collegeId;
    }

    public void setCollegeId(Long collegeId)
    {
        this.collegeId = collegeId;
    }

    public Long getParentId()
    {
        return parentId;
    }

    public void setParentId(Long parentId)
    {
        this.parentId = parentId;
    }

    @NotBlank(message = "学院名称不能为空")
    @Size(min = 0, max = 30, message = "学院名称长度不能超过30个字符")
    public String getCollegeName()
    {
        return collegeName;
    }

    public void setCollegeName(String collegeName)
    {
        this.collegeName = collegeName;
    }

    @NotBlank(message = "显示顺序不能为空")
    public String getOrderNum()
    {
        return orderNum;
    }

    public void setOrderNum(String orderNum)
    {
        this.orderNum = orderNum;
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

    public String getAncestors()
    {
        return ancestors;
    }

    public void setAncestors(String ancestors)
    {
        this.ancestors = ancestors;
    }

    public List<SysCollege> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysCollege> children)
    {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("collegeId", getCollegeId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("collegeName", getCollegeName())
            .append("orderNum", getOrderNum())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
