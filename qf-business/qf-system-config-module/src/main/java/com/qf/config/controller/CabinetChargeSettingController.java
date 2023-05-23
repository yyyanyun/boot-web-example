package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.CabinetChargeSetting;
import com.qf.config.entity.DeliverySetting;
import com.qf.config.service.CabinetChargeSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("CabinetChargeSetting")
@Api(tags = "智能柜收费设置接口")
public class CabinetChargeSettingController {
    @Resource
    private CabinetChargeSettingService cabinetChargeSettingService;

    @GetMapping("select")
    @ApiOperation("智能柜收费设置回显")
    @ApiImplicitParam(name = "cabinetId" , value = "收费设置的方案号",defaultValue = "1")
    public RespResult<CabinetChargeSetting> selectByCabinetId(@RequestParam(defaultValue = "1") int cabinetId){
        return cabinetChargeSettingService.selectByCabinetId(cabinetId);
    }

    @PostMapping("update")
    @ApiOperation("智能柜收费设置数据修改")
    @ApiImplicitParam(name = "cabinetChargeSetting",value = "请求对象")
    public RespResult<String> updateCabinetChargeSetting(@RequestBody CabinetChargeSetting cabinetChargeSetting){
        return cabinetChargeSettingService.updateCabinetChargeSetting(cabinetChargeSetting);
    }
}
