package com.qf.account.common.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(description = "汇率管理表响应数据")
public class ExchangeRateVO {


    /**
     * 汇率ID（使用雪花算法生成）
     */
    @ApiModelProperty(value = "汇率ID（使用雪花算法生成）")
    private Long id;

    /**
     * 系统计算汇率，保留4位小数
     */
    @ApiModelProperty(value = "系统计算汇率，保留4位小数")
    private BigDecimal systemExchangeRate;

    /**
     * 当日基准汇率，保留4位小数
     */
    @ApiModelProperty(value = "当日基准汇率，保留4位小数")
    private BigDecimal baseExchangeRate;

    /**
     * 有效时间起始时间，格式为YYYY-MM-DD HH:mm:ss，设置默认值为当前时间
     */
    @ApiModelProperty(value = "有效时间起始时间，格式为YYYY-MM-DD HH:mm:ss，设置默认值为当前时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 有效时间结束时间，格式为YYYY-MM-DD HH:mm:ss
     */
    @ApiModelProperty(value = "有效时间结束时间，格式为YYYY-MM-DD HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 状态值：1表示生效中，2表示已过期
     */
    @ApiModelProperty(value = "状态值：1表示生效中，2表示已过期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Integer status;

    /**
     * 备注信息
     */
    @ApiModelProperty(value = "备注信息")
    private String remark;

}
