package com.qf.member.controller;


import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.AuditDetails;
import com.qf.member.entity.CourierAudit;
import com.qf.member.entity.CourierCertification;
import com.qf.member.entity.RealName;
import com.qf.member.server.CourierAuditService;
import com.qf.member.vo.AuditDetailsVOF;
import com.qf.member.vo.AuditDetailsVoT;
import com.qf.member.vo.CourierAuditMapperVo;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/courierAudit")
@Api("快递员审核")
public class CourierAuditController {
    @Autowired
    private CourierAuditService courierAuditService;

    @PutMapping("/change")
    @ApiOperation("审核同意和失败")
    @ApiImplicitParams({@ApiImplicitParam(value = "ID", name = "memberId"),
            @ApiImplicitParam(name = "auditStates", value = "审核状态"),
            @ApiImplicitParam(name = "RejectZhReasons", value = "中文原因"),
            @ApiImplicitParam(name = "RejectEnReasons", value = "英文原因")})
    public RespResult change(@RequestParam("memberId") Long memberId, @RequestParam("auditStates") String auditStates, @RequestParam("RejectZhReasons") String RejectZhReasons, @RequestParam("RejectEnReasons") String RejectEnReasons) {
        return courierAuditService.change(memberId, auditStates, RejectZhReasons, RejectEnReasons);
    }

        @PostMapping("/save")
    @ApiOperation("增加快递员审核信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "courierAudit", value = "审核人信息"),
            @ApiImplicitParam(name = "courierCertification", value = "快递员认证"),
            @ApiImplicitParam(name = "auditDetails", value = "审核信息"),
            @ApiImplicitParam(name = "realName", value = "实名信息")})
    public RespResult save(@RequestBody CourierAudit courierAudit, @RequestBody CourierCertification courierCertification, @RequestBody AuditDetails auditDetails, @RequestBody RealName realName) {
        return courierAuditService.save(courierAudit, courierCertification, auditDetails, realName);

    }


    @ApiImplicitParam(name = "memberId", value = "ID")
    @GetMapping("/list01")
    @ApiOperation("查询成功的信息审核信息")
    public RespResult<AuditDetailsVoT> list01(@RequestParam("memberId") Long memberId) {
        return courierAuditService.list01(memberId);
    }

    @ApiImplicitParam(name = "memberId", value = "ID")
    @GetMapping("/list02")
    @ApiOperation("查询失败的信息审核信息")
    public RespResult<AuditDetailsVOF> list02(@RequestParam("memberId") Long memberId) {
        return courierAuditService.list02(memberId);
    }

//   @GetMapping("/list03")
    @ApiOperation("查询快递员审核列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "起始页量"),
            @ApiImplicitParam(name = "size", value = "页量"),
            @ApiImplicitParam(name = "courierAudit", value = "审核人信息"),
            @ApiImplicitParam(name = "cStartTime", value = "创造时间的开始时间"),
            @ApiImplicitParam(name = "cEndTime", value = "创造时间的结束时间"),
            @ApiImplicitParam(name = "sStartTime", value = "审核的开始时间"),
            @ApiImplicitParam(name = "sEndTime", value = "审核的结束时间"),
            @ApiImplicitParam(name = "documentType", value = "证件类型"),
            @ApiImplicitParam(name = "auditStates", value = "审核状态"),
            @ApiImplicitParam(name = "auditType", value = "审核类型"),})
    public RespResult<PageInfo<CourierAuditMapperVo>> list03(@RequestParam(name = "page" ,defaultValue = "1") Integer page,@RequestParam(name = "size" ,defaultValue = "10") Integer size, CourierAudit courierAudit, Date cStartTime, Date cEndTime, Date sStartTime, Date sEndTime, Integer documentType, String auditStates, Integer auditType) {
        return RespResult.success(courierAuditService.list03(page, size, courierAudit, cStartTime, cEndTime, sStartTime, sEndTime, documentType, auditStates, auditType));
    }

}

