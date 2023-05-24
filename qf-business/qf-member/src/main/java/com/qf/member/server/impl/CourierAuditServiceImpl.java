package com.qf.member.server.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.common.base.utils.CommonBeanUtils;
import com.qf.member.entity.AuditDetails;
import com.qf.member.entity.CourierAudit;
import com.qf.member.entity.CourierCertification;
import com.qf.member.entity.RealName;
import com.qf.member.mapper.AuditDetailsMapper;
import com.qf.member.mapper.CourierAuditMapper;
import com.qf.member.mapper.CourierCertificationMapper;
import com.qf.member.mapper.MemberMapper;
import com.qf.member.server.CourierAuditService;
import com.qf.member.vo.AuditDetailsVOF;
import com.qf.member.vo.AuditDetailsVoT;
import com.qf.member.vo.CourierAuditMapperVo;
import com.qf.member.vo.CourierAuditVO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class CourierAuditServiceImpl implements CourierAuditService {
    @Resource
    private CourierAuditMapper courierAuditMapper;
    @Resource
    private AuditDetailsMapper auditDetailsMapper;
    @Resource
    private CourierCertificationMapper courierCertificationMapper;
    @Resource
    private MemberMapper memberMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RespResult save(CourierAudit courierAudit, CourierCertification courierCertification, AuditDetails auditDetails, RealName realName) {
        int insert = courierAuditMapper.insert(courierAudit);
        if (insert > 0) {
            if (courierAudit.getAuditType() == 0) {
                courierCertification.setMemberId(courierAudit.getMemberId());
                int insert1 = courierCertificationMapper.insert(courierCertification);
                if (insert1 > 0) {
                    auditDetails.setMemberId(courierAudit.getMemberId());
                    int insert2 = auditDetailsMapper.insert(auditDetails);
                    if (insert2 > 0) {
                        return RespResult.success("成功");
                    } else {
                        return RespResult.error(ResultCode.USER_NO_ADD);
                    }
                } else {
                    return RespResult.error(ResultCode.USER_NO_ADD);
                }
            } else {
                int insert1 = memberMapper.insert(realName);
                if (insert1 > 0) {
                    auditDetails.setMemberId(courierAudit.getMemberId());
                    int insert2 = auditDetailsMapper.insert(auditDetails);
                    if (insert2 > 0) {
                        return RespResult.success("成功");
                    } else {
                        return RespResult.error(ResultCode.USER_NO_ADD);
                    }
                } else {
                    return RespResult.error(ResultCode.USER_NO_ADD);
                }
            }
        } else {
            return RespResult.error(ResultCode.USER_NO_ADD);
        }
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public RespResult change(Long memberId, String auditStates, String RejectZhReasons, String RejectEnReasons) {
        AuditDetails auditDetails = auditDetailsMapper.selectByMemberId(memberId);
        if (!ObjectUtil.isEmpty(auditDetails)) {
            int i = auditDetailsMapper.updateByMemberId(memberId, auditStates);
            if (i > 0) {
                if (auditStates.equals("1")) {
                    auditDetails.setOperationTime(new Date());
                    int i1 = auditDetailsMapper.updateById(auditDetails);
                    if (i1 > 0) {
                        CourierAudit courierAudit = courierAuditMapper.selectByMemberId(memberId);
                        if (!ObjectUtil.isEmpty(courierAudit)) {
                            if (courierAudit.getAuditType() == 0) {
                                CourierCertification courierCertification = courierCertificationMapper.selectByMemberId(memberId);
                                if (!ObjectUtil.isEmpty(courierCertification)) {
                                    courierCertification.setCourierAuthenticationStatus(1);
                                    int i2 = courierCertificationMapper.updateById(courierCertification);
                                    if (i2 > 0) {
                                        return RespResult.success("成功");
                                    } else {
                                        return RespResult.error(ResultCode.USER_NO_UPDATE);
                                    }
                                } else {
                                    return RespResult.error(ResultCode.USER_NO_EXIST);
                                }
                            } else {
                                RealName realName = memberMapper.selectByMemberId01(memberId);
                                if (!ObjectUtil.isEmpty(realName)) {
                                    realName.setAuthenticationStatus(1);
                                    int i2 = memberMapper.updateById(realName);
                                    if (i2 > 0) {
                                        return RespResult.success("成功");
                                    } else {
                                        return RespResult.error(ResultCode.USER_NO_UPDATE);
                                    }
                                } else {
                                    return RespResult.error(ResultCode.USER_NO_EXIST);
                                }
                            }
                        } else {
                            return RespResult.error(ResultCode.USER_NO_EXIST);
                        }


                    } else {
                        return RespResult.error(ResultCode.USER_NO_UPDATE);
                    }
                } else {
                    auditDetails.setOperationTime(new Date());
                    auditDetails.setRejectZhReasons(RejectZhReasons);
                    auditDetails.setRejectEnReasons(RejectEnReasons);
                    int i3 = auditDetailsMapper.updateById(auditDetails);
                    if (i3 > 0) {
                        return RespResult.success("成功");
                    } else {
                        return RespResult.error(ResultCode.USER_NO_UPDATE);
                    }
                }
            } else {
                return RespResult.error(ResultCode.USER_NO_UPDATE);
            }
        } else {
            return RespResult.error(ResultCode.USER_NO_EXIST);
        }
    }

    @Override
    public RespResult<AuditDetailsVoT> list01(Long memberId) {
        AuditDetails auditDetails = auditDetailsMapper.selectByMemberId(memberId);
        AuditDetailsVoT auditDetailsVoT=new AuditDetailsVoT();
        BeanUtils.copyProperties(auditDetails,auditDetailsVoT);
        return  RespResult.success(auditDetailsVoT);

    }

    @Override
    public RespResult<AuditDetailsVOF> list02(Long memberId) {
        AuditDetails auditDetails = auditDetailsMapper.selectByMemberId(memberId);
       AuditDetailsVOF auditDetailsVoF=new AuditDetailsVOF();
        BeanUtils.copyProperties(auditDetails,auditDetailsVoF);
        return  RespResult.success(auditDetailsVoF);

    }

    @Override
    public PageInfo<CourierAuditMapperVo> list03(Integer page, Integer size, CourierAuditVO courierAudit, Date cStartTime, Date cEndTime, Date sStartTime, Date sEndTime, Integer documentType, String auditStates, Integer auditType) {
        PageInfo<CourierAuditMapperVo> PageInfo = PageHelper.startPage(page, size).doSelectPageInfo(() ->
                courierAuditMapper.selectAll(courierAudit, cStartTime, cEndTime, sStartTime, sEndTime, documentType, auditStates, auditType));
        return CommonBeanUtils.copyPageInfo(PageInfo,new PageInfo<>(),CourierAuditMapperVo::new);
    }
}
