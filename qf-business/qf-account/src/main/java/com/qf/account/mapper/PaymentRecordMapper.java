package com.qf.account.mapper;


import com.qf.account.entity.PaymentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentRecordMapper {


    List<PaymentRecord> selectByPhoneOrTradeNoOrOrderNo(@Param("PaymentRecord") PaymentRecord paymentRecord);

    List<PaymentRecord> selectList(@Param("PaymentRecord") PaymentRecord paymentRecord);
}