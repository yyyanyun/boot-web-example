package com.qf.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * value表
    */
@ApiModel(description="value表")
@Data
@TableName(value = "dropdown_value")
public class DropdownValue {
    /**
     * 排序id
     */
    @TableId(value = "sort_id", type = IdType.AUTO)
    @ApiModelProperty(value="排序id")
    private Long sortId;

    /**
     * 中文value
     */
    @TableField(value = "value_cn")
    @ApiModelProperty(value="中文value")
    private String valueCn;

    /**
     * 英文value
     */
    @TableField(value = "value_en")
    @ApiModelProperty(value="英文value")
    private String valueEn;

    /**
     * 1启用 2禁用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="1启用 2禁用")
    private Integer status;

    /**
     * 外键
     */
    @TableField(value = "dropdown_id")
    @ApiModelProperty(value="外键")
    private Long dropdownId;

    public static final String COL_SORT_ID = "sort_id";

    public static final String COL_VALUE_CN = "value_cn";

    public static final String COL_VALUE_EN = "value_en";

    public static final String COL_STATUS = "status";

    public static final String COL_DROPDOWN_ID = "dropdown_id";
}