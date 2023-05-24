package com.qf.member.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.member.entity.CourierAudit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface CourierAuditMapper extends BaseMapper<CourierAudit> {
    default CourierAudit selectByMemberId(Long MemberId) {
        LambdaQueryWrapper<CourierAudit> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CourierAudit::getMemberId, MemberId);
        return this.selectOne(lqw);
    }
    List<CourierAudit> selectAll(@Param("courierAudit") CourierAudit courierAudit, @Param("cStartTime")Date cStartTime,@Param("cEndTime") Date cEndTime ,@Param("sStartTime")Date sStartTime,@Param("sEndTime") Date sEndTime,@Param("documentType") Integer documentType,@Param("auditStates") String auditStates,@Param("auditType") Integer auditType);

}
