package com.qf.account.mapper;

import com.qf.account.common.qo.PaymentRecordQO;
import com.qf.account.entity.PaymentRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PaymentRecord record);

    int insertSelective(PaymentRecord record);

    PaymentRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PaymentRecord record);

    int updateByPrimaryKey(PaymentRecord record);

    List<PaymentRecord> selectByPhoneOrTradeNoOrOrderNo(@Param("PaymentRecord") PaymentRecord paymentRecord);

}