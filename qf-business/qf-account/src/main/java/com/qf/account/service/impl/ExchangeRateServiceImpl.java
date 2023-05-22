package com.qf.account.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.account.common.qo.ExchangeRateQO;
import com.qf.account.common.vo.ExchangeRateVO;
import com.qf.account.entity.ExchangeRate;
import com.qf.account.mapper.ExchangeRateMapper;
import com.qf.account.service.ExchangeRateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Resource
    private ExchangeRateMapper exchangeRateMapper;

    @Override
    public IPage<ExchangeRateVO> selectList(Integer current, Integer pageSize, ExchangeRateQO exchangeRateQO) {
        return exchangeRateMapper.Ipage(current, pageSize, exchangeRateQO);

    }

    @Override
    public ExchangeRate selectById(Long id) {

        ExchangeRate exchangeRate = exchangeRateMapper.selectById(id);
        System.out.println(exchangeRate);
        return exchangeRate;

    }
}
