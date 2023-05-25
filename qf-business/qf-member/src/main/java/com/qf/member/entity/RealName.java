package com.qf.member.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.mybatis.spring.annotation.MapperScan;

@TableName("t_real_name")
@Data
public class RealName {
    /**
     * 实名id(主键)
     */
    @TableId("real_name_id")
    @ApiModelProperty(value = "实名id(主键)")
    private Integer realNameId;

    /**
     * ID
     */
    @TableField("member_id")
    @ApiModelProperty(value = "ID")
    private Integer memberId;

    /**
     * 认证状态 0未认证 1 已认证
     */
    @TableField("authentication_status")
    @ApiModelProperty(value = "认证状态 0未认证 1 已认证")
    private Integer authenticationStatus;

    /**
     * 证件类型 0 身份证 1 其他
     */
    @TableField("document_type")
    @ApiModelProperty(value = "证件类型 0 身份证 1 其他")
    private Integer documentType;

    /**
     * 正面图片
     */
    @TableField("front_image")
    @ApiModelProperty(value = "正面图片")
    private String frontImage;

    /**
     * 方面图片
     */
    @TableField("negative_image")
    @ApiModelProperty(value = "方面图片")
    private String negativeImage;
}

