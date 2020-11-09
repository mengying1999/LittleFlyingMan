package com.lfm.common.core.domain.entity;

import com.lfm.common.annotation.Excel;
import com.lfm.common.annotation.Excels;
import com.lfm.common.core.domain.BaseEntity;
import com.lfm.common.core.domain.entity.SysCollege;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lfm.common.annotation.Excel.Type;

/**
 * 学生信息对象 sys_student
 *
 * @author zjz
 * @date 2020-11-06
 */
public class SysStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学生ID */
    private Long studentId;

    /** 学院id */
    @Excel(name = "学院id")
    private Long collegeId;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 学号 */
    @Excel(name = "学号")
    private String studentNumber;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 电话号 */
    @Excel(name = "电话号")
    private String phoneNumber;

    /** 性别（0 男 1 女 2 未知) */
    @Excel(name = "性别", readConverterExp = "性别（0 男 1 女 2 未知)")
    private String sex;

    /** 头像 */
    @Excel(name = "头像")
    private String avatar;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 账号状态（0 正常 1 停用） */
    @Excel(name = "账号状态", readConverterExp = "0=,正=常,1=,停=用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 学院对象 */
    @Excels({
            @Excel(name = "学院名称", targetAttr = "collegeName", type = Type.EXPORT)
    })
    private SysCollege college;

    public void setStudentId(Long studentId)
    {
        this.studentId = studentId;
    }

    public Long getStudentId()
    {
        return studentId;
    }
    public void setCollegeId(Long collegeId)
    {
        this.collegeId = collegeId;
    }

    public Long getCollegeId()
    {
        return collegeId;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public void setStudentNumber(String studentNumber)
    {
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber()
    {
        return studentNumber;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getSex()
    {
        return sex;
    }
    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public String getAvatar()
    {
        return avatar;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }
    public void setDelFlag(String delFlag)
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag()
    {
        return delFlag;
    }

    public SysCollege getCollege() {
        return college;
    }

    public void setCollege(SysCollege college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("studentId", getStudentId())
                .append("collegeId", getCollegeId())
                .append("studentName", getStudentName())
                .append("studentNumber", getStudentNumber())
                .append("email", getEmail())
                .append("phoneNumber", getPhoneNumber())
                .append("sex", getSex())
                .append("avatar", getAvatar())
                .append("password", getPassword())
                .append("status", getStatus())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("college", getCollege())
                .toString();
    }
}
