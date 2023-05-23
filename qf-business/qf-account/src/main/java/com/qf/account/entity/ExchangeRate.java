package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
    * 汇率管理表
    */
@Data
@ApiModel(description="汇率管理表")
@TableName(value = "exchange_rate")
public class ExchangeRate {
    /**
     * 汇率ID（使用雪花算法生成）
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="汇率ID（使用雪花算法生成）")
    private Long id;

    /**
     * 系统计算汇率，保留4位小数
     */
    @TableField(value = "system_exchange_rate")
    @ApiModelProperty(value="系统计算汇率，保留4位小数")
    private BigDecimal systemExchangeRate;

    /**
     * 当日基准汇率，保留4位小数
     */
    @TableField(value = "base_exchange_rate")
    @ApiModelProperty(value="当日基准汇率，保留4位小数")
    private BigDecimal baseExchangeRate;

    /**
     * 有效时间起始时间，格式为YYYY-MM-DD HH:mm:ss，设置默认值为当前时间
     */
    @TableField(value = "start_time")
    @ApiModelProperty(value="有效时间起始时间，格式为YYYY-MM-DD HH:mm:ss，设置默认值为当前时间")
    private Date startTime;

    /**
     * 有效时间结束时间，格式为YYYY-MM-DD HH:mm:ss
     */
    @TableField(value = "end_time")
    @ApiModelProperty(value="有效时间结束时间，格式为YYYY-MM-DD HH:mm:ss")
    private Date endTime;

    /**
     * 状态值：1表示生效中，2表示已过期
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态值：1表示生效中，2表示已过期")
    private Integer status;


    private ExchangeRateDetail exchangeRateDetailList;

    /**
     * 备注信息
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注信息")
    private String remark;



    public static final String COL_ID = "id";

    public static final String COL_SYSTEM_EXCHANGE_RATE = "system_exchange_rate";

    public static final String COL_BASE_EXCHANGE_RATE = "base_exchange_rate";

    public static final String COL_START_TIME = "start_time";

    public static final String COL_END_TIME = "end_time";

    public static final String COL_STATUS = "status";

    public static final String COL_REMARK = "remark";


}