package com.qf.advertisement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;


/**
    * 广告表
    */
@Data
@ApiModel(description="广告表")
@Schema(description="广告表")
@TableName("advertising")
public class Advertising {
    /**
    * 广告ID
    */
    @ApiModelProperty(value="广告ID")
    @Schema(description="广告ID")
    @TableId(value = "advertising_id",type = IdType.ASSIGN_ID)
    private Long advertisingId;

    /**
    * 广告标题
    */
    @ApiModelProperty(value="广告标题")
    @Schema(description="广告标题")
    @TableField("advertising_title")
    private String advertisingTitle;

    /**
    * 关联的视频ID
    */
    @ApiModelProperty(value="关联的视频ID")
    @Schema(description="关联的视频ID")
    @TableField("video_id")
    private Long videoId;

    /**
    * 推送方式，1:全屏弹窗，2:插屏广告，3:原生广告
    */
    @ApiModelProperty(value="推送方式，1:全屏弹窗，2:插屏广告，3:原生广告")
    @Schema(description="推送方式，1:全屏弹窗，2:插屏广告，3:原生广告")
    @TableField("push_type")
    private Byte pushType;

    /**
    * 推送时间
    */
    @ApiModelProperty(value="推送时间")
    @TableField("push_time")
    @Schema(description="推送时间")
    private  LocalDateTime pushTime;

    /**
    * 失效时间
    */
    @ApiModelProperty(value="失效时间")
    @TableField("expiry_time")
    @Schema(description="失效时间")
    private LocalDateTime expiryTime;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    @TableField("create_time")
    @Schema(description="创建时间")
    private LocalDateTime createTime;

    /**
    * 广告状态，0:下架，1:上架 2: 删除
    */
    @ApiModelProperty(value="广告状态，0:下架，1:上架 2: 删除")
    @TableField("status")
    @Schema(description="广告状态，0:下架，1:上架 2: 删除")
    private Byte status;

}