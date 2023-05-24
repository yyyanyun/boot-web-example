package com.qf.helpcenter.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class ProblemClassificationTableQo {


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
     * 分类状态，1表示有效，0表示无效
     */
    @ApiModelProperty(value = "分类状态，1表示有效，0表示无效")
    private Boolean type;
}
