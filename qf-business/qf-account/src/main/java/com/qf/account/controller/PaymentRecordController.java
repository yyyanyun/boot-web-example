package com.qf.account.controller;

import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.PaymentRecordQO;
import com.qf.account.common.vo.PaymentRecordVO;
import com.qf.account.service.PaymentRecordService;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/PaymentRecord")
@Api(tags = "支付信息管理Api接口")
public class PaymentRecordController {

    @Resource
    private PaymentRecordService paymentRecordService;

    @PostMapping("/list")
    @ApiOperation("查询所有支付记录信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "paymentRecordQO", value = "请求对象参数"),


    })

    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public RespResult<PageInfo<PaymentRecordVO>> list(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody PaymentRecordQO paymentRecordQO) {
        return RespResult.success(paymentRecordService.selectList(currentPageNo, pageSize, paymentRecordQO));
    }
}
