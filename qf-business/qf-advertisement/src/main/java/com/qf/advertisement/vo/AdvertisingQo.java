package com.qf.advertisement.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@Data
@ApiModel("前端请求类")
@Getter
@TableName("advertising")
public class AdvertisingQo {

    /**
     * 广告标题
     */
    @ApiModelProperty(value="广告标题")
    @Schema(description="广告标题")
    @TableField("advertising_title")
    private String advertisingTitle;


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
    @Schema(description="推送时间")
    @TableField("push_time")
    private Date pushTime;

    /**
     * 失效时间
     */
    @ApiModelProperty(value="失效时间")
    @Schema(description="失效时间")
    @TableField("expiry_time")
    private Date expiryTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    @TableField("create_time")
    private Date createTime;

    /**
     * 广告状态，0:下架，1:上架 2: 删除
     */
    @ApiModelProperty(value="广告状态，0:下架，1:上架 2: 删除")
    @Schema(description="广告状态，0:下架，1:上架 2: 删除")
    @TableField("status")
    private Byte status;

    @ApiModelProperty(value="上传的视频文件")
    MultipartFile  file;

}
