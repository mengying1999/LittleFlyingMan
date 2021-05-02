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
 * 洗衣订单对象 washing
 * 
 * @author zjz
 * @date 2021-05-02
 */
public class Washing extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 洗衣Id */
    private Long washingId;

    /** 学生Id */
    @Excel(name = "学生Id")
    private Long studentId;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String studentName;

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

    /** 清洗类型(0干洗 1水洗 2去渍 3熨烫 4消毒） */
    @Excel(name = "清洗类型(0干洗 1水洗 2去渍 3熨烫 4消毒）")
    private String washType;

    /** 衣物类型（普通织物、纤细织物、厚实织物、毛衣类织物） */
    @Excel(name = "衣物类型", readConverterExp = "普=通织物、纤细织物、厚实织物、毛衣类织物")
    private String clothesType;

    /** 衣物数量 */
    @Excel(name = "衣物数量")
    private Long clothesNumber;

    /** 金额 */
    @Excel(name = "金额")
    private Long fee;

    /** 学生备注 */
    @Excel(name = "学生备注")
    private String studentRemark;

    /** 清洗订单状态(0下单 1支付 2接单 3上门取件 4洗衣 5派送 6收货 7取消) */
    @Excel(name = "清洗订单状态(0下单 1支付 2接单 3上门取件 4洗衣 5派送 6收货 7取消)")
    private String status;

    /** 接单员工id */
    @Excel(name = "接单员工id")
    private Long userTakeId;

    /** 接单员工对象 */
    @Excels({
            @Excel(name = "接单人名称", targetAttr = "userName", type = Excel.Type.EXPORT)
    })
    private SysUser userTake;

    /** 接衣服员工id */
    @Excel(name = "接衣服员工id")
    private Long userFetchId;

    /** 取衣对象 */
    @Excels({
            @Excel(name = "取衣人名称", targetAttr = "userName", type = Excel.Type.EXPORT)
    })
    private SysUser userFetch;

    /** 配送衣服员工id */
    @Excel(name = "配送衣服员工id")
    private Long userDeliveryId;

    /** 取衣对象 */
    @Excels({
            @Excel(name = "派送人名称", targetAttr = "userName", type = Excel.Type.EXPORT)
    })
    private SysUser userDelivery;

    /** 清洗衣服员工id */
    @Excel(name = "清洗衣服员工id")
    private Long userWashingId;

    /** 取衣对象 */
    @Excels({
            @Excel(name = "清洗人名称", targetAttr = "userName", type = Excel.Type.EXPORT)
    })
    private SysUser userWashing;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 接单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "接单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date takeTime;

    /** 取衣服时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "取衣服时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fetchTime;

    /** 清洗时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "清洗时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date washingTime;

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

    public void setWashingId(Long washingId) 
    {
        this.washingId = washingId;
    }

    public Long getWashingId() 
    {
        return washingId;
    }
    public void setStudentId(Long studentId) 
    {
        this.studentId = studentId;
    }

    public Long getStudentId() 
    {
        return studentId;
    }
    public void setAddressId(Long addressId) 
    {
        this.addressId = addressId;
    }

    public Long getAddressId() 
    {
        return addressId;
    }
    public void setWashType(String washType) 
    {
        this.washType = washType;
    }

    public String getWashType() 
    {
        return washType;
    }
    public void setClothesType(String clothesType) 
    {
        this.clothesType = clothesType;
    }

    public String getClothesType() 
    {
        return clothesType;
    }
    public void setClothesNumber(Long clothesNumber) 
    {
        this.clothesNumber = clothesNumber;
    }

    public Long getClothesNumber() 
    {
        return clothesNumber;
    }
    public void setFee(Long fee) 
    {
        this.fee = fee;
    }

    public SysUser getUserTake() {
        return userTake;
    }

    public void setUserTake(SysUser userTake) {
        this.userTake = userTake;
    }

    public SysUser getUserFetch() {
        return userFetch;
    }

    public void setUserFetch(SysUser userFetch) {
        this.userFetch = userFetch;
    }

    public SysUser getUserDelivery() {
        return userDelivery;
    }

    public void setUserDelivery(SysUser userDelivery) {
        this.userDelivery = userDelivery;
    }

    public SysUser getUserWashing() {
        return userWashing;
    }

    public void setUserWashing(SysUser userWashing) {
        this.userWashing = userWashing;
    }

    public Long getFee()
    {
        return fee;
    }
    public void setStudentRemark(String studentRemark) 
    {
        this.studentRemark = studentRemark;
    }

    public String getStudentRemark() 
    {
        return studentRemark;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setUserTakeId(Long userTakeId) 
    {
        this.userTakeId = userTakeId;
    }

    public Long getUserTakeId() 
    {
        return userTakeId;
    }
    public void setUserFetchId(Long userFetchId) 
    {
        this.userFetchId = userFetchId;
    }

    public Long getUserFetchId() 
    {
        return userFetchId;
    }
    public void setUserDeliveryId(Long userDeliveryId) 
    {
        this.userDeliveryId = userDeliveryId;
    }

    public Long getUserDeliveryId() 
    {
        return userDeliveryId;
    }
    public void setUserWashingId(Long userWashingId) 
    {
        this.userWashingId = userWashingId;
    }

    public Long getUserWashingId() 
    {
        return userWashingId;
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
    public void setFetchTime(Date fetchTime) 
    {
        this.fetchTime = fetchTime;
    }

    public Date getFetchTime() 
    {
        return fetchTime;
    }
    public void setWashingTime(Date washingTime) 
    {
        this.washingTime = washingTime;
    }

    public Date getWashingTime() 
    {
        return washingTime;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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
            .append("washingId", getWashingId())
            .append("studentId", getStudentId())
            .append("addressId", getAddressId())
            .append("washType", getWashType())
            .append("clothesType", getClothesType())
            .append("clothesNumber", getClothesNumber())
            .append("fee", getFee())
            .append("studentRemark", getStudentRemark())
            .append("status", getStatus())
            .append("userTakeId", getUserTakeId())
            .append("userFetchId", getUserFetchId())
            .append("userDeliveryId", getUserDeliveryId())
            .append("userWashingId", getUserWashingId())
            .append("payTime", getPayTime())
            .append("takeTime", getTakeTime())
            .append("fetchTime", getFetchTime())
            .append("washingTime", getWashingTime())
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
