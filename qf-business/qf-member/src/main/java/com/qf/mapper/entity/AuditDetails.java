package com.qf.member.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@TableName("audit_details")
@Data
public class AuditDetails {
    /**
     * 审核id
     */
    @TableId("audit_id")
    @ApiModelProperty(value = "审核id")
    private Integer auditId;

    /**
     * 操作时间
     */
    @TableField("operation_time")
    @ApiModelProperty(value = "操作时间")
    private Date operationTime;

    /**
     * 拒绝中文原因
     */
    @TableField("reject_zh_reasons")
    @ApiModelProperty(value = "拒绝中文原因")
    private String rejectZhReasons;

    /**
     * 拒绝英文原因
     */
    @TableField("reject_en_reasons")
    @ApiModelProperty(value = "拒绝英文原因")
    private String rejectEnReasons;

    /**
     * 审核状态 0 未审核 1 已通过 2 已拒绝
     */
    @TableField("audit_states")
    @ApiModelProperty(value = "审核状态 0 未审核 1 已通过 2 已拒绝")
    private String auditStates;

    /**
     * ID
     */
    @TableField("member_id")
    @ApiModelProperty(value = "ID")
    private Long memberId;
}
