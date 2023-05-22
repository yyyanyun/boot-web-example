package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 充值记录表
 */
@Data
@ApiModel(description = "充值记录表")
@TableName(value = "recharge_record")
public class RechargeRecord {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 账户ID
     */
    @TableField(value = "account_id")
    @ApiModelProperty(value = "账户ID")
    private Long accountId;

    /**
     * 交易号
     */
    @TableField(value = "trade_no")
    @ApiModelProperty(value = "交易号")
    private Long tradeNo;

    /**
     * 会员类型：1-快递员，2-普通会员
     */
    @TableField(value = "member_type")
    @ApiModelProperty(value = "会员类型：1-快递员，2-普通会员")
    private Integer memberType;

    /**
     * 手机号
     */
    @TableField(value = "mobile")
    @ApiModelProperty(value = "手机号")
    private String mobile;

    /**
     * 充值渠道：1-微信，2-支付宝，3-贝宝，4-PayMaya，5-余额
     */
    @TableField(value = "channel")
    @ApiModelProperty(value = "充值渠道：1-微信，2-支付宝，3-贝宝，4-PayMaya，5-余额")
    private Integer channel;

    /**
     * 充值金额
     */
    @TableField(value = "amount")
    @ApiModelProperty(value = "充值金额")
    private BigDecimal amount;

    /**
     * 充值后金额
     */
    @TableField(value = "balance")
    @ApiModelProperty(value = "充值后金额")
    private BigDecimal balance;

    /**
     * 充值币种：1-CNY，2-PHP
     */
    @TableField(value = "currency_type")
    @ApiModelProperty(value = "充值币种：1-CNY，2-PHP")
    private Integer currencyType;

    /**
     * 实际支付CNY
     */
    @TableField(value = "actual_amount")
    @ApiModelProperty(value = "实际支付CNY")
    private BigDecimal actualAmount;

    /**
     * 汇率
     */
    @TableField(value = "exchange_rate")
    @ApiModelProperty(value = "汇率")
    private BigDecimal exchangeRate;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeFinish;
    /**
     * 完成时间
     */
    @TableField(value = "complete_time")
    @ApiModelProperty(value = "完成时间")
    private Date completeTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "完成时间")
    private Date completeTimeFinish;

    /**
     * 状态：1-充值中，2-充值成功，3-充值失败，4-待支付，5-交易关闭
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value = "状态：1-充值中，2-充值成功，3-充值失败，4-待支付，5-交易关闭")
    private Integer status;


    private RechargeDetails rechargeDetails;

    public static final String COL_ID = "id";

    public static final String COL_ACCOUNT_ID = "account_id";

    public static final String COL_TRADE_NO = "trade_no";

    public static final String COL_MEMBER_TYPE = "member_type";

    public static final String COL_MOBILE = "mobile";

    public static final String COL_CHANNEL = "channel";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_BALANCE = "balance";

    public static final String COL_CURRENCY_TYPE = "currency_type";

    public static final String COL_ACTUAL_AMOUNT = "actual_amount";

    public static final String COL_EXCHANGE_RATE = "exchange_rate";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_COMPLETE_TIME = "complete_time";

    public static final String COL_STATUS = "status";


}