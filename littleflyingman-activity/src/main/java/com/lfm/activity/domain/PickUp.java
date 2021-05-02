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
 * 打印订单对象 pick_up
 * 
 * @author zjz
 * @date 2021-05-02
 */
public class PickUp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 取件Id */
    private Long pickUpId;

    /** 学生Id */
    @Excel(name = "学生Id")
    private Long studentId;

    /** 取件码 */
    @Excel(name = "取件码")
    private String takeCode;

    /** 收件人 */
    @Excel(name = "收件人")
    private String takeName;

    /** 取件地址 */
    @Excel(name = "取件地址")
    private String address;

    /** 取件订单状态(0下单 1支付 2派送 3收货 4取消) */
    @Excel(name = "取件订单状态(0下单 1支付 2派送 3收货 4取消)")
    private String status;

    /** 收件联系电话 */
    @Excel(name = "收件联系电话")
    private String takePhone;

    /** 代取员工Id */
    @Excel(name = "代取员工Id")
    private Long userPickId;

    /** 取衣对象 */
    @Excels({
            @Excel(name = "派送人名称", targetAttr = "userName", type = Excel.Type.EXPORT)
    })
    private SysUser userPick;

    /** 学生备注 */
    @Excel(name = "学生备注")
    private String studentRemark;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String studentName;

    /** 配送地址id */
    @Excel(name = "配送地址id")
    private Long addressId;

    /** 地址信息 */
    @Excel(name = "配送地址信息")
    private String dAddress;

    /** 取货人手机号 */
    @Excel(name = "配送取货人手机号")
    private String dTakeNumber;

    /** 取货人姓名 */
    @Excel(name = "配送取货人姓名")
    private String dTakeName;

    /** 金额 */
    @Excel(name = "金额")
    private Long fee;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 配送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "配送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deliveryTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finishTime;

    /** 取消时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "取消时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cancelTime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setPickUpId(Long pickUpId) 
    {
        this.pickUpId = pickUpId;
    }

    public SysUser getUserPick() {
        return userPick;
    }

    public void setUserPick(SysUser userPick) {
        this.userPick = userPick;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getdAddress() {
        return dAddress;
    }

    public void setdAddress(String dAddress) {
        this.dAddress = dAddress;
    }

    public String getdTakeNumber() {
        return dTakeNumber;
    }

    public void setdTakeNumber(String dTakeNumber) {
        this.dTakeNumber = dTakeNumber;
    }

    public String getdTakeName() {
        return dTakeName;
    }

    public void setdTakeName(String dTakeName) {
        this.dTakeName = dTakeName;
    }

    public Long getPickUpId()
    {
        return pickUpId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setTakeCode(String takeCode) 
    {
        this.takeCode = takeCode;
    }

    public String getTakeCode() 
    {
        return takeCode;
    }
    public void setTakeName(String takeName) 
    {
        this.takeName = takeName;
    }

    public String getTakeName() 
    {
        return takeName;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setTakePhone(String takePhone) 
    {
        this.takePhone = takePhone;
    }

    public String getTakePhone() 
    {
        return takePhone;
    }
    public void setUserPickId(Long userPickId) 
    {
        this.userPickId = userPickId;
    }

    public Long getUserPickId() 
    {
        return userPickId;
    }
    public void setStudentRemark(String studentRemark) 
    {
        this.studentRemark = studentRemark;
    }

    public String getStudentRemark() 
    {
        return studentRemark;
    }
    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setFee(Long fee) 
    {
        this.fee = fee;
    }

    public Long getFee() 
    {
        return fee;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setDeliveryTime(Date deliveryTime) 
    {
        this.deliveryTime = deliveryTime;
    }

    public Date getDeliveryTime() 
    {
        return deliveryTime;
    }
    public void setFinishTime(Date finishTime) 
    {
        this.finishTime = finishTime;
    }

    public Date getFinishTime() 
    {
        return finishTime;
    }
    public void setCancelTime(Date cancelTime) 
    {
        this.cancelTime = cancelTime;
    }

    public Date getCancelTime() 
    {
        return cancelTime;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pickUpId", getPickUpId())
            .append("studentId", getStudentId())
            .append("takeCode", getTakeCode())
            .append("takeName", getTakeName())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("takePhone", getTakePhone())
            .append("userPickId", getUserPickId())
            .append("studentRemark", getStudentRemark())
            .append("addressId", getAddressId())
            .append("fee", getFee())
            .append("payTime", getPayTime())
            .append("deliveryTime", getDeliveryTime())
            .append("finishTime", getFinishTime())
            .append("cancelTime", getCancelTime())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("delFlag", getDelFlag())
            .toString();
    }
}
