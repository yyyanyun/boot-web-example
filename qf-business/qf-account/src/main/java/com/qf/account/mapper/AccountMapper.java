package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account> {



    int deleteByPrimaryKey(Long id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    List<Account> selectByPhoneOrId(@Param("id") Long id, @Param("phone") String phone);


    List<Account> selectAdvancedSearch(@Param("Account") Account account);
}