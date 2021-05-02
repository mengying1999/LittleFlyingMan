package com.lfm.activity.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lfm.common.annotation.Excel;
import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.BaseEntity;
import com.lfm.common.annotation.Excel.Type;
import com.lfm.common.core.domain.entity.SysStudent;
import com.lfm.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.List;
/**
 * 反馈对象 sys_feedback
 *
 * @author zjz
 * @date 2021-05-02
 */
public class SysFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long feedbackId;

    /** 执行状态（0正常 1失败） */
    @Excel(name = "执行状态", readConverterExp = "0=正常,1=失败")
    private String status;

    /** 反馈人ID */
    @Excel(name = "反馈人ID")
    private Long studentId;
    /** 学生ID */
    @Excel(name = "反馈人Name")
    private String studentName;

    /** 处理人ID */
    @Excel(name = "处理人ID")
    private Long userManageId;
    /** 派送员工对象 */
    @Excels({
            @Excel(name = "处理人名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userManage;
    /** 处理意见 */
    @Excel(name = "处理意见")
    private String manageContent;
    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    private ActPrint actPrint;
    private PickUp pickUp;
    private Washing washing;
    private ActTask actTask;
    /** 订单类型（0打印 1洗衣 2取件 3任务） */
    @Excel(name = "订单类型", readConverterExp = "0=打印,1=洗衣,2=取件,3=任务")
    private String orderType;

    /** 反馈内容 */
    @Excel(name = "反馈内容")
    private String feedbackContent;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manageTime;
    /** 反馈媒体 */
    private List<SysFeedbackMedia> sysFeedbackMedias;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public SysUser getUserManage() {
        return userManage;
    }

    public void setUserManage(SysUser userManage) {
        this.userManage = userManage;
    }

    public ActPrint getActPrint() {
        return actPrint;
    }

    public void setActPrint(ActPrint actPrint) {
        this.actPrint = actPrint;
    }

    public PickUp getPickUp() {
        return pickUp;
    }

    public void setPickUp(PickUp pickUp) {
        this.pickUp = pickUp;
    }

    public Washing getWashing() {
        return washing;
    }

    public void setWashing(Washing washing) {
        this.washing = washing;
    }

    public ActTask getActTask() {
        return actTask;
    }

    public void setActTask(ActTask actTask) {
        this.actTask = actTask;
    }

    public List<SysFeedbackMedia> getSysFeedbackMedias() {
        return sysFeedbackMedias;
    }

    public void setSysFeedbackMedias(List<SysFeedbackMedia> sysFeedbackMedias) {
        this.sysFeedbackMedias = sysFeedbackMedias;
    }

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
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setUserManageId(Long userManageId)
    {
        this.userManageId = userManageId;
    }

    public Long getUserManageId()
    {
        return userManageId;
    }
    public void setManageContent(String manageContent)
    {
        this.manageContent = manageContent;
    }

    public String getManageContent()
    {
        return manageContent;
    }
    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Long getOrderId()
    {
        return orderId;
    }
    public void setOrderType(String orderType)
    {
        this.orderType = orderType;
    }

    public String getOrderType()
    {
        return orderType;
    }
    public void setFeedbackContent(String feedbackContent)
    {
        this.feedbackContent = feedbackContent;
    }

    public String getFeedbackContent()
    {
        return feedbackContent;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }
    public void setManageTime(Date manageTime)
    {
        this.manageTime = manageTime;
    }

    public Date getManageTime()
    {
        return manageTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("feedbackId", getFeedbackId())
                .append("status", getStatus())
                .append("studentId", getStudentId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("userManageId", getUserManageId())
                .append("updateBy", getUpdateBy())
                .append("manageContent", getManageContent())
                .append("updateTime", getUpdateTime())
                .append("orderId", getOrderId())
                .append("remark", getRemark())
                .append("orderType", getOrderType())
                .append("feedbackContent", getFeedbackContent())
                .append("delFlag", getDelFlag())
                .append("manageTime", getManageTime())
                .toString();
    }
}