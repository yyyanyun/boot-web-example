package com.qf.cabinet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.service.ExpressBoxService;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.cache.CacheException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/xmh/box")
@Api("箱格接口描述")
public class ExpressBoxController {
    @Resource
    private ExpressBoxService expressBoxService;

    /**
     * 箱格显示界面数据
     */
    @ApiOperation(value = "list", tags = "箱格显示界面数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true),
            @ApiImplicitParam(name = "size", value = "页量", required = true)})
    @PostMapping("/list/{page}/{size}")
    public RespResult<IPage<ExpressBoxVo>> list(@PathVariable @RequestParam(defaultValue = "1") int page, @PathVariable @RequestParam(defaultValue = "5") int size, @RequestBody ExpressBoxQo expressBoxQo) throws CacheException {
        return expressBoxService.listBy(page, size, expressBoxQo);
    }


}
