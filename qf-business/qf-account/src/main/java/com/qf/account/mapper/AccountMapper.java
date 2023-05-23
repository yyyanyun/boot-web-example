package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.Account;
import com.qf.account.entity.PaymentRecord;
import com.qf.common.base.exception.DaoException;
import com.qf.common.base.result.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.ObjectUtils;

import java.util.List;


public interface AccountMapper extends BaseMapper<Account> {


    //普通查询
    List<Account> selectByPhoneOrId(@Param("id") Long id, @Param("phone") String phone);


    //高级搜索
    List<Account> selectAdvancedSearch(@Param("Account") Account account, @Param("paymentStatus") Integer paymentStatus);

    //根据id 判断账户是否存在

    Account selectById(@Param("id") Long id);
}