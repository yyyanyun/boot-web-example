package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.account.common.qo.ExchangeRateQO;
import com.qf.account.common.vo.ExchangeRateVO;
import com.qf.account.entity.ExchangeRate;
import com.qf.common.db.utils.PageCommonUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;


public interface ExchangeRateMapper extends BaseMapper<ExchangeRate> {


    default IPage<ExchangeRateVO> Ipage(Integer currentPageNO, Integer pageSize, @Param("ExchangeRateVO") ExchangeRateQO exchangeRateQO) {

        ExchangeRate exchangeRate = new ExchangeRate();

        BeanUtils.copyProperties(exchangeRateQO, exchangeRate);

        Page<ExchangeRate> exchangeRatePage = this.selectPage(new Page<>(currentPageNO, pageSize), new QueryWrapper<ExchangeRate>().gt("start_time", exchangeRate.getStartTime()).lt("end_time", exchangeRate.getEndTime()));

        return PageCommonUtils.copyPage(exchangeRatePage, new Page<>(), ExchangeRateVO::new);

    }

    ExchangeRate selectById(@Param("id") Long id);

}