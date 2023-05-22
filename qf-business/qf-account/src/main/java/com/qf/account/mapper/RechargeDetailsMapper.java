package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.RechargeDetails;
import org.apache.ibatis.annotations.Param;

public interface RechargeDetailsMapper extends BaseMapper<RechargeDetails> {


    RechargeDetails selectByRechargeId(@Param("rechargeId") Long rechargeId);

}