package com.qf.order.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


@Data
public class Payment {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long paymentid;

    /**
     * 派件费
     */
    @ApiModelProperty(value = "派件费")
    private Double deliveryFee;

    /**
     * 优惠
     */
    @ApiModelProperty(value = "优惠")
    private Double preferential;

    /**
     * 实付
     */
    @ApiModelProperty(value = "实付")
    private Double disbursements;

    /**
     * 费用类型
     */
    @ApiModelProperty(value = "费用类型")
    private String expenseType;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private String paymentMethod;

    /**
     * 支付时间
     */
    @ApiModelProperty(value = "支付时间")
    private Date paymentTime;

    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号")
    private Long transactionNumber;


}

