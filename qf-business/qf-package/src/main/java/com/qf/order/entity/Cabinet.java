package com.qf.order.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


@Data
public class Cabinet {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private long cabinetId;

    /**
     * 柜机编码
     */
    @ApiModelProperty(value = "柜机编码")
    private String cabinetCode;

    /**
     * 所在地区
     */
    @ApiModelProperty(value = "所在地区")
    private String region;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 设备型号
     */
    @ApiModelProperty(value = "设备型号")
    private String deviceModel;

    /**
     * 存储类型（1.常温 2.冷藏）
     */
    @ApiModelProperty(value = "存储类型（1.常温 2.冷藏）")
    private Integer storageType;

    /**
     * 箱格
     */
    @ApiModelProperty(value = "箱格")
    private String box;

    /**
     * 系统版本
     */
    @ApiModelProperty(value = "系统版本")
    private String sysVersion;

    /**
     * 开通时间
     */
    @ApiModelProperty(value = "开通时间")
    private Date activationData;

    /**
     * 箱门状态(1.正常 0.异常)
     */
    @ApiModelProperty(value = "箱门状态(1.正常 0.异常)")
    private Integer boxBoorStatus;

    /**
     * 柜机状态(0.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)
     */
    @ApiModelProperty(value = "柜机状态(0.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)")
    private Integer cabinetStatus;

    /**
     * 主柜宽度（cm）
     */
    @ApiModelProperty(value = "主柜宽度（cm）")
    private Double hostWidth;

    /**
     * 主柜深度（cm）
     */
    @ApiModelProperty(value = "主柜深度（cm）")
    private Double hostDepth;

    /**
     * 主柜高度（cm）
     */
    @ApiModelProperty(value = "主柜高度（cm）")
    private Double hostHeight;

    /**
     * 副柜宽度（cm）
     */
    @ApiModelProperty(value = "副柜宽度（cm）")
    private Double viceWidth;

    /**
     * 副柜深度（cm）
     */
    @ApiModelProperty(value = "副柜深度（cm）")
    private Double viceDepth;

    /**
     * 副柜高度（cm）
     */
    @ApiModelProperty(value = "副柜高度（cm）")
    private Double viceHeight;

    /**
     * 假删除（0.删除 1.正常）
     */
    @ApiModelProperty(value = "假删除（0.删除 1.正常）")
    private Integer starter;

    /**
     * 乐观锁
     */
    @ApiModelProperty(value = "乐观锁")
    private Byte version;
}

