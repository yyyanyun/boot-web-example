package com.qf.order.controller;
import com.qf.common.base.result.RespResult;
import com.qf.order.server.QuerydetailsServer;
import com.qf.order.vo.RecipientVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;
@Validated
@RestController
@Api("查看订单详细信息接口")
@RequestMapping("/querydetails")
public class QueryDetailsController {
    @Autowired
    private QuerydetailsServer querydetailsServer;
    @ApiOperation("查看订单信息")
    @PostMapping("/showdetails")
    public RespResult<RecipientVo> showDetails(@RequestBody @NotNull long orderid){
        return RespResult.success(querydetailsServer.selectOrder(orderid));
    }
}

