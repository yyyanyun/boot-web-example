package com.qf.account.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

/**
    * 充值详情表
    */
@ApiModel(description="充值详情表")
@TableName(value = "recharge_details")
public class RechargeDetails {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 充值记录ID
     */
    @TableField(value = "recharge_id")
    @ApiModelProperty(value="充值记录ID")
    private Long rechargeId;

    /**
     * 付款时间
     */
    @TableField(value = "payment_time")
    @ApiModelProperty(value="付款时间")
    private Date paymentTime;

    /**
     * 关闭时间
     */
    @TableField(value = "close_time")
    @ApiModelProperty(value="关闭时间")
    private Date closeTime;

    public static final String COL_ID = "id";

    public static final String COL_RECHARGE_ID = "recharge_id";

    public static final String COL_PAYMENT_TIME = "payment_time";

    public static final String COL_CLOSE_TIME = "close_time";

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取充值记录ID
     *
     * @return recharge_id - 充值记录ID
     */
    public Long getRechargeId() {
        return rechargeId;
    }

    /**
     * 设置充值记录ID
     *
     * @param rechargeId 充值记录ID
     */
    public void setRechargeId(Long rechargeId) {
        this.rechargeId = rechargeId;
    }

    /**
     * 获取付款时间
     *
     * @return payment_time - 付款时间
     */
    public Date getPaymentTime() {
        return paymentTime;
    }

    /**
     * 设置付款时间
     *
     * @param paymentTime 付款时间
     */
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * 获取关闭时间
     *
     * @return close_time - 关闭时间
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 设置关闭时间
     *
     * @param closeTime 关闭时间
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}