package com.qf.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
    * dropdown配置表
    */
@ApiModel(description="dropdown配置表")
@Data
@TableName(value = "dropdown_config")
public class DropdownConfig {
    /**
     * 主键
     */
    @TableId(value = "dropdown_id", type = IdType.AUTO)
    @ApiModelProperty(value="主键")
    private Long dropdownId;

    /**
     * 中文key
     */
    @TableField(value = "key_cn")
    @ApiModelProperty(value="中文key")
    private String keyCn;

    /**
     * 英文key
     */
    @TableField(value = "key_en")
    @ApiModelProperty(value="英文key")
    private String keyEn;

    /**
     * 1启用 2禁用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="1启用 2禁用")
    private Integer status;

    /**
     * 备注
     */
    @TableField(value = "notes")
    @ApiModelProperty(value="备注")
    private String notes;

    public static final String COL_DROPDOWN_ID = "dropdown_id";

    public static final String COL_KEY_CN = "key_cn";

    public static final String COL_KEY_EN = "key_en";

    public static final String COL_STATUS = "status";

    public static final String COL_NOTES = "notes";
}