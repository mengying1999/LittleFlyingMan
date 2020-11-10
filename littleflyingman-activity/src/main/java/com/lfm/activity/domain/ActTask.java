package com.lfm.activity.domain;

import com.lfm.common.core.domain.entity.SysStudent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.core.domain.BaseEntity;

/**
 * 任务信息对象 act_task
 *
 * @author zjz
 * @date 2020-11-09
 */
public class ActTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务ID */
    private Long taskId;

    /** 发起人id */
    @Excel(name = "发起人id")
    private Long studentSendId;


    /** 发起人名称 */
    @Excel(name = "发起人名称")
    private String studentSendName;

    /** 实现人id */
    @Excel(name = "实现人id")
    private Long studentRealizeId;

    /** 实现人名称 */
    @Excel(name = "实现人名称")
    private String studentRealizeName;

    /** 订单状态(0下单 1接单 2支付 3完成) */
    @Excel(name = "订单状态(0下单 1接单 2支付 3完成)")
    private String status;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String taskDescribe;

    /** 费用 */
    @Excel(name = "费用")
    private Long fee;

    /** 任务类型(0跑腿) */
    @Excel(name = "任务类型(0跑腿)")
    private String taskType;

    /** 配送地址id */
    @Excel(name = "配送地址id")
    private Long addressId;

    /** 地址信息 */
    @Excel(name = "地址信息")
    private String address;

    /** 取货人手机号 */
    @Excel(name = "取货人手机号")
    private String takeNumber;

    /** 取货人姓名 */
    @Excel(name = "取货人姓名")
    private String takeName;

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
    public void setTaskType(String taskType)
    {
        this.taskType = taskType;
    }

    public String getTaskType()
    {
        return taskType;
    }
    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    public Long getAddressId()
    {
        return addressId;
    }

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("taskId", getTaskId())
                .append("studentSendId", getStudentSendId())
                .append("studentRealizeId", getStudentRealizeId())
                .append("status", getStatus())
                .append("taskDescribe", getTaskDescribe())
                .append("fee", getFee())
                .append("taskType", getTaskType())
                .append("addressId", getAddressId())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("address", getAddress())
                .append("takeName",getTakeName())
                .append("takeNumber",getTakeNumber())
                .append("studentSendName", getStudentSendName())
                .append("studentRealizeName", getStudentRealizeName())
                .toString();
    }
}
