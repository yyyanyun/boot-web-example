package com.qf.cabinet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.service.ExpressBoxService;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.cache.CacheException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/xmh/box")
@Api("箱格接口描述")
public class ExpressBoxController {
    @Resource
    private ExpressBoxService expressBoxService;

    @ApiOperation(value = "list", tags = "根据柜机ID查询箱格")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true), @ApiImplicitParam(name = "size", value = "页量", required = true), @ApiImplicitParam(name = "cabinetId", value = "柜机ID", required = true)})
    @GetMapping("/list")
    public RespResult<IPage<ExpressBoxVo>> list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size, @RequestParam int cabinetId) throws CacheException {
        return expressBoxService.list(page, size, cabinetId);
    }
}
