package com.qf.helpcenter.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


@Data
public class ProblemClassificationTable {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id")
    private Integer id;

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

    /**
     * 分类创建时间
     */
    @ApiModelProperty(value = "分类创建时间")
    private Date creationTime;

    /**
     * 分类状态，1表示有效，0表示无效
     */
    @ApiModelProperty(value = "分类状态，1表示有效，0表示无效")
    private Boolean type;
}

