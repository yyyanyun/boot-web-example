package com.qf.account.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.account.common.qo.ExchangeRateQO;
import com.qf.account.common.vo.ExchangeRateVO;
import com.qf.account.entity.ExchangeRate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface ExchangeRateService {

    IPage<ExchangeRateVO> selectList(Integer current, Integer pageSize, ExchangeRateQO exchangeRateQO);

    ExchangeRate selectById(Long id);




}
