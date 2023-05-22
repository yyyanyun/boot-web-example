package com.qf.account.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.account.common.qo.ExchangeRateQO;
import com.qf.account.common.vo.ExchangeRateVO;
import com.qf.account.entity.ExchangeRate;
import com.qf.account.service.ExchangeRateService;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ExchangeRate")
@Api(tags = "汇率管理Api接口")
public class ExchangeRateController {

    @Resource
    private ExchangeRateService exchangeRateService;

    @PostMapping("/ExchangeRate")
    public RespResult<IPage<ExchangeRateVO>> selectList(@RequestParam(defaultValue = "1") Integer current, @RequestParam(defaultValue = "10") Integer pageSize, @RequestBody ExchangeRateQO exchangeRateQO) {

        return RespResult.success(exchangeRateService.selectList(current, pageSize, exchangeRateQO));

    }

    @GetMapping("/id")
    public RespResult<ExchangeRate> respResult(@RequestParam Long id) {
        return RespResult.success(exchangeRateService.selectById(id));
    }

}
