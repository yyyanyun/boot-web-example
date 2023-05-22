package com.qf.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 取件设置表
    */
@Data
@TableName(value = "pickup_setting")
public class PickupSetting {
    /**
     * 主键
     */
    @TableId(value = "pickup_id", type = IdType.AUTO)
    private Integer pickupId;

    /**
     * 取件码有效期（小时）
     */
    @TableField(value = "pickup_code_expire")
    private Integer pickupCodeExpire;

    /**
     * 取件码输入倒计时（分钟）
     */
    @TableField(value = "pickup_code_input_countdown")
    private Integer pickupCodeInputCountdown;

    /**
     * 提取人手机输入倒计时（秒）
     */
    @TableField(value = "pickup_phone_input_countdown")
    private Integer pickupPhoneInputCountdown;

    /**
     * 验证码输入倒计时（分钟）
     */
    @TableField(value = "verify_code_countdown")
    private Integer verifyCodeCountdown;

    /**
     * 扫码倒计时（分钟）
     */
    @TableField(value = "scan_code_countdown")
    private Integer scanCodeCountdown;

    /**
     * 开门倒计时（分钟）
     */
    @TableField(value = "pickup_door_open_countdown")
    private Integer pickupDoorOpenCountdown;

    /**
     * 自动返回主界面倒计时（分钟）
     */
    @TableField(value = "auto_back_home_countdown")
    private Integer autoBackHomeCountdown;

    public static final String COL_PICKUP_ID = "pickup_id";

    public static final String COL_PICKUP_CODE_EXPIRE = "pickup_code_expire";

    public static final String COL_PICKUP_CODE_INPUT_COUNTDOWN = "pickup_code_input_countdown";

    public static final String COL_PICKUP_PHONE_INPUT_COUNTDOWN = "pickup_phone_input_countdown";

    public static final String COL_VERIFY_CODE_COUNTDOWN = "verify_code_countdown";

    public static final String COL_SCAN_CODE_COUNTDOWN = "scan_code_countdown";

    public static final String COL_PICKUP_DOOR_OPEN_COUNTDOWN = "pickup_door_open_countdown";

    public static final String COL_AUTO_BACK_HOME_COUNTDOWN = "auto_back_home_countdown";
}