package com.qf.advertisement.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
    * 广告表
    */
@Data
@ApiModel(description="广告表")
@Schema(description="广告表")
public class Advertising {
    /**
    * 广告ID
    */
    @ApiModelProperty(value="广告ID")
    @Schema(description="广告ID")
    @TableId(type = IdType.ASSIGN_ID)
    private Long advertisingId;

    /**
    * 广告标题
    */
    @ApiModelProperty(value="广告标题")
    @Schema(description="广告标题")
    private String advertisingTitle;

    /**
    * 关联的视频ID
    */
    @ApiModelProperty(value="关联的视频ID")
    @Schema(description="关联的视频ID")
    private Long videoId;

    /**
    * 推送方式，1:全屏弹窗，2:插屏广告，3:原生广告
    */
    @ApiModelProperty(value="推送方式，1:全屏弹窗，2:插屏广告，3:原生广告")
    @Schema(description="推送方式，1:全屏弹窗，2:插屏广告，3:原生广告")
    private Byte pushType;

    /**
    * 推送时间
    */
    @ApiModelProperty(value="推送时间")
    @Schema(description="推送时间")
    private Date pushTime;

    /**
    * 失效时间
    */
    @ApiModelProperty(value="失效时间")
    @Schema(description="失效时间")
    private Date expiryTime;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    private Date createTime;

    /**
    * 广告状态，0:下架，1:上架 2: 删除
    */
    @ApiModelProperty(value="广告状态，0:下架，1:上架 2: 删除")
    @Schema(description="广告状态，0:下架，1:上架 2: 删除")
    private Byte status;

}