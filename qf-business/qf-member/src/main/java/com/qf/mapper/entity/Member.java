package com.qf.member.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description="t_member")
@Data
public class Member {
    /**
    * ID(主键)
    */
    @ApiModelProperty(value="ID(主键)")
    @NotNull(message = "ID(主键)不能为null")
    private Integer memberId;

    /**
    * 真实姓名
    */
    @ApiModelProperty(value="真实姓名")
    @Size(max = 24,message = "真实姓名最大长度要小于 24")
    @NotBlank(message = "真实姓名不能为空")
    private String memberName;

    /**
    * 手机号码
    */
    @ApiModelProperty(value="手机号码")
    @Size(max = 64,message = "手机号码最大长度要小于 64")
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    /**
    * 会员状态 0 正常 1 禁用
    */
    @ApiModelProperty(value="会员状态 0 正常 1 禁用")
    @NotNull(message = "会员状态 0 正常 1 禁用不能为null")
    private Integer memberStatus;

    /**
    * 注册类型 0 app注册 1 小程序注册 2 公众号注册 3 系统注册
    */
    @ApiModelProperty(value="注册类型 0 app注册 1 小程序注册 2 公众号注册 3 系统注册")
    @NotNull(message = "注册类型 0 app注册 1 小程序注册 2 公众号注册 3 系统注册不能为null")
    private Integer registrationType;

    /**
    * 创造时间
    */
    @ApiModelProperty(value="创造时间")
    @NotNull(message = "创造时间不能为null")
    private Date createTime;

    /**
    * 登录密码 0未设置 1已设置
    */
    @ApiModelProperty(value="登录密码 0未设置 1已设置")
    private Integer loginPassword;

    /**
    * 最近登录时间
    */
    @ApiModelProperty(value="最近登录时间")
    private Date loginTime;
    private BankCard bankCard;
    private RealName realName;
}