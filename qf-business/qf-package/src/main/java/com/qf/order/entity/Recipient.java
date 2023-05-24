package com.qf.order.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


@Data
public class Recipient {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer uid;

    /**
     * 用户名字
     */
    @ApiModelProperty(value = "用户名字")
    private String uname;

    /**
     * 用户手机
     */
    @ApiModelProperty(value = "用户手机")
    private String phone;

    /**
     * 快递员id
     */
    @ApiModelProperty(value = "快递员id")
    private Integer cid;
    @ApiModelProperty(value = "快递柜id")
    private Integer cabinetId;
    private List<Courier>couriers;
    private List<Cabinet> cabinets;

    private List<Order> orders;
    private List<Payment>payments;
}

