package com.qf.cabinet.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel("柜机高级查询请求参数表")
public class CabinetHighQo {
    /**
     * 主键
     */
    @ApiModelProperty(value = "主键")
    private Long cabinetId;

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
     * 系统版本
     */
    @ApiModelProperty(value = "系统版本")
    private String sysVersion;

    /**
     * 安装日期
     */
    @ApiModelProperty(value = "安装日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createData;

    /**
     * 开通时间
     */
    @ApiModelProperty(value = "开通时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activationData;


    /**
     * 箱门状态(1.正常 2.异常)
     */
    @ApiModelProperty(value = "箱门状态(1.正常 2.异常)")
    private Integer boxBoorStatus;

    /**
     * 箱格状况（4未录入 1.小满 2.半满 3.全满）
     */
    @ApiModelProperty(value = "箱格状况（4未录入 1.小满 2.半满 3.全满）")
    private Integer boxStarter;

    /**
     * 柜机状态(5.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)
     */
    @ApiModelProperty(value = "柜机状态(5.禁用 1.正常、启用 2.未开通 3.已关机 4.重启中)")
    private Integer cabinetStatus;

}
