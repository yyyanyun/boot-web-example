package com.qf.member.controller;

import com.github.pagehelper.PageInfo;
import com.qf.common.base.result.RespResult;
import com.qf.member.entity.Courier;
import com.qf.member.entity.CourierCertification;
import com.qf.member.mapper.CourierMapper;
import com.qf.member.server.CourierService;
import com.qf.member.vo.CourierVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.Date;


@RestController
@RequestMapping("/courier")
@Api("快递员")
public class CourierController {
    @Autowired
    private CourierService courierService;

    @GetMapping("list01")
    @ApiOperation("查询快递员列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "起始页面"),
            @ApiImplicitParam(name = "size", value = "页量"),
            @ApiImplicitParam(name = "CourierVo", value = "快递员属性"),
            @ApiImplicitParam(name = "startTime", value = "开始时间"),
            @ApiImplicitParam(name = "endTime", value = "结束时间")})
    public RespResult<PageInfo<CourierVo>> list01(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, CourierVo courierVo, Date startTime, Date endTime) {
        return RespResult.success(courierService.list01(page, size, courierVo, startTime, endTime));
    }

    @GetMapping("list02")
    @ApiOperation("查询快递员认证")
    @ApiImplicitParam(name = "memberId", value = "Id")
    public RespResult<CourierCertification> list02(@RequestParam("memberId") Integer memberId) {
        return RespResult.success(courierService.list02(memberId));
    }

    @PutMapping("save")
    @ApiOperation("添加快递员")
    @ApiImplicitParams({@ApiImplicitParam(name = "courier", value = "快递员基本信息"),
            @ApiImplicitParam(name = "courierCertification", value = "快递员认证信息"),
            @ApiImplicitParam(name = "phoneType" ,value = "手机区号")
    })
    public RespResult save(@Valid Courier courier, @Valid CourierCertification courierCertification,@RequestParam("phoneType")@Pattern(regexp = "\b[0,1]\b",message = "不在范围") Integer phoneType ) {
        return courierService.save(courier, courierCertification,phoneType);
    }
}
