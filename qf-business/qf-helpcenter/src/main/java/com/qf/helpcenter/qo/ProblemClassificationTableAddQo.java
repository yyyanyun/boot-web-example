package com.qf.helpcenter.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class ProblemClassificationTableAddQo {
    /**
     * 问题分类的中文名称
     */
    @ApiModelProperty(value = "问题分类的中文名称")
    private String chineseName;

    /**
     * 问题分类的英文名称
     */
    @ApiModelProperty(value = "问题分类的英文名称")
    private String englishName;

    /**
     * 问题分类适用的客户端类型
     */
    @ApiModelProperty(value = "问题分类适用的客户端类型")
    private String client;

    /**
     * 用于问题分类的排序
     */
    @ApiModelProperty(value = "用于问题分类的排序")
    private Integer sortNumber;


}
