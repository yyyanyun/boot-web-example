package com.qf.member.entity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

@Validated

@Data
@TableName("t_courier_certification")
public class CourierCertification {
    /**
     * 快递认证id
     */
    @ApiModelProperty(value = "快递认证id")
    @TableId("t_courier_certification_id")
    private Integer tCourierCertificationId;

    /**
     * 0 未认证 1 已认证
     */
    @TableField("courier_authentication_status")
    @ApiModelProperty(value = "0 未认证 1 已认证")
    private Integer courierAuthenticationStatus;

    /**
     * 快递公司
     */
    @TableField("express_company")
    @Pattern(regexp = "\b[0,3]\b",message = "不符合公司名称")
    @ApiModelProperty(value = "快递公司")
    private Integer expressCompany;

    /**
     * 照片
     */
    @TableField("photo")
    @ApiModelProperty(value = "照片")
    private String photo;

    /**
     * ID
     */
    @TableField("member_id")
    @ApiModelProperty(value = "ID")
    private Integer memberId;
}
