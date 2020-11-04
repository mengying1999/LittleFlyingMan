package com.lfm.system.domain;
import com.lfm.common.annotation.Excel;
import com.lfm.common.annotation.Excel.ColumnType;
import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.BaseEntity;
import com.lfm.common.core.domain.entity.SysCollege;
import com.lfm.common.annotation.Excel.Type;
import com.lfm.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 反馈对象 sys_feedback
 *
 * @author zjz
 * @date 2020-11-02
 */
public class SysFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long feedbackId;

    /** 执行状态（0正常 1失败） */
    @Excel(name = "执行状态", readConverterExp = "0=正常,1=失败")
    private String status;

    /** 反馈内容 */
    @Excel(name = "反馈内容")
    private String feedbackContent;

    /** 用户ID */
    @Excel(name = "用户ID")
    private Long userId;

    /** 用户对象 */
    @Excels({
            @Excel(name = "用户名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser user;


    /** 反馈媒体 */
    private List<SysFeedbackMedia> sysFeedbackMedias;

    /** 是否匿名（0不匿名 1匿名） */
    @Excel(name = "是否匿名", readConverterExp = "0=不匿名,1=匿名")
    private String anonymityFlag;

    public void setFeedbackId(Long feedbackId)
    {
        this.feedbackId = feedbackId;
    }

    public Long getFeedbackId()
    {
        return feedbackId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setFeedbackContent(String feedbackContent)
    {
        this.feedbackContent = feedbackContent;
    }

    public String getFeedbackContent()
    {
        return feedbackContent;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setAnonymityFlag(String anonymityFlag)
    {
        this.anonymityFlag = anonymityFlag;
    }

    public String getAnonymityFlag()
    {
        return anonymityFlag;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<SysFeedbackMedia> getSysFeedbackMedias() {
        return sysFeedbackMedias;
    }

    public void setSysFeedbackMedias(List<SysFeedbackMedia> sysFeedbackMedias) {
        this.sysFeedbackMedias = sysFeedbackMedias;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("feedbackId", getFeedbackId())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("feedbackContent", getFeedbackContent())
                .append("userId", getUserId())
                .append("anonymityFlag", getAnonymityFlag())
                .append("user", getUser())
                .append("feedbackMedias", getSysFeedbackMedias())
                .toString();
    }
}