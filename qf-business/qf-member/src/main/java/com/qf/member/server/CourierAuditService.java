package com.qf.member.server;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.AuditDetails;
import com.qf.member.entity.CourierAudit;
import com.qf.member.entity.CourierCertification;
import com.qf.member.entity.RealName;
import com.qf.member.vo.AuditDetailsVOF;
import com.qf.member.vo.AuditDetailsVoT;
import com.qf.member.vo.CourierAuditMapperVo;
import com.qf.member.vo.CourierAuditVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface CourierAuditService {
    RespResult save(CourierAudit courierAudit, CourierCertification courierCertification, AuditDetails auditDetails, RealName realName);
    RespResult change(Long memberId,String auditStates,String RejectZhReasons,String RejectEnReasons);
    RespResult<AuditDetailsVoT> list01(Long memberId);
    RespResult<AuditDetailsVOF> list02(Long memberId);
    PageInfo<CourierAuditMapperVo> list03(Integer page, Integer size, CourierAuditVO courierAudit, Date cStartTime, Date cEndTime , Date sStartTime, Date sEndTime, Integer documentType, String auditStates, Integer auditType);
}
