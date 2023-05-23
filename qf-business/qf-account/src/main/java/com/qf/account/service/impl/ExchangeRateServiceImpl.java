package com.qf.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.ExchangeRateQO;
import com.qf.account.common.utils.PageInfoUtils;
import com.qf.account.common.vo.ExchangeRateVO;
import com.qf.account.entity.ExchangeRate;
import com.qf.account.mapper.ExchangeRateMapper;
import com.qf.account.service.ExchangeRateService;
import com.qf.common.db.utils.PageCommonUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Resource
    private ExchangeRateMapper exchangeRateMapper;

    @Override
    public PageInfo<ExchangeRateVO> selectList(Integer current, Integer pageSize, ExchangeRateQO exchangeRateQO) {

        ExchangeRate exchangeRate = new ExchangeRate();

        BeanUtils.copyProperties(exchangeRateQO, exchangeRate);

        PageInfo<ExchangeRateVO> pageInfo = PageHelper.startPage(current, pageSize).doSelectPageInfo(() -> exchangeRateMapper.selectList(exchangeRate));

        return PageInfoUtils.copyPage(pageInfo, new PageInfo<>(), ExchangeRateVO::new);


    }


    @Override
    public ExchangeRate selectById(Long id) {

        //汇率详情
        return exchangeRateMapper.selectById(id);
    }
}
