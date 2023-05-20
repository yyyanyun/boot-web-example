package com.qf.account.common.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("请求参数分页查询")
public class PaymentRecordQO {

    @ApiModelProperty(value = "交易号")
    private Long tradeNo;

    @ApiModelProperty(value = "手机号")
    private String phoneNumber;

    @ApiModelProperty(value = "订单号")
    private Integer orderNo;
}
