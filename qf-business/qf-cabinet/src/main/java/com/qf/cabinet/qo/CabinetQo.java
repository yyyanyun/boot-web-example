package com.qf.cabinet.qo;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@ApiModel("添加柜机请求参数表")
@Data
@Validated
public class CabinetQo {

    /**
     * 柜机编码
     */
    @ApiModelProperty(value = "柜机编码",required = true)
    @NotBlank(message = "柜机编号不能为空")
    private String cabinetCode;

    /**
     * 所在地区
     */
    @ApiModelProperty(value = "所在地区")
    @NotBlank(message = "所在地区不能为空")
    private String region;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    @NotBlank(message = "详细地址不能为空")
    private String address;

    /**
     * 设备型号
     */
    @ApiModelProperty(value = "设备型号")
    @NotBlank(message = "设备型号不能为空")
    private String deviceModel;

    /**
     * 存储类型（1.常温 2.冷藏）
     */
    @ApiModelProperty(value = "存储类型（1.常温 2.冷藏）")
    @NotNull(message = "存储类型不能为空")
    private Integer storageType;

    /**
     * 安装日期
     */
    @ApiModelProperty(value = "安装日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotBlank(message = "安装日期不能为空")
    private Date createData;

    /**
     * 开通时间
     */
    @ApiModelProperty(value = "开通时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date activationData;


    /**
     * 柜机状态(5.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)
     */
    @ApiModelProperty(value = "柜机状态(5.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)")
    private Integer cabinetStatus;

    /**
     * MAC地址
     */
    @ApiModelProperty(value = "MAC地址")
    @NotBlank(message = "MAC地址不能为空")
    private String mac;

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

}
