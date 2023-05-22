package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.PaymentDetail;
import org.apache.ibatis.annotations.Param;

public interface PaymentDetailMapper extends BaseMapper<PaymentDetail> {


    PaymentDetail selectByTradeNo(@Param("tradeNo") Long tradeNo);

}