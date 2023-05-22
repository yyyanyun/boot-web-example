package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付记录表
 */
@Data
@ApiModel(description = "支付记录表")
public class PaymentRecord {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号")
    private Long tradeNo;

    /**
     * 会员类型
     */
    @ApiModelProperty(value = "会员类型 1表示快递员  2 表示普通会员")
    private Integer memberType;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    /**
     * 订单类型 1 表示派件  2 表示寄件
     */
    @ApiModelProperty(value = "订单类型 1 表示派件  2 表示寄件")
    private Integer orderType;

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private Integer orderNo;

    /**
     * 应付金额
     */
    @ApiModelProperty(value = "应付金额")
    private BigDecimal amount;

    /**
     * 支付渠道 1 表示微信 2 表示支付表 3表示贝宝支付 4 表示PayMaya 5表示余额
     */
    @ApiModelProperty(value = "支付渠道 1 表示微信 2 表示支付表 3表示贝宝支付 4 表示PayMaya 5表示余额")
    private Integer paymentChannel;

    /**
     * 支付币种 1表示CNY 2 表示PHP
     */
    @ApiModelProperty(value = "支付币种 1表示CNY 2 表示PHP")
    private Integer paymentCurrency;

    /**
     * 实际支付CNY
     */
    @ApiModelProperty(value = "实际支付CNY")
    private BigDecimal actualPaymentCny;

    /**
     * 汇率
     */
    @ApiModelProperty(value = "汇率")
    private BigDecimal exchangeRate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;


    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    /**
     * 完成时间
     */
    @ApiModelProperty(value = "完成时间")
    private Date completedTime;


    @ApiModelProperty(value = "完成时间")
    private Date finishTime;

    /**
     * 支付状态 1表示支付成功 2表示尚未付款 3表示交易关闭
     */
    @ApiModelProperty(value = "支付状态 1表示支付成功 2表示尚未付款 3表示交易关闭")
    private Integer status;

    @ApiModelProperty(value = "所属账户id")
    private Long accountId;

    private PaymentDetail paymentDetail;

}