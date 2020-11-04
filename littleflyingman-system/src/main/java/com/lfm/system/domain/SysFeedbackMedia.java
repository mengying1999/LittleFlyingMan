package com.lfm.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.core.domain.BaseEntity;

/**
 * 反馈媒体对象 sys_feedback_media
 *
 * @author zjz
 * @date 2020-11-02
 */
public class SysFeedbackMedia extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long feedbackMediaId;

    /** 执行状态（0正常 1失败） */
    @Excel(name = "执行状态", readConverterExp = "0=正常,1=失败")
    private String status;

    /** 反馈媒体url */
    @Excel(name = "反馈媒体url")
    private String feedbackMediaUrl;

    /** 反馈ID */
    @Excel(name = "反馈ID")
    private Long feedbackId;

    public void setFeedbackMediaId(Long feedbackMediaId)
    {
        this.feedbackMediaId = feedbackMediaId;
    }

    public Long getFeedbackMediaId()
    {
        return feedbackMediaId;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setFeedbackMediaUrl(String feedbackMediaUrl)
    {
        this.feedbackMediaUrl = feedbackMediaUrl;
    }

    public String getFeedbackMediaUrl()
    {
        return feedbackMediaUrl;
    }
    public void setFeedbackId(Long feedbackId)
    {
        this.feedbackId = feedbackId;
    }

    public Long getFeedbackId()
    {
        return feedbackId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("feedbackMediaId", getFeedbackMediaId())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("feedbackMediaUrl", getFeedbackMediaUrl())
                .append("feedbackId", getFeedbackId())
                .toString();
    }
}
