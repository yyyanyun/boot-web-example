package com.qf.config.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
    * 智能柜收费设置表
    */
@ApiModel(description="智能柜收费设置表")
@Data
@TableName(value = "cabinet_charge_setting")
public class CabinetChargeSetting {
    /**
     * 收费项 ID
     */
    @TableId(value = "cabinet_id", type = IdType.INPUT)
    @ApiModelProperty(value="收费项 ID")
    private Integer cabinetId;

    /**
     * 寄件收费金额，单位：元
     */
    @TableField(value = "send_fee")
    @ApiModelProperty(value="寄件收费金额，单位：元")
    private BigDecimal sendFee;

    /**
     * 派件收费金额，单位：元
     */
    @TableField(value = "express_fee")
    @ApiModelProperty(value="派件收费金额，单位：元")
    private BigDecimal expressFee;

    public static final String COL_ID = "cabinet_id";

    public static final String COL_SEND_FEE = "send_fee";

    public static final String COL_EXPRESS_FEE = "express_fee";
}