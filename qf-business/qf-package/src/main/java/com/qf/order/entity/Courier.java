package com.qf.order.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class Courier {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Integer cid;

    /**
     * 快递员名字
     */
    @ApiModelProperty(value = "快递员名字")
    private String cname;

    /**
     * 快递员电话
     */
    @ApiModelProperty(value = "快递员电话")
    private String phone;
}

