package com.qf.member.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;

/**
    * 员工表
    */
@ApiModel(description="员工表")
@Schema(description="员工表")
public class Emp {
    /**
    * ID
    */
    @ApiModelProperty(value="ID")
    @Schema(description="ID")
    private Integer id;

    /**
    * 用户名
    */
    @ApiModelProperty(value="用户名")
    @Schema(description="用户名")
    private String username;

    /**
    * 密码
    */
    @ApiModelProperty(value="密码")
    @Schema(description="密码")
    private String password;

    /**
    * 姓名
    */
    @ApiModelProperty(value="姓名")
    @Schema(description="姓名")
    private String name;

    /**
    * 性别, 说明: 1 男, 2 女
    */
    @ApiModelProperty(value="性别, 说明: 1 男, 2 女")
    @Schema(description="性别, 说明: 1 男, 2 女")
    private Byte gender;

    /**
    * 图像
    */
    @ApiModelProperty(value="图像")
    @Schema(description="图像")
    private String image;

    /**
    * 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师
    */
    @ApiModelProperty(value="职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师")
    @Schema(description="职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师")
    private Byte job;

    /**
    * 入职时间
    */
    @ApiModelProperty(value="入职时间")
    @Schema(description="入职时间")
    private Date entrydate;

    /**
    * 部门ID
    */
    @ApiModelProperty(value="部门ID")
    @Schema(description="部门ID")
    private Integer deptId;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    private Date createTime;

    /**
    * 修改时间
    */
    @ApiModelProperty(value="修改时间")
    @Schema(description="修改时间")
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Byte getJob() {
        return job;
    }

    public void setJob(Byte job) {
        this.job = job;
    }

    public Date getEntrydate() {
        return entrydate;
    }

    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append(", gender=").append(gender);
        sb.append(", image=").append(image);
        sb.append(", job=").append(job);
        sb.append(", entrydate=").append(entrydate);
        sb.append(", deptId=").append(deptId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}