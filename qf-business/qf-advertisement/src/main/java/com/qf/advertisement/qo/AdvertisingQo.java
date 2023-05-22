package com.qf.advertisement.qo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@Data
@ApiModel("前端请求类")
@Getter
public class AdvertisingQo {

    /**
     * 广告ID
     */
    @ApiModelProperty(value="广告ID")
    @Schema(description="广告ID")
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
    @ApiModelProperty(value="推送时间")
    @Schema(description="推送时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime pushTime;

    /**
     * 失效时间
     */
    @ApiModelProperty(value="失效时间")
    @Schema(description="失效时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime expiryTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 广告状态，0:下架，1:上架 2: 删除
     */
    @ApiModelProperty(value="广告状态，0:下架，1:上架 2: 删除")
    @Schema(description="广告状态，0:下架，1:上架 2: 删除")
    private Byte status;

    @ApiModelProperty(value="上传的视频文件")
    MultipartFile  file;

}
