package com.qf.order.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


@Data
public class Order {
    /**
     * 订单id
     */
    @ApiModelProperty(value = "订单id")
    private Integer purchaseid;

    /**
     * 订单号
     */
    @ApiModelProperty(value = "订单号")
    private Long orderid;

    /**
     * 包裹号
     */
    @ApiModelProperty(value = "包裹号")
    private Long packageid;

    /**
     * 派送时间
     */
    @ApiModelProperty(value = "派送时间")
    private Date deliverytime;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private Integer ordertype;

    /**
     * 订单创建时间
     */
    @ApiModelProperty(value = "订单创建时间")
    private Date creationTime;

    /**
     * 派件时间
     */
    @ApiModelProperty(value = "派件时间")
    private Date deliverytimes;

    /**
     * 派件结束
     */
    @ApiModelProperty(value = "派件结束")
    private Date deliveryEndTime;
}

