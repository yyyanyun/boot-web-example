package com.qf.account.common.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("请求参数分页查询")
public class PaymentRecordQO {

    @ApiModelProperty(value = "交易号")
    private Long tradeNo;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "订单号")
    private Integer orderNo;

    @ApiModelProperty(value = "订单类型 1 表示派件  2 表示寄件")
    private Integer orderType;

    @ApiModelProperty(value = "支付状态 1表示支付成功 2表示尚未付款 3表示交易关闭")
    private Integer status;

    @ApiModelProperty(value = "会员类型 1表示快递员  2 表示普通会员")
    private Integer memberType;

    @ApiModelProperty(value = "支付渠道 1 表示微信 2 表示支付表 3表示贝宝支付 4 表示PayMaya 5表示余额")
    private Integer paymentChannel;

    @ApiModelProperty(value = "创建时间")
    private Date createdTime;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "完成时间")
    private Date completedTime;

    @ApiModelProperty(value = "完成时间")
    private Date finishTime;

    @ApiModelProperty(value = "所属账户id")
    private Long accountId;

}
