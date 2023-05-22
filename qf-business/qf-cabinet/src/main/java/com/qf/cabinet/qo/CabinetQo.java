package com.qf.cabinet.qo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel("柜机简单查询请求参数表")
@Data
public class CabinetQo {
    /**
     * 主键
     */
    @TableId(value = "cabinet_id", type = IdType.INPUT)
    @ApiModelProperty(value = "主键")
    private Long cabinetId;

    /**
     * 柜机编码
     */
    @TableField(value = "cabinet_code")
    @ApiModelProperty(value = "柜机编码")
    private String cabinetCode;

    /**
     * 所在地区
     */
    @TableField(value = "region")
    @ApiModelProperty(value = "所在地区")
    private String region;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 设备型号
     */
    @TableField(value = "device_model")
    @ApiModelProperty(value = "设备型号")
    private String deviceModel;

    /**
     * 存储类型（1.常温 2.冷藏）
     */
    @TableField(value = "storage_type")
    @ApiModelProperty(value = "存储类型（1.常温 2.冷藏）")
    private Integer storageType;

    /**
     * 箱格
     */
    @TableField(value = "box")
    @ApiModelProperty(value = "箱格")
    private String box;

    /**
     * 系统版本
     */
    @TableField(value = "sys_version")
    @ApiModelProperty(value = "系统版本")
    private String sysVersion;

    /**
     * 安装日期
     */
    @TableField(value = "create_data")
    @ApiModelProperty(value = "安装日期")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createData;

    /**
     * 开通时间
     */
    @TableField(value = "activation_data")
    @ApiModelProperty(value = "开通时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activationData;

    /**
     * 结束时间
     */
    @TableField(value = "end_data")
    @ApiModelProperty(value = "结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endData;

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

    /**
     * MAC地址
     */
    @ApiModelProperty(value = "MAC地址")
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

    /**
     * 假删除（0.删除 1.正常）
     */
    @ApiModelProperty(value = "假删除（0.删除 1.正常）")
    private Integer starter;

}
