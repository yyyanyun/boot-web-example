package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付详情表
 */
@Data
@ApiModel(description = "支付详情表")
@TableName(value = "payment_detail")
public class PaymentDetail {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 交易号
     */
    @TableField(value = "trade_no")
    @ApiModelProperty(value = "交易号")
    private Long tradeNo;

    /**
     * 寄件或者派件的费用
     */
    @TableField(value = "fee_type")
    @ApiModelProperty(value = "寄件或者派件的费用")
    private Integer feeType;

    /**
     * 优惠金额
     */
    @TableField(value = "discount")
    @ApiModelProperty(value = "优惠金额")
    private BigDecimal discount;

    /**
     * 关闭时间
     */
    @TableField(value = "closed_time")
    @ApiModelProperty(value = "关闭时间")
    private Date closedTime;

    /**
     * 支付金额
     */
    @TableField(value = "payment_amount")
    @ApiModelProperty(value = "支付金额")
    private Long paymentAmount;

    public static final String COL_ID = "id";

    public static final String COL_TRADE_NO = "trade_no";

    public static final String COL_FEE_TYPE = "fee_type";

    public static final String COL_DISCOUNT = "discount";

    public static final String COL_CLOSED_TIME = "closed_time";

    public static final String COL_PAYMENT_AMOUNT = "payment_amount";


}