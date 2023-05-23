package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.PickupSetting;
import com.qf.config.service.PickupSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("PickupSetting")
@Api(tags = "取件设置接口")
public class PickupSettingController {
    @Resource
    private PickupSettingService pickupSettingService;

    @GetMapping("select")
    @ApiOperation("取件设置数据回显")
    @ApiImplicitParam(name = "pickupId", value = "取件设置的方案号",defaultValue = "1")
    public RespResult<PickupSetting> selectByPickupId(@RequestParam(defaultValue = "1") int pickupId){
        return pickupSettingService.selectByPickupId(pickupId);
    }
    @PostMapping("update")
    @ApiOperation("取件设置数据修改")
    @ApiImplicitParam(name = "pickupSetting",value = "请求对象")
    public RespResult<String> updatePickupSetting(@RequestBody PickupSetting pickupSetting){
        return pickupSettingService.updatePickupSetting(pickupSetting);
    }
}
