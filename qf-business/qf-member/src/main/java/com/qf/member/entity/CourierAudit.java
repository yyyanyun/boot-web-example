package com.qf.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@TableName("t_courier_audit")
@Data
public class CourierAudit {
    /**
     * ID(主键)
     */
    @TableId(value = "member_id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "ID(主键)")
    private Long memberId;

    /**
     * 真实姓名
     */
    @TableField("member_name")
    @ApiModelProperty(value = "真实姓名")
    private String memberName;

    /**
     * 手机号码
     */
    @TableField("phone")
    @ApiModelProperty(value = "手机号码")
    private String phone;

    /**
     * 注册类型 0 自主注册 1 手工注册
     */
    @TableField("registration_type")
    @ApiModelProperty(value = "注册类型 0 自主注册 1 手工注册")
    private Integer registrationType;

    /**
     * 审核类型 0 快递员审核 1 实名认证
     */
    @TableField("audit_type")
    @ApiModelProperty(value = "审核类型 0 快递员审核 1 实名认证")
    private Integer auditType;

    /**
     * 照片
     */
    @TableField("photo")
    @ApiModelProperty(value = "照片")
    private String photo;

    @TableField("create_time")
    @ApiModelProperty(value = "创造时间")
    private Date createTime;
    private AuditDetails auditDetails;
    private RealName realName;
}
