package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    @TableField(value = "member_type")
    private Integer memberType;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @TableField(value = "phone")
    private String phone;

    /**
     * 账户余额
     */
    @ApiModelProperty(value = "账户余额")
    @TableField(value = "balance")
    private BigDecimal balance;

    /**
     * 可用余额
     */
    @ApiModelProperty(value = "可用余额")
    @TableField(value = "available_balance")
    private BigDecimal availableBalance;

    /**
     * 待收
     */
    @ApiModelProperty(value = "待收")
    @TableField(value = "pending_balance")
    private BigDecimal pendingBalance;

    /**
     * 冻结
     */
    @ApiModelProperty(value = "冻结")
    @TableField(value = "frozen_balance")
    private BigDecimal frozenBalance;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 最近登录时间
     */
    @ApiModelProperty(value = "最近登录时间")
    @TableField(value = "last_login_time")
    private Date lastLoginTime;

    /**
     * 状态 1表示正常  0表示锁定
     */
    @ApiModelProperty(value = "状态 1表示正常  0表示锁定")
    @TableField(value = "status")
    private Integer status;


    @ApiModelProperty(value = "完成时间")
    @TableField(value = "completion_time")
    private Date completionTime;



    private List<PaymentRecord> paymentRecordList;



}