package com.lfm.activity.domain;

import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.entity.SysStudent;
import com.lfm.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.annotation.Excel.Type;
import com.lfm.common.core.domain.BaseEntity;

/**
 * 洗衣订单信息对象 act_laundry
 *
 * @author zjz
 * @date 2020-11-09
 */
public class ActLaundry extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 洗衣订单Id */
    private Long laundryId;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentId;

    /** 学生名称 */
    @Excel(name = "学生名称")
    private String studentName;

    /** 配送地址信息 */
    @Excel(name = "配送地址信息")
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public SysUser getUserWash() {
        return userWash;
    }

    public void setUserWash(SysUser userWash) {
        this.userWash = userWash;
    }

    public SysUser getUserDelivery() {
        return userDelivery;
    }

    public void setUserDelivery(SysUser userDelivery) {
        this.userDelivery = userDelivery;
    }

    public SysUser getUserPike() {
        return userPike;
    }

    public void setUserPike(SysUser userPike) {
        this.userPike = userPike;
    }

    /** 洗衣负责人Id */
    @Excel(name = "洗衣负责人Id")
    private Long userWashId;

    /** 洗衣负责人对象 */
    @Excels({
            @Excel(name = "洗衣负责人名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userWash;

    /** 配送人员Id */
    @Excel(name = "配送人员Id")
    private Long userDeliveryId;


    /** 配送人员对象 */
    @Excels({
            @Excel(name = "配送人员名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userDelivery;


    /** 接取衣物人员Id */
    @Excel(name = "接取衣物人员Id")
    private Long userPikeId;

    /** 接取衣物人员对象 */
    @Excels({
            @Excel(name = "接取衣物人员名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userPike;

    /** 衣物类型（0普通衣物） */
    @Excel(name = "衣物类型", readConverterExp = "0=普通衣物")
    private String clothesType;

    /** 清洗类型（0正常洗 1干洗） */
    @Excel(name = "清洗类型", readConverterExp = "0=正常洗,1=干洗")
    private String washType;

    /** 衣物数量 */
    @Excel(name = "衣物数量")
    private Long clothesNumber;

    /** 顾客备注 */
    @Excel(name = "顾客备注")
    private String customerRemark;

    /** 订单状态(0下单 1支付 2接单 3清洗 4派送 5完成) */
    @Excel(name = "订单状态(0下单 1支付 2接单 3清洗 4派送 5完成)")
    private String status;

    /** 费用 */
    @Excel(name = "费用")
    private Long fee;

    public void setLaundryId(Long laundryId)
    {
        this.laundryId = laundryId;
    }

    public Long getLaundryId()
    {
        return laundryId;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setUserWashId(Long userWashId)
    {
        this.userWashId = userWashId;
    }

    public Long getUserWashId()
    {
        return userWashId;
    }
    public void setUserDeliveryId(Long userDeliveryId)
    {
        this.userDeliveryId = userDeliveryId;
    }

    public Long getUserDeliveryId()
    {
        return userDeliveryId;
    }
    public void setUserPikeId(Long userPikeId)
    {
        this.userPikeId = userPikeId;
    }

    public Long getUserPikeId()
    {
        return userPikeId;
    }
    public void setClothesType(String clothesType)
    {
        this.clothesType = clothesType;
    }

    public String getClothesType()
    {
        return clothesType;
    }
    public void setWashType(String washType)
    {
        this.washType = washType;
    }

    public String getWashType()
    {
        return washType;
    }
    public void setClothesNumber(Long clothesNumber)
    {
        this.clothesNumber = clothesNumber;
    }

    public Long getClothesNumber()
    {
        return clothesNumber;
    }
    public void setCustomerRemark(String customerRemark)
    {
        this.customerRemark = customerRemark;
    }

    public String getCustomerRemark()
    {
        return customerRemark;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setFee(Long fee)
    {
        this.fee = fee;
    }

    public Long getFee()
    {
        return fee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("laundryId", getLaundryId())
                .append("studentId", getStudentId())
                .append("userWashId", getUserWashId())
                .append("userDeliveryId", getUserDeliveryId())
                .append("userPikeId", getUserPikeId())
                .append("clothesType", getClothesType())
                .append("washType", getWashType())
                .append("clothesNumber", getClothesNumber())
                .append("customerRemark", getCustomerRemark())
                .append("status", getStatus())
                .append("fee", getFee())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("address", getAddress())
                .append("takeName",getTakeName())
                .append("takeNumber",getTakeNumber())
                .append("studentName", getStudentName())
                .append("userPike", getUserPike())
                .append("userWash", getUserWash())
                .append("userDelivery", getUserDelivery())
                .toString();
    }
}
