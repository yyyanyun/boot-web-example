package com.qf.account.common.qo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel("汇率管理请求参数")
public class ExchangeRateQO {
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


}
