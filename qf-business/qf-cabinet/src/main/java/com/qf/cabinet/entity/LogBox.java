package com.qf.cabinet.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import lombok.Data;

/**
    * 箱格记录表
    */
@ApiModel(description="箱格记录表")
@Data
@TableName(value = "log_box")
public class LogBox {
    /**
     * 主键
     */
    @TableId(value = "log_id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键")
    private Long logId;

    /**
     * 箱格ID
     */
    @TableField(value = "express_box_id")
    @ApiModelProperty(value="箱格ID")
    private Long expressBoxId;

    /**
     * 开箱时间
     */
    @TableField(value = "open_data")
    @ApiModelProperty(value="开箱时间")
    private Date openData;

    /**
     * 关箱时间
     */
    @TableField(value = "end_data")
    @ApiModelProperty(value="关箱时间")
    private Date endData;

    /**
     * 类型（1取 2派 3寄）
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value="类型（1取 2派 3寄）")
    private Integer type;

    /**
     * 操作人(1用户 2快递员)
     */
    @TableField(value = "op_user")
    @ApiModelProperty(value="操作人(1用户 2快递员)")
    private Integer opUser;

    /**
     * 手机号码
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="手机号码")
    private String phone;

    /**
     * 时长
     */
    @TableField(value = "op_data")
    @ApiModelProperty(value="时长")
    private String opData;

    /**
     * 假删除（1正常 0删除）
     */
    @TableField(value = "starter")
    @ApiModelProperty(value="假删除（1正常 0删除）")
    @TableLogic(value = "1",delval = "0")
    private Integer starter;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @ApiModelProperty(value="乐观锁")
    @Version
    private Integer version;


}