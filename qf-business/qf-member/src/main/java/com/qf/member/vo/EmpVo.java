package com.qf.member.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;
@Data
public class EmpVo {
    /**
     * ID
     */
    @ApiModelProperty(value="ID")
    @Schema(description="ID")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    @Schema(description="用户名")
    private String username;


    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    @Schema(description="姓名")
    private String name;

    /**
     * 性别, 说明: 1 男, 2 女
     */
    @ApiModelProperty(value="性别, 说明: 1 男, 2 女")
    @Schema(description="性别, 说明: 1 男, 2 女")
    private Byte gender;

    /**
     * 图像
     */
    @ApiModelProperty(value="图像")
    @Schema(description="图像")
    private String image;

    /**
     * 职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师
     */
    @ApiModelProperty(value="职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师")
    @Schema(description="职位, 说明: 1 班主任,2 讲师, 3 学工主管, 4 教研主管, 5 咨询师")
    private Byte job;

    /**
     * 入职时间
     */
    @ApiModelProperty(value="入职时间")
    @Schema(description="入职时间")
    private Date entrydate;

    /**
     * 部门ID
     */
    @ApiModelProperty(value="部门ID")
    @Schema(description="部门ID")
    private Integer deptId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    @Schema(description="创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value="修改时间")
    @Schema(description="修改时间")
    private Date updateTime;
}
