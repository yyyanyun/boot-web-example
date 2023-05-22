package com.qf.account.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.account.entity.Account;
import com.qf.common.base.exception.DaoException;
import com.qf.common.base.result.ResultCode;
import org.apache.ibatis.annotations.Param;
import org.springframework.util.ObjectUtils;

import java.util.List;


public interface AccountMapper extends BaseMapper<Account> {


    default int updateUnlock(Long id, int status) {
        Account account = this.selectById(id);
        if (ObjectUtils.isEmpty(account)) {
            throw new DaoException(ResultCode.SYS_ERROR);
        }
        return this.update(new Account(), new UpdateWrapper<Account>().eq("id", id).set("status", status));
    }


    List<Account> selectByPhoneOrId(@Param("id") Long id, @Param("phone") String phone);


    List<Account> selectAdvancedSearch(@Param("Account") Account account, @Param("paymentStatus") int paymentStatus);
}