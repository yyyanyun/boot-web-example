package com.qf.advertisement.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;


@Data
public class AppAdvertisingVo {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    @Schema(description="主键")
    private Integer appId;

    /**
     * 广告标题
     */
    @ApiModelProperty(value="广告标题")
    @Schema(description="广告标题")
    private String title;

    /**
     * 中文图片
     */
    @ApiModelProperty(value="中文图片")
    @Schema(description="中文图片")
    private String cnImage;

    /**
     * 英文图片
     */
    @ApiModelProperty(value="英文图片")
    @Schema(description="英文图片")
    private String enImage;

    /**
     * 推送时间
     */
    @ApiModelProperty(value="推送时间")
    @Schema(description="推送时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pushTime;

    /**
     * 失效时间
     */
    @ApiModelProperty(value="失效时间")
    @Schema(description="失效时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expireDate;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 状态 0 推送  1 上架 2 过期
     */
    @ApiModelProperty(value="状态 0 推送  1 上架 2 过期")
    @Schema(description="状态 0 推送  1 上架 2 过期")
    private Integer status;

    /**
     * 推送方式 1. 快递员  2.会员端 3. 全部
     */
    @ApiModelProperty(value="推送方式 1. 快递员  2.会员端 3. 全部 ")
    @Schema(description="推送方式 1. 快递员  2.会员端 3. 全部 ")
    private Integer pushWay;

    /**
     * 链接地址
     */
    @ApiModelProperty(value="链接地址")
    @Schema(description="链接地址")
    private String linkUrl;

    /**
     * 链接标题
     */
    @ApiModelProperty(value="链接标题")
    @Schema(description="链接标题")
    private String linkTitle;

}
