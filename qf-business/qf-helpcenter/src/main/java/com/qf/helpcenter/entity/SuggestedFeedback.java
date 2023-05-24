package com.qf.helpcenter.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


@Data
public class SuggestedFeedback {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

    /**
     * 问题标题
     */
    @ApiModelProperty(value = "问题标题")
    private String questionTitle;

    /**
     * 客户端类型
     */
    @ApiModelProperty(value = "客户端类型")
    private String client;

    /**
     * 问题分类
     */
    @ApiModelProperty(value = "问题分类")
    private String questionClassification;

    /**
     * 语言类型
     */
    @ApiModelProperty(value = "语言类型")
    private String languageType;

    /**
     * 用于问题分类排序
     */
    @ApiModelProperty(value = "用于问题分类排序")
    private Integer sortNumber;

    /**
     * 反馈创建时间
     */
    @ApiModelProperty(value = "反馈创建时间")
    private String creationTime;

    /**
     * 类型
     */
    @ApiModelProperty(value = "类型")
    private Integer type;
    /**
     * 问题内容
     */
    @ApiModelProperty(value = "问题内容")
    private String Question_content;
}

