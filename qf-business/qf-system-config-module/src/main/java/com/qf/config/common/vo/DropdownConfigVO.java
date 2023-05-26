package com.qf.config.common.vo;

import com.qf.config.entity.DropdownValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(description = "dropdown配置响应表")
@Data
public class DropdownConfigVO {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long dropdownId;

    /**
     * 中文key
     */
    @ApiModelProperty(value = "中文key")
    private String keyCn;

    @ApiModelProperty(value = "DropdownValue的中文values")
    private String  valueCn;

    /**
     * 1启用 2禁用
     */
    @ApiModelProperty(value = "1启用 2禁用")
    private Integer status;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String notes;

}
