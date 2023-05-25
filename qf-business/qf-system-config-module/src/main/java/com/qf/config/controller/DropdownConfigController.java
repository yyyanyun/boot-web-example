package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DropdownConfig;
import com.qf.config.service.DropdownConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("dropdown/config")
@Api(tags = "Dropdown配置接口")
@Validated
public class DropdownConfigController {
    @Resource
    private DropdownConfigService dropdownConfigService;

    @PostMapping("add")
    @ApiOperation("增加key")
    @ApiImplicitParam(name = "dropdownConfig",value = "请求对象")
    public RespResult<String> add(@RequestBody DropdownConfig dropdownConfig){
        return dropdownConfigService.insertKey(dropdownConfig);
    }

    @PostMapping("mod")
    @ApiOperation("修改key")
    @ApiImplicitParam(name = "dropdownConfig",value = "请求对象")
    public RespResult<String> modKey(@RequestBody DropdownConfig dropdownConfig){
        return dropdownConfigService.updateKey(dropdownConfig);
    }

    @GetMapping("status")
    @ApiOperation("修改key的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dropdownId",value = "请求对象"),
            @ApiImplicitParam(name = "status",value = "请求对象")
    })
    public RespResult<String> modKeyStatus(@RequestParam Integer dropdownId, @Max (2) @Min (1) @RequestParam Integer status){
        return dropdownConfigService.updateKeyStatus(dropdownId,status);
    }
}
