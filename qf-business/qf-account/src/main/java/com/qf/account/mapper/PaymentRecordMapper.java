package com.qf.account.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.PaymentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentRecordMapper extends BaseMapper<PaymentRecord> {


    List<PaymentRecord> selectByPhoneOrTradeNoOrOrderNo(@Param("PaymentRecord") PaymentRecord paymentRecord);

    List<PaymentRecord> selectList(@Param("PaymentRecord") PaymentRecord paymentRecord);

    //查询支付详情信息
    PaymentRecord selectByIdAndStatus(@Param("id") Long id);

}