package com.qf.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 基础设置表
    */
@Data
@TableName(value = "basic_setting")
public class BasicSetting {
    /**
     * 主键
     */
    @TableId(value = "basic_id", type = IdType.AUTO)
    private Integer basicId;

    /**
     * APP下载倒计时（分钟）
     */
    @TableField(value = "app_countdown")
    private Integer appCountdown;

    /**
     * 自动待机倒计时（分钟）
     */
    @TableField(value = "login_countdown")
    private Integer loginCountdown;

    public static final String COL_BASIC_ID = "basic_id";

    public static final String COL_APP_COUNTDOWN = "app_countdown";

    public static final String COL_LOGIN_COUNTDOWN = "login_countdown";
}