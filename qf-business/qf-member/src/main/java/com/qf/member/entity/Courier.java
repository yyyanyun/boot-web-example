package com.qf.member.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@Validated
@Data
public class Courier {
    /**
     * ID(主键)
     */
    @ApiModelProperty(value = "ID(主键)")
    private Integer memberId;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    @Pattern(regexp = "^(?:[\u4e00-\u9fa5·]{2,16})$",message = "姓名不符合规范")
    private String memberName;

    /**
     * 手机号码
     */
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号输入不正确")
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 会员状态 0 正常 1 禁用
     */
    @ApiModelProperty(value = "会员状态 0 正常 1 禁用")
    private Integer memberStatus;

    /**
     * 注册类型 0 自主注册 1 手工注册
     */
    @ApiModelProperty(value = "注册类型 0 自主注册 1 手工注册")
    private Integer registrationType;

    /**
     * 创造时间
     */
    @ApiModelProperty(value = "创造时间")
    private Date createTime;

    /**
     * 登录密码 0未设置 1已设置
     */
    @ApiModelProperty(value = "登录密码 0未设置 1已设置")
    private Integer loginPassword;

    /**
     * 最近登录时间
     */
    @ApiModelProperty(value = "最近登录时间")
    private Date loginTime;
}

