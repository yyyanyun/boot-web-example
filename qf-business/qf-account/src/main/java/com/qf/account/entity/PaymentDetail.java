package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;

/**
    * 支付详情表
    */
@ApiModel(description="支付详情表")
@TableName(value = "payment_detail")
public class PaymentDetail {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 交易号
     */
    @TableField(value = "trade_no")
    @ApiModelProperty(value="交易号")
    private Long tradeNo;

    /**
     * 寄件或者派件的费用
     */
    @TableField(value = "fee_type")
    @ApiModelProperty(value="寄件或者派件的费用")
    private Integer feeType;

    /**
     * 优惠金额
     */
    @TableField(value = "discount")
    @ApiModelProperty(value="优惠金额")
    private BigDecimal discount;

    /**
     * 关闭时间
     */
    @TableField(value = "closed_time")
    @ApiModelProperty(value="关闭时间")
    private Date closedTime;

    /**
     * 支付金额
     */
    @TableField(value = "payment_amount")
    @ApiModelProperty(value="支付金额")
    private Long paymentAmount;

    public static final String COL_ID = "id";

    public static final String COL_TRADE_NO = "trade_no";

    public static final String COL_FEE_TYPE = "fee_type";

    public static final String COL_DISCOUNT = "discount";

    public static final String COL_CLOSED_TIME = "closed_time";

    public static final String COL_PAYMENT_AMOUNT = "payment_amount";

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取交易号
     *
     * @return trade_no - 交易号
     */
    public Long getTradeNo() {
        return tradeNo;
    }

    /**
     * 设置交易号
     *
     * @param tradeNo 交易号
     */
    public void setTradeNo(Long tradeNo) {
        this.tradeNo = tradeNo;
    }

    /**
     * 获取寄件或者派件的费用
     *
     * @return fee_type - 寄件或者派件的费用
     */
    public Integer getFeeType() {
        return feeType;
    }

    /**
     * 设置寄件或者派件的费用
     *
     * @param feeType 寄件或者派件的费用
     */
    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    /**
     * 获取优惠金额
     *
     * @return discount - 优惠金额
     */
    public BigDecimal getDiscount() {
        return discount;
    }

    /**
     * 设置优惠金额
     *
     * @param discount 优惠金额
     */
    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    /**
     * 获取关闭时间
     *
     * @return closed_time - 关闭时间
     */
    public Date getClosedTime() {
        return closedTime;
    }

    /**
     * 设置关闭时间
     *
     * @param closedTime 关闭时间
     */
    public void setClosedTime(Date closedTime) {
        this.closedTime = closedTime;
    }

    /**
     * 获取支付金额
     *
     * @return payment_amount - 支付金额
     */
    public Long getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * 设置支付金额
     *
     * @param paymentAmount 支付金额
     */
    public void setPaymentAmount(Long paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}