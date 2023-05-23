package com.qf.account.common.qo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("充值记录请求参数")
public class RechargeRecordQO {

    /**
     * 交易号
     */
    @ApiModelProperty(value = "交易号")
    private Long tradeNo;


    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String mobile;


    /**
     * 会员类型：1-快递员，2-普通会员
     */
    @ApiModelProperty(value = "会员类型：1-快递员，2-普通会员")
    private Integer memberType;


    /**
     * 状态：1-充值中，2-充值成功，3-充值失败，4-待支付，5-交易关闭
     */
    @ApiModelProperty(value = "状态：1-充值中，2-充值成功，3-充值失败，4-待支付，5-交易关闭")
    private Integer status;

    /**
     * 充值渠道：1-微信，2-支付宝，3-贝宝，4-PayMaya，5-余额
     */
    @ApiModelProperty(value = "充值渠道：1-微信，2-支付宝，3-贝宝，4-PayMaya，5-余额")
    private Integer channel;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeFinish;

    /**
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间")
    private Date completeTime;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间")
    private Date completeTimeFinish;
}
