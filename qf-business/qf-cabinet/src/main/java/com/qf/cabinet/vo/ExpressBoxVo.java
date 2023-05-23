package com.qf.cabinet.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.qf.cabinet.entity.LogBox;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("箱格响应数据表")
public class ExpressBoxVo {
    /**
     * 主键
     */
    @TableId(value = "express_box_id")
    @ApiModelProperty(value = "主键")
    private Long expressBoxId;
    /**
     * 序号
     */
    @ApiModelProperty(value = "序号(主键)")
    private Byte boxId;

    /**
     * 柜机主键
     */
    @TableField(value = "cabinet_id")
    @ApiModelProperty(value = "柜机主键")
    private Long cabinetId;

    /**
     * 位置 行
     */
    @TableField(value = "`positionLine`")
    @ApiModelProperty(value="行")
    private String positionLine;
    /**
     * 位置 列
     */
    @TableField(value = "`positionColumn`")
    @ApiModelProperty(value="列")
    private String positionColumn;

    /**
     * 箱格类型（小中大）
     */
    @TableField(value = "box_type")
    @ApiModelProperty(value = "箱格类型（小中大）")
    private Integer boxType;

    /**
     * 宽
     */
    @TableField(value = "`width`")
    @ApiModelProperty(value = "宽")
    private String width;
    /**
     * 高
     */
    @TableField(value = "`height`")
    @ApiModelProperty(value = "高")
    private String height;
    /**
     * 深
     */
    @TableField(value = "`depth`")
    @ApiModelProperty(value = "深")
    private String depth;

    /**
     * 存储类型（1常温2冷藏）
     */
    @TableField(value = "storage_type")
    @ApiModelProperty(value = "存储类型（1常温2冷藏）")
    private Integer storageType;

    /**
     * 温度
     */
    @TableField(value = "temperature")
    @ApiModelProperty(value = "温度")
    private String temperature;

    /**
     * 门箱状态（1正常 0异常）
     */
    @TableField(value = "door_status")
    @ApiModelProperty(value = "门箱状态（1正常 0异常）")
    private Integer doorStatus;

    /**
     * 开箱次数
     */
    @TableField(value = "open_count")
    @ApiModelProperty(value = "开箱次数")
    private Byte openCount;

    /**
     * 最近开箱时间
     */
    @TableField(value = "last_open_time")
    @ApiModelProperty(value = "最近开箱时间")
    private Date lastOpenTime;

    /**
     * 使用状态1空闲 0使用中
     */
    @TableField(value = "usage_status")
    @ApiModelProperty(value = "使用状态1空闲 0使用中")
    private Integer usageStatus;

    /**
     * 假删除 0删除 1正常
     */
    @TableField(value = "starter")
    @ApiModelProperty(value = "假删除 0删除 1正常")
    private Integer starter;

    /**
     * 乐观锁
     */
    @TableField(value = "version")
    @ApiModelProperty(value = "乐观锁")
    private Integer version;

    /**
     * 映射箱格记录
     */
    @TableField(value = "logBoxList")
    private List<LogBox> logBoxList;

}
