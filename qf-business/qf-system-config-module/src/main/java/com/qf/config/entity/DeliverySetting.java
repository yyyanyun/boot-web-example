package com.qf.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * 派件设置表
    */
@Data
@ApiModel(description = "派件设置表")
@TableName(value = "delivery_setting")
public class DeliverySetting {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    @TableId(value = "delivery_id", type = IdType.INPUT)
    private Integer deliveryId;

    /**
     * 扫码登录倒计时（分钟）
     */
    @ApiModelProperty(value = "扫码登录倒计时")
    @TableField(value = "scan_login_countdown")
    private Integer scanLoginCountdown;

    /**
     * 手机登录倒计时（分钟）
     */
    @ApiModelProperty(value = "扫码登录倒计时")
    @TableField(value = "phone_countdown")
    private Integer phoneCountdown;

    /**
     * 密码输入倒计时（分钟）
     */
    @ApiModelProperty(value = "密码输入倒计时")
    @TableField(value = "pwd_countdown")
    private Integer pwdCountdown;

    /**
     * 收件人手机号输入倒计时（分钟）
     */
    @ApiModelProperty(value = "收件人手机号输入倒计时")
    @TableField(value = "recipient_phone_countdown")
    private Integer recipientPhoneCountdown;

    /**
     * 支付倒计时（分钟）
     */
    @ApiModelProperty(value = "支付倒计时")
    @TableField(value = "pay_countdown")
    private Integer payCountdown;

    /**
     * 开门倒计时（分钟）
     */
    @ApiModelProperty(value = "开门倒计时")
    @TableField(value = "delivery_door_open_countdown")
    private Integer deliveryDoorOpenCountdown;

    /**
     * 成功自动登出时间（分钟）
     */
    @ApiModelProperty(value = "成功自动登出时间")
    @TableField(value = "auto_logout_countdown")
    private Integer autoLogoutCountdown;

    public static final String COL_DELIVERY_ID = "delivery_id";

    public static final String COL_SCAN_LOGIN_COUNTDOWN = "scan_login_countdown";

    public static final String COL_PHONE_COUNTDOWN = "phone_countdown";

    public static final String COL_PWD_COUNTDOWN = "pwd_countdown";

    public static final String COL_RECIPIENT_PHONE_COUNTDOWN = "recipient_phone_countdown";

    public static final String COL_PAY_COUNTDOWN = "pay_countdown";

    public static final String COL_DELIVERY_DOOR_OPEN_COUNTDOWN = "delivery_door_open_countdown";

    public static final String COL_AUTO_LOGOUT_COUNTDOWN = "auto_logout_countdown";
}