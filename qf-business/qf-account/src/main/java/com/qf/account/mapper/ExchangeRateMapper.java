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

import java.util.List;


public interface ExchangeRateMapper extends BaseMapper<ExchangeRate> {


    //汇率分页模糊查询

    List<ExchangeRate> selectList(@Param("ExchangeRate") ExchangeRate exchangeRate);

    ExchangeRate selectById(@Param("id") Long id);

}