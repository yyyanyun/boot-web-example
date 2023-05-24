package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DeliverySetting;
import com.qf.config.service.DeliverySettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("DeliverySetting")
@Api(tags = "派送设置接口")
public class DeliverySettingController {
    @Resource
    private DeliverySettingService deliverySettingService;

    @GetMapping("select")
    @ApiOperation("派送设置数据回显")
    @ApiImplicitParam(name = "deliveryId", value = "派送设置的方案号",defaultValue = "1")
    public RespResult<DeliverySetting> selectByDeliveryId(@RequestParam(defaultValue = "1") int deliveryId){
        return deliverySettingService.selectByDeliveryId(deliveryId);
    }
    @PostMapping("update")
    @ApiOperation("派送设置数据修改")
    @ApiImplicitParam(name = "deliverySetting",value = "请求对象")
    public RespResult<String> updateDeliverySetting(@RequestBody DeliverySetting deliverySetting){
        return deliverySettingService.updateDeliverySetting(deliverySetting);
    }
}
