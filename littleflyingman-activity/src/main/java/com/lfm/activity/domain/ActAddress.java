package com.lfm.activity.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel;
import com.lfm.common.core.domain.BaseEntity;

/**
 * 地址对象 act_address
 *
 * @author zjz
 * @date 2020-11-07
 */
public class ActAddress extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 地址id */
    private Long addressId;

    /** 学生id */
    @Excel(name = "学生id")
    private Long studentId;

    /** 地址信息 */
    @Excel(name = "地址信息")
    private String address;

    /** 取货人手机号 */
    @Excel(name = "取货人手机号")
    private String takeNumber;

    /** 取货人姓名 */
    @Excel(name = "取货人姓名")
    private String takeName;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setAddressId(Long addressId)
    {
        this.addressId = addressId;
    }

    public Long getAddressId()
    {
        return addressId;
    }
    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setTakeNumber(String takeNumber)
    {
        this.takeNumber = takeNumber;
    }

    public String getTakeNumber()
    {
        return takeNumber;
    }
    public void setTakeName(String takeName)
    {
        this.takeName = takeName;
    }

    public String getTakeName()
    {
        return takeName;
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
                .append("addressId", getAddressId())
                .append("studentId", getStudentId())
                .append("address", getAddress())
                .append("takeNumber", getTakeNumber())
                .append("takeName", getTakeName())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
