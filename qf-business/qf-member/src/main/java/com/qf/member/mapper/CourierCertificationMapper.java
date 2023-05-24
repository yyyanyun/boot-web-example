package com.qf.member.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.member.entity.CourierAudit;
import com.qf.member.entity.CourierCertification;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourierCertificationMapper extends BaseMapper<CourierCertification> {
    default CourierCertification selectByMemberId(Long MemberId) {
        LambdaQueryWrapper<CourierCertification> lqw = new LambdaQueryWrapper<>();
        lqw.eq(CourierCertification::getMemberId, MemberId);
        return this.selectOne(lqw);
    }
}
