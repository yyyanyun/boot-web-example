package com.qf.cabinet.qo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 箱格记录表
 */
@ApiModel(description = "箱格记录请求参数表")
@Data
public class LogBoxQo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long logId;

    /**
     * 箱格ID
     */
    @ApiModelProperty(value = "箱格ID")
    private Long expressBoxId;

    /**
     * 开箱时间
     */
    @ApiModelProperty(value = "开箱时间")
    private Date openData;

    /**
     * 关箱时间
     */
    @ApiModelProperty(value = "关箱时间")
    private Date endData;

    /**
     * 类型（1取 2派 3寄）
     */
    @ApiModelProperty(value = "类型（1取 2派 3寄）")
    private Integer type;

    /**
     * 操作人(1用户 2快递员)
     */
    @ApiModelProperty(value = "操作人(1用户 2快递员)")
    private Integer opUser;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 时长
     */
    @ApiModelProperty(value = "时长")
    private String opData;

    /**
     * 假删除（1正常 0删除）
     */
    @ApiModelProperty(value = "假删除（1正常 0删除）")
    @TableLogic(value = "1", delval = "0")
    private Integer starter;

    /**
     * 乐观锁
     */
    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

}