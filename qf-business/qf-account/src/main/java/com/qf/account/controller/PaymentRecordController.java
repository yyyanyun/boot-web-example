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
@RequestMapping("/paymentRecord")
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

    @PostMapping("/query/list")
    @ApiOperation("查询所有支付记录信息高级搜索")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "paymentRecordQO", value = "请求对象参数"),


    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    public RespResult<PageInfo<PaymentRecordVO>> queryList(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody PaymentRecordQO paymentRecordQO) {

        return RespResult.success(paymentRecordService.QueryList(currentPageNo, pageSize, paymentRecordQO));
    }

    @ApiOperation("支付记录的详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "支付记录交易号id", defaultValue = "1",required = true),


    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    @GetMapping("/id")
    public RespResult<PaymentRecordVO> selectById(@RequestParam Long id) {
        return RespResult.success(paymentRecordService.selectById(id));
    }
}
