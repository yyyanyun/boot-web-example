package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.RechargeRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RechargeRecordMapper extends BaseMapper<RechargeRecord> {


    //普通查询
    List<RechargeRecord> selectByAccountIdORMobile(@Param("RechargeRecord") RechargeRecord rechargeRecord);

    //高级搜索
    List<RechargeRecord> selectList(@Param("RechargeRecord") RechargeRecord rechargeRecord);

    RechargeRecord selectById(@Param("id") Long id);

}