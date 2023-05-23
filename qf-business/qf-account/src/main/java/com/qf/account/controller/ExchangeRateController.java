package com.qf.account.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.qf.account.common.qo.ExchangeRateQO;
import com.qf.account.common.vo.ExchangeRateVO;
import com.qf.account.entity.ExchangeRate;
import com.qf.account.service.ExchangeRateService;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.*;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/exchangeRate")
@Api(tags = "汇率管理Api接口")
public class ExchangeRateController {

    @Resource
    private ExchangeRateService exchangeRateService;

    @ApiOperation("查询所有汇率信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "currentPageNo", value = "当前页", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "页量", defaultValue = "10"),
            @ApiImplicitParam(name = "exchangeRateQO", value = "请求参数对象"),

    })

    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    @PostMapping("/exchangeRate/list")
    public RespResult<PageInfo<ExchangeRateVO>> selectList(@RequestParam(defaultValue = "1") Integer currentPageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody ExchangeRateQO exchangeRateQO) {

        return RespResult.success(exchangeRateService.selectList(currentPageNo, pageSize, exchangeRateQO));

    }

    @ApiOperation("查询单个汇率的详情信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "汇率详情所属汇率id", defaultValue = "1", required = true),

    })

    @ApiResponses({
            @ApiResponse(code = 200, message = "成功"),
            @ApiResponse(code = 400, message = "失败")
    })
    @GetMapping("/id")
    public RespResult<ExchangeRate> respResult(@RequestParam Long id) {
        return RespResult.success(exchangeRateService.selectById(id));
    }

}
