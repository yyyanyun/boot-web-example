package com.qf.login.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(description = "tb_user")
@TableName(value = "tb_user")
public class User {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "管理员id")
    private Long id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 性别（0：女，1：男）
     */
    @TableField(value = "gender")
    @ApiModelProperty(value = "性别（0：女，1：男）")
    private Integer gender;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 联系电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    /**
     * 真实姓名
     */
    @TableField(value = "really_name")
    @ApiModelProperty(value = "真实姓名")
    private String reallyName;

    /**
     * 角色
     */
    @TableField(value = "`role`")
    @ApiModelProperty(value = "角色")
    private String role;


    @ApiModelProperty(value = "新密码")
    private String newPassword;


    @ApiModelProperty(value = "确认新密码")
    private String confirmPassword;

}