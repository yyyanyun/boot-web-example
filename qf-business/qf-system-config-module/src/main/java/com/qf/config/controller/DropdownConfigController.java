package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DropdownConfig;
import com.qf.config.service.DropdownConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("DropdownConfig")
@Api(tags = "Dropdown配置接口")
public class DropdownConfigController {
    @Resource
    private DropdownConfigService dropdownConfigService;

    @PostMapping("insert")
    @ApiOperation("增加key")
    @ApiImplicitParam(name = "dropdownConfig",value = "请求对象")
    public RespResult<String> insertKey(@RequestBody DropdownConfig dropdownConfig){
        return dropdownConfigService.insertKey(dropdownConfig);
    }



}
