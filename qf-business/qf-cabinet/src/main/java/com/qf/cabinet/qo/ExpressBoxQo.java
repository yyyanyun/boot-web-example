package com.qf.cabinet.qo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel("箱格请求参数表")
@Validated
public class ExpressBoxQo {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long expressBoxId;
    /**
     * 序号
     */
    @ApiModelProperty(value="序号(主键)")
    private Byte boxId;

    /**
     * 柜机主键
     */
    @ApiModelProperty(value="柜机主键")
    @NotNull(message = "柜机ID不能为空")
    private Long cabinetId;

    /**
     * 位置
     */
    @ApiModelProperty(value="位置")
    private String position;

    /**
     * 箱格类型（小中大）
     */
    @ApiModelProperty(value="箱格类型（小中大）")
    private Integer boxType;

    /**
     * 宽
     */
    @ApiModelProperty(value="宽")
    private String width;
    /**
     * 高
     */
    @ApiModelProperty(value="高")
    private String height;
    /**
     * 深
     */
    @ApiModelProperty(value="深")
    private String depth;

    /**
     * 存储类型（1常温2冷藏）
     */
    @ApiModelProperty(value="存储类型（1常温2冷藏）")
    private Integer storageType;

    /**
     * 温度
     */
    @ApiModelProperty(value="温度")
    private String temperature;

    /**
     * 门箱状态（1正常 0异常）
     */
    @ApiModelProperty(value="门箱状态（1正常 0异常）")
    private Integer doorStatus;

    /**
     * 开箱次数
     */
    @ApiModelProperty(value="开箱次数")
    private Byte openCount;

    /**
     * 最近开箱时间
     */
    @ApiModelProperty(value="最近开箱时间")
    private Date lastOpenTime;

    /**
     * 使用状态1空闲 0使用中
     */
    @ApiModelProperty(value="使用状态1空闲 0使用中")
    private Integer usageStatus;

    /**
     * 假删除 0删除 1正常
     */
    @ApiModelProperty(value="假删除 0删除 1正常")
    private Integer starter;

    /**
     * 乐观锁
     */
    @ApiModelProperty(value="乐观锁")
    private Integer version;
}
