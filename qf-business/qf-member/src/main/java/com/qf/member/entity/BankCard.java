package com.qf.member.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;
@TableName("t_bank_card")
@Data
public class BankCard {
    /**
     * 银行卡id
     */
    @TableId("bank_card_id")
    @ApiModelProperty(value = "银行卡id")
    private Integer bankCardId;

    /**
     * 国家
     */
    @TableField("country")
    @ApiModelProperty(value = "国家")
    private String country;

    /**
     * 开户银行
     */
    @TableField("bank")
    @ApiModelProperty(value = "开户银行")
    private String bank;

    /**
     * 银行卡号
     */
    @TableField("bank_card_number")
    @ApiModelProperty(value = "银行卡号")
    private Integer bankCardNumber;

    /**
     * 开户人
     */
    @TableField("card_username")
    @ApiModelProperty(value = "开户人")
    private String cardUsername;

    /**
     * 绑定时间
     */
    @TableField("binding_time")
    @ApiModelProperty(value = "绑定时间")
    private Date bindingTime;

    /**
     * ID
     */
    @TableField("member_id")
    @ApiModelProperty(value = "ID")
    private Integer memberId;

    /**
     * 会员余额
     */
    @TableField("member_balance")
    @ApiModelProperty(value = "会员余额")
    private Double memberBalance;

    /**
     * 支付密码 0 未设置 1已设置
     */
    @TableField("payment_code")
    @ApiModelProperty(value = "支付密码 0 未设置 1已设置 ")
    private Integer paymentCode;

    /**
     * 账户状态 0正常 1冻结
     */
    @TableField("account_status")
    @ApiModelProperty(value = "账户状态 0正常 1冻结")
    private Integer accountStatus;
}
