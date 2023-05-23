package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.ExchangeRateDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExchangeRateDetailMapper extends BaseMapper<ExchangeRateDetail> {


    ExchangeRateDetail selectList(@Param("exchangeRateId") Long exchangeRateId);


}