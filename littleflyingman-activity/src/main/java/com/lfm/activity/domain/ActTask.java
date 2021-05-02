package com.lfm.activity.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.core.domain.BaseEntity;

/**
 * 任务信息对象 act_task
 * 
 * @author zjz
 * @date 2021-05-02
 */
public class ActTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 发起人id */
    @Excel(name = "发起人id")
    private Long studentSendId;
    /** 学生名称 */
    @Excel(name = "发起学生名称")
    private String studentSendName;
    /** 实现人id */
    @Excel(name = "实现人id")
    private Long studentRealizeId;
    /** 学生名称 */
    @Excel(name = "实现学生名称")
    private String studentRealizeName;

    /** 订单状态(0下单 1审核 2 接单 3完成 4支付 5取消) */
    @Excel(name = "订单状态(0下单 1审核 2 接单 3完成 4支付 5取消)")
    private String status;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String taskDescribe;

    /** 费用 */
    @Excel(name = "费用")
    private Long fee;

    /** 配送地址id */
    @Excel(name = "配送地址id")
    private Long addressId;

    /** 任务标题 */
    @Excel(name = "任务标题")
    private String taskTitle;

    /** 审核人id */
    @Excel(name = "审核人id")
    private Long userCheckId;

    public String getStudentSendName() {
        return studentSendName;
    }

    public void setStudentSendName(String studentSendName) {
        this.studentSendName = studentSendName;
    }

    public String getStudentRealizeName() {
        return studentRealizeName;
    }

    public void setStudentRealizeName(String studentRealizeName) {
        this.studentRealizeName = studentRealizeName;
    }

    public SysUser getUserCheck() {
        return userCheck;
    }

    public void setUserCheck(SysUser userCheck) {
        this.userCheck = userCheck;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTakeNumber() {
        return takeNumber;
    }

    public void setTakeNumber(String takeNumber) {
        this.takeNumber = takeNumber;
    }

    public String getTakeName() {
        return takeName;
    }

    public void setTakeName(String takeName) {
        this.takeName = takeName;
    }

    /** 打印员工对象 */
    @Excels({
            @Excel(name = "审核人", targetAttr = "userName", type = Excel.Type.EXPORT)
    })
    private SysUser userCheck;
    /** 地址信息 */
    @Excel(name = "地址信息")
    private String address;

    /** 取货人手机号 */
    @Excel(name = "取货人手机号")
    private String takeNumber;

    /** 取货人姓名 */
    @Excel(name = "取货人姓名")
    private String takeName;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String checkContent;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 取消时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "取消时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cancelTime;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 接单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date takeTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setStudentSendId(Long studentSendId) 
    {
        this.studentSendId = studentSendId;
    }

    public Long getStudentSendId() 
    {
        return studentSendId;
    }
    public void setStudentRealizeId(Long studentRealizeId) 
    {
        this.studentRealizeId = studentRealizeId;
    }

    public Long getStudentRealizeId() 
    {
        return studentRealizeId;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setTaskDescribe(String taskDescribe) 
    {
        this.taskDescribe = taskDescribe;
    }

    public String getTaskDescribe() 
    {
        return taskDescribe;
    }
    public void setFee(Long fee) 
    {
        this.fee = fee;
    }

    public Long getFee() 
    {
        return fee;
    }
    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setTaskTitle(String taskTitle) 
    {
        this.taskTitle = taskTitle;
    }

    public String getTaskTitle() 
    {
        return taskTitle;
    }
    public void setUserCheckId(Long userCheckId) 
    {
        this.userCheckId = userCheckId;
    }

    public Long getUserCheckId() 
    {
        return userCheckId;
    }
    public void setCheckContent(String checkContent) 
    {
        this.checkContent = checkContent;
    }

    public String getCheckContent() 
    {
        return checkContent;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setCancelTime(Date cancelTime) 
    {
        this.cancelTime = cancelTime;
    }

    public Date getCancelTime() 
    {
        return cancelTime;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setTakeTime(Date takeTime) 
    {
        this.takeTime = takeTime;
    }

    public Date getTakeTime() 
    {
        return takeTime;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }
    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskId", getTaskId())
            .append("studentSendId", getStudentSendId())
            .append("studentRealizeId", getStudentRealizeId())
            .append("status", getStatus())
            .append("taskDescribe", getTaskDescribe())
            .append("fee", getFee())
            .append("addressId", getAddressId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("taskTitle", getTaskTitle())
            .append("userCheckId", getUserCheckId())
            .append("checkContent", getCheckContent())
            .append("delFlag", getDelFlag())
            .append("cancelTime", getCancelTime())
            .append("payTime", getPayTime())
            .append("takeTime", getTakeTime())
            .append("finishTime", getFinishTime())
            .append("checkTime", getCheckTime())
            .toString();
    }
}
