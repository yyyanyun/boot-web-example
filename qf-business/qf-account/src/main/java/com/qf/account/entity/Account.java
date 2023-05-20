package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户表
 */
@Data
@ApiModel(description = "账户表")
@TableName("t_account")
public class Account {
    /**
     * ID
     */
    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 1表示快递员  2 表示普通会员
     */
    @ApiModelProperty(value = "1表示快递员  2 表示普通会员 ")
    private Integer memberType;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 账户余额
     */
    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;

    /**
     * 可用余额
     */
    @ApiModelProperty(value = "可用余额")
    private BigDecimal availableBalance;

    /**
     * 待收
     */
    @ApiModelProperty(value = "待收")
    private BigDecimal pendingBalance;

    /**
     * 冻结
     */
    @ApiModelProperty(value = "冻结")
    private BigDecimal frozenBalance;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 最近登录时间
     */
    @ApiModelProperty(value = "最近登录时间")
    private Date lastLoginTime;

    /**
     * 状态 1表示正常  0表示锁定
     */
    @ApiModelProperty(value = "状态 1表示正常  0表示锁定")
    private Integer status;



}