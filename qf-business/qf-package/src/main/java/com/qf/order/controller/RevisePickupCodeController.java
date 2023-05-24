package com.qf.order.controller;
import com.qf.common.base.result.RespResult;
import com.qf.order.server.UpdatePickupCodeServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/update")
@Api("重新发送取货码接口")
public class RevisePickupCodeController {
    @Autowired
    private UpdatePickupCodeServer updatePickupCodeServer;
    @ApiOperation("查询订单状态发送取货码")
    @PutMapping("/code")
    public RespResult revisePickupCodeController(Long  orderid){
        RespResult respResult = updatePickupCodeServer.updatePickupCode(orderid);
        return respResult;

    }
}
