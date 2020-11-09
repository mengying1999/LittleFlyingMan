package com.lfm.activity.domain;

import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.entity.SysStudent;
import com.lfm.common.core.domain.entity.SysUser;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.core.domain.BaseEntity;
import com.lfm.common.annotation.Excel.Type;
/**
 * 打印订单对象 act_print
 *
 * @author zjz
 * @date 2020-11-07
 */
public class ActPrint extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 打印Id */
    private Long printId;

    /** 学生Id */
    @Excel(name = "学生Id")
    private Long studentId;

    /** 学生对象 */
    @Excels({
            @Excel(name = "学生名称", targetAttr = "studentName", type = Type.EXPORT)
    })
    private SysStudent student;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 文件url */
    @Excel(name = "文件url")
    private String fileUrl;

    /** 打印员工Id */
    @Excel(name = "打印员工Id")
    private Long userPrintId;

    /** 打印员工对象 */
    @Excels({
            @Excel(name = "打印人名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userPrint;

    /** 派送员工Id */
    @Excel(name = "派送员工Id")
    private Long userDeliveryId;

    /** 派送员工对象 */
    @Excels({
            @Excel(name = "派送人名称", targetAttr = "userName", type = Type.EXPORT)
    })
    private SysUser userDelivery;
    /** 打印数量 */
    @Excel(name = "打印数量")
    private Long printNumber;

    /** 单双面标志(0单页 1双页) */
    @Excel(name = "单双面标志(0单页 1双页)")
    private String bothSideFlag;

    /** 彩印标志(0黑白 1彩印) */
    @Excel(name = "彩印标志(0黑白 1彩印)")
    private String colorFlag;

    /** 封胶标志(0非封胶，1封胶) */
    @Excel(name = "封胶标志(0非封胶，1封胶)")
    private String sealingFlag;

    /** 纸张大小 */
    @Excel(name = "纸张大小")
    private String paperSize;

    /** 学生备注 */
    @Excel(name = "学生备注")
    private String studentRemark;

    /** 打印订单状态(0下单 1支付 2接单 3派送 4收货) */
    @Excel(name = "打印订单状态(0下单 1支付 2接单 3派送 4收货)")
    private String status;

    /** 配送地址id */
    @Excel(name = "配送地址id")
    private Long addressId;

    private ActAddress address;

    /** 封面颜色(0蓝色) */
    @Excel(name = "封面颜色(0蓝色)")
    private String coverColor;

    /** 金额 */
    @Excel(name = "金额")
    private Long fee;

    public void setPrintId(Long printId)
    {
        this.printId = printId;
    }

    public Long getPrintId()
    {
        return printId;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    public String getFileName()
    {
        return fileName;
    }
    public void setFileUrl(String fileUrl)
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl()
    {
        return fileUrl;
    }
    public void setUserPrintId(Long userPrintId)
    {
        this.userPrintId = userPrintId;
    }

    public Long getUserPrintId()
    {
        return userPrintId;
    }
    public void setUserDeliveryId(Long userDeliveryId)
    {
        this.userDeliveryId = userDeliveryId;
    }

    public Long getUserDeliveryId()
    {
        return userDeliveryId;
    }
    public void setPrintNumber(Long printNumber)
    {
        this.printNumber = printNumber;
    }

    public Long getPrintNumber()
    {
        return printNumber;
    }
    public void setBothSideFlag(String bothSideFlag)
    {
        this.bothSideFlag = bothSideFlag;
    }

    public String getBothSideFlag()
    {
        return bothSideFlag;
    }
    public void setColorFlag(String colorFlag)
    {
        this.colorFlag = colorFlag;
    }

    public String getColorFlag()
    {
        return colorFlag;
    }
    public void setSealingFlag(String sealingFlag)
    {
        this.sealingFlag = sealingFlag;
    }

    public String getSealingFlag()
    {
        return sealingFlag;
    }
    public void setPaperSize(String paperSize)
    {
        this.paperSize = paperSize;
    }

    public String getPaperSize()
    {
        return paperSize;
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
    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    public Long getAddressId()
    {
        return addressId;
    }
    public void setCoverColor(String coverColor)
    {
        this.coverColor = coverColor;
    }

    public String getCoverColor()
    {
        return coverColor;
    }
    public void setFee(Long fee)
    {
        this.fee = fee;
    }

    public Long getFee()
    {
        return fee;
    }

    public SysStudent getStudent() {
        return student;
    }

    public void setStudent(SysStudent student) {
        this.student = student;
    }

    public SysUser getUserPrint() {
        return userPrint;
    }

    public void setUserPrint(SysUser userPrint) {
        this.userPrint = userPrint;
    }

    public SysUser getUserDelivery() {
        return userDelivery;
    }

    public void setUserDelivery(SysUser userDelivery) {
        this.userDelivery = userDelivery;
    }

    public ActAddress getAddress() {
        return address;
    }

    public void setAddress(ActAddress address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("printId", getPrintId())
                .append("studentId", getStudentId())
                .append("fileName", getFileName())
                .append("fileUrl", getFileUrl())
                .append("userPrintId", getUserPrintId())
                .append("userDeliveryId", getUserDeliveryId())
                .append("printNumber", getPrintNumber())
                .append("bothSideFlag", getBothSideFlag())
                .append("colorFlag", getColorFlag())
                .append("sealingFlag", getSealingFlag())
                .append("paperSize", getPaperSize())
                .append("studentRemark", getStudentRemark())
                .append("status", getStatus())
                .append("addressId", getAddressId())
                .append("coverColor", getCoverColor())
                .append("fee", getFee())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("student", getStudent())
                .append("userPrint", getUserPrint())
                .append("userDelivery", getUserDelivery())
                .append("address", getAddress())
                .toString();
    }
}
