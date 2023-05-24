package com.qf.member.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
@Data
public class CourierAuditMapperVo {
    /**
     * ID(主键)
     */
    @TableId(value = "member_id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "ID(主键)")
    private Long memberId;


    /**
     * 手机号码
     */
    @TableField("phone")
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 审核类型 0 快递员审核 1 实名认证
     */
    @TableField("audit_type")
    @ApiModelProperty(value = "审核类型 0 快递员审核 1 实名认证")
    private Integer auditType;
    /**
     * 证件类型 0 身份证 1 其他
     */
    @TableField("document_type")
    @ApiModelProperty(value = "证件类型 0 身份证 1 其他")
    private Integer documentType;

    /**
     * 照片
     */
    @TableField("photo")
    @ApiModelProperty(value = "照片")
    private String photo;

    @TableField("create_time")
    @ApiModelProperty(value = "创造时间")
    private Date createTime;
    /**
     * 操作时间
     */
    @TableField("operation_time")
    @ApiModelProperty(value = "操作时间")
    private Date operationTime;
    /**
     * 审核状态 0 未审核 1 已通过 2 已拒绝
     */
    @TableField("audit_states")
    @ApiModelProperty(value = "审核状态 0 未审核 1 已通过 2 已拒绝")
    private String auditStates;
}
