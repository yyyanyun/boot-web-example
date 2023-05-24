package com.qf.advertisement.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;

@ApiModel(description="app_advertising")
@Schema
public class AppAdvertising {
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
    private Date pushTime;

    /**
    * 失效时间
    */
    @ApiModelProperty(value="失效时间")
    @Schema(description="失效时间")
    private Date expireDate;

    /**
    * 创建时间
    */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
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

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCnImage() {
        return cnImage;
    }

    public void setCnImage(String cnImage) {
        this.cnImage = cnImage;
    }

    public String getEnImage() {
        return enImage;
    }

    public void setEnImage(String enImage) {
        this.enImage = enImage;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPushWay() {
        return pushWay;
    }

    public void setPushWay(Integer pushWay) {
        this.pushWay = pushWay;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public void setLinkTitle(String linkTitle) {
        this.linkTitle = linkTitle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", appId=").append(appId);
        sb.append(", title=").append(title);
        sb.append(", cnImage=").append(cnImage);
        sb.append(", enImage=").append(enImage);
        sb.append(", pushTime=").append(pushTime);
        sb.append(", expireDate=").append(expireDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
        sb.append(", pushWay=").append(pushWay);
        sb.append(", linkUrl=").append(linkUrl);
        sb.append(", linkTitle=").append(linkTitle);
        sb.append("]");
        return sb.toString();
    }
}