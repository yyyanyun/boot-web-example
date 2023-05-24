package com.qf.cabinet.controller;

import com.github.pagehelper.PageInfo;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.service.ExpressBoxService;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.exception.ControllerException;
import com.qf.common.base.result.RespResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping("/xmh/box")
@Api(value = "ExpressBoxController", tags = "箱格接口描述")
public class ExpressBoxController {
    @Resource
    private ExpressBoxService expressBoxService;

    /**
     * 箱格显示界面数据
     */
    @ApiOperation(nickname = "list", value = "箱格显示界面数据")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true),
            @ApiImplicitParam(name = "size", value = "页量", required = true)})
    @PostMapping("/list")
    public RespResult<PageInfo<ExpressBoxVo>> list(@RequestParam(defaultValue = "1") int page,
                                                   @RequestParam(defaultValue = "5") int size,
                                                   @RequestBody @Valid ExpressBoxQo expressBoxQo) throws ControllerException {
        return expressBoxService.listBy(page, size, expressBoxQo);
    }


    /**
     * 箱格详情
     */
    @GetMapping("/list/log")
    @ApiOperation(nickname = "listByLog", value = "箱格详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "当前页", required = true),
            @ApiImplicitParam(name = "size", value = "页量", required = true),
            @ApiImplicitParam(name = "boxId", value = "箱格主键", required = true)})
    public RespResult<PageInfo<ExpressBoxVo>> listByLog(@RequestParam(defaultValue = "1") int page,
                                                        @RequestParam(defaultValue = "5") int size,
                                                        @RequestParam int boxId) throws ControllerException {
        return expressBoxService.listByLog(page, size, boxId);
    }

    /**
     * 修改箱格
     */
    @PutMapping("/alter")
    @ApiOperation(nickname = "alter", value = "修改箱格接口")
    public RespResult<Integer> alter(@RequestBody ExpressBoxQo expressBoxQo) throws ControllerException {
        return expressBoxService.alter(expressBoxQo);
    }



}
