package com.qf.advertisement.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@ApiModel("给前端展示广告信息的类")
public class AdvertisingVo {

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
     * 推送方式，1:全屏弹窗，2:插屏广告，3:原生广告
     */
    @ApiModelProperty(value="推送方式，1:全屏弹窗，2:插屏广告，3:原生广告")
    @Schema(description="推送方式，1:全屏弹窗，2:插屏广告，3:原生广告")
    private Byte pushType;

    /**
     * 推送时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @ApiModelProperty(value="推送时间")
    @Schema(description="推送时间")
    private LocalDateTime pushTime;

    /**
     * 失效时间
     */
    @ApiModelProperty(value="失效时间")
    @Schema(description="失效时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime expiryTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;

    /**
     * 广告状态，0:下架，1:上架 2: 删除
     */
    @ApiModelProperty(value="广告状态，0:下架，1:上架 2: 删除")
    @Schema(description="广告状态，0:下架，1:上架 2: 删除")
    private Byte status;


    /**
     * 视频URL
     */
    @ApiModelProperty(value="视频URL")
    @Schema(description="视频URL")
    private String url;

    /**
     * 视频文件大小，单位为字节
     */
    @ApiModelProperty(value="视频文件大小，单位为字节")
    @Schema(description="视频文件大小，单位为字节")
    private Long size;

    /**
     * 视频时长，单位为秒
     */
    @ApiModelProperty(value="视频时长，单位为秒")
    @Schema(description="视频时长，单位为秒")
    private Short duration;


}
