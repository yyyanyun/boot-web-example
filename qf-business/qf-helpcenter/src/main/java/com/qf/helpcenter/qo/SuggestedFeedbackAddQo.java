package com.qf.helpcenter.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SuggestedFeedbackAddQo {

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
     * 问题内容
     */
    @ApiModelProperty(value = "问题内容")
    private String Question_content;
}

