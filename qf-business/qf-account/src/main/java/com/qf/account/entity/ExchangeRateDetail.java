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

/**
 * 汇率详情表
 */
@Data
@ApiModel(description = "汇率详情表")
@TableName(value = "exchange_rate_detail")
public class ExchangeRateDetail {
    /**
     * 汇率详情ID（使用雪花算法生成）
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "汇率详情ID（使用雪花算法生成）")
    private Long id;

    /**
     * 所属汇率ID
     */
    @TableField(value = "exchange_rate_id")
    @ApiModelProperty(value = "所属汇率ID")
    private Long exchangeRateId;

    /**
     * 交易币：1表示菲律宾比索，2表示美元
     */
    @TableField(value = "quote_currency")
    @ApiModelProperty(value = "交易币：1表示菲律宾比索，2表示美元")
    private Integer quoteCurrency;

    /**
     * 交易币单位
     */
    @TableField(value = "quote_currency_unit")
    @ApiModelProperty(value = "交易币单位")
    private String quoteCurrencyUnit;

    /**
     * 基本币
     */
    @TableField(value = "base_currency")
    @ApiModelProperty(value = "基本币")
    private String baseCurrency;

    /**
     * 现汇买入价，保留4位小数
     */
    @TableField(value = "spot_buying_rate")
    @ApiModelProperty(value = "现汇买入价，保留4位小数")
    private BigDecimal spotBuyingRate;

    /**
     * 发布时间，格式为YYYY-MM-DD HH:mm:ss，设置默认值为当前时间
     */
    @TableField(value = "publish_time")
    @ApiModelProperty(value = "发布时间，格式为YYYY-MM-DD HH:mm:ss，设置默认值为当前时间")
    private Date publishTime;

    public static final String COL_ID = "id";

    public static final String COL_EXCHANGE_RATE_ID = "exchange_rate_id";

    public static final String COL_QUOTE_CURRENCY = "quote_currency";

    public static final String COL_QUOTE_CURRENCY_UNIT = "quote_currency_unit";

    public static final String COL_BASE_CURRENCY = "base_currency";

    public static final String COL_SPOT_BUYING_RATE = "spot_buying_rate";

    public static final String COL_PUBLISH_TIME = "publish_time";


}