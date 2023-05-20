package com.qf.account.common.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("高级搜索请求参数")
public class AccountQO {

    @ApiModelProperty(value = "账户id")
    private Long id;

    @ApiModelProperty(value = "1表示快递员  2 表示普通会员 ")
    private Integer memberType;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "完成时间")
    private Date completion_time;

    @ApiModelProperty(value = "最近登录时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "状态 1表示正常  0表示锁定")
    private Integer status;


}
