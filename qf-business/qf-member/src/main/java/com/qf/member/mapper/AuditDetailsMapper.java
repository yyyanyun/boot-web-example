package com.qf.member.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.member.entity.AuditDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface AuditDetailsMapper extends BaseMapper<AuditDetails> {
   int  updateByMemberId(@Param("memberId") Long memberId,@Param("auditStates") String auditStates);
   default AuditDetails selectByMemberId(Long MemberId) {
      LambdaQueryWrapper<AuditDetails> lqw = new LambdaQueryWrapper<>();
      lqw.eq(AuditDetails::getMemberId, MemberId);
      return this.selectOne(lqw);
   }
   AuditDetails selectByMemberId01(@Param("memberId") Long memberId);
}
