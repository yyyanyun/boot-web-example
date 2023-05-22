package com.qf.cabinet.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("柜机简单查询请求参数表")
@Data
public class CabinetQo {

    /**
     * 箱门状态(1.正常 2.异常)
     */
    @ApiModelProperty(value = "箱门状态(1.正常 2.异常)")
    private Integer boxBoorStatus;

    /**
     * 柜机状态(5.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)
     */
    @ApiModelProperty(value = "柜机状态(5.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)")
    private Integer cabinetStatus;
}
