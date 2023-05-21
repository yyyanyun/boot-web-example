package com.qf.advertisement.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
    * 视频表
    */
@Data
@ApiModel(description="视频表")
@Schema(description="视频表")
@TableName("video")
public class Video {
    /**
    * 视频ID
    */
    @ApiModelProperty(value="视频ID")
    @Schema(description="视频ID")
    @TableId("video_id")
    private Long videoId;

    /**
    * 视频URL
    */
    @ApiModelProperty(value="视频URL")
    @Schema(description="视频URL")
    @TableField("url")
    private String url;

    /**
    * 视频文件大小，单位为字节
    */
    @ApiModelProperty(value="视频文件大小，单位为字节")
    @Schema(description="视频文件大小，单位为字节")
    @TableField("size")
    private Long size;

    /**
    * 视频时长，单位为秒
    */
    @ApiModelProperty(value="视频时长，单位为秒")
    @Schema(description="视频时长，单位为秒")
    @TableField("duration")
    private Short duration;

}