package com.lfm.activity.domain;

import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.annotation.Excel.Type;
import com.lfm.common.core.domain.BaseEntity;

/**
 * 包裹订单信息对象 act_package
 *
 * @author zjz
 * @date 2020-11-09
 */
public class ActPackage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 包裹id */
    private Long packageId;

    /** 学生id */
    @Excel(name = "学生id")
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

    /** 配送人员Id */
    @Excel(name = "配送人员Id")
    private Long userDeliveryId;

    /** 配送人员 */
    @Excels({
            @Excel(name = "配送人员名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userDelivery;

    /** 取件码 */
    @Excel(name = "取件码")
    private String packageInfo;

    /** 包裹大小(0小件 1大件 2超大件) */
    @Excel(name = "包裹大小(0小件 1大件 2超大件)")
    private String packageSize;

    /** 顾客备注 */
    @Excel(name = "顾客备注")
    private String customerRemark;

    /** 订单状态(0下单 1接单 2派送 3支付 4完成) */
    @Excel(name = "订单状态(0下单 1接单 2派送 3支付 4完成)")
    private String status;

    /** 费用 */
    @Excel(name = "费用")
    private Long fee;

    public void setPackageId(Long packageId)
    {
        this.packageId = packageId;
    }

    public Long getPackageId()
    {
        return packageId;
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
    public void setUserDeliveryId(Long userDeliveryId)
    {
        this.userDeliveryId = userDeliveryId;
    }

    public Long getUserDeliveryId()
    {
        return userDeliveryId;
    }
    public void setPackageInfo(String packageInfo)
    {
        this.packageInfo = packageInfo;
    }

    public String getPackageInfo()
    {
        return packageInfo;
    }
    public void setPackageSize(String packageSize)
    {
        this.packageSize = packageSize;
    }

    public String getPackageSize()
    {
        return packageSize;
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

    public SysUser getUserDelivery() {
        return userDelivery;
    }

    public void setUserDelivery(SysUser userDelivery) {
        this.userDelivery = userDelivery;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("packageId", getPackageId())
                .append("studentId", getStudentId())
                .append("addressId", getAddressId())
                .append("userDeliveryId", getUserDeliveryId())
                .append("packageInfo", getPackageInfo())
                .append("packageSize", getPackageSize())
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
                .append("userDelivery", getUserDelivery())
                .toString();
    }
}
