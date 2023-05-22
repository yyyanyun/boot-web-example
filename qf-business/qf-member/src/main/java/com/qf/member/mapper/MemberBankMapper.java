package com.qf.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.member.entity.BankCard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberBankMapper extends BaseMapper<BankCard>{
}
