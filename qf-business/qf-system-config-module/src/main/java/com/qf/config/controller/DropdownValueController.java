package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DropdownValue;
import com.qf.config.service.DropdownValueService;
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
@RequestMapping("DropdownConfigValue")
@Api(tags = "Dropdown value 配置接口")
@Validated
public class DropdownValueController {
    @Resource
    private DropdownValueService dropdownValueService;

    @PostMapping("add")
    @ApiOperation("增加value")
    @ApiImplicitParam(name = "dropdownValue",value = "请求对象")
    public RespResult<String> add(@RequestBody DropdownValue dropdownValue){
        return dropdownValueService.insertValue(dropdownValue);
    }

    @PostMapping("mod")
    @ApiOperation("修改value")
    @ApiImplicitParam(name = "dropdownValue",value = "请求对象")
    public RespResult<String> modValue(@RequestBody DropdownValue dropdownValue){
        return dropdownValueService.updateValue(dropdownValue);
    }

    @GetMapping("status")
    @ApiOperation("修改value的状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sortId",value = "请求对象"),
            @ApiImplicitParam(name = "status",value = "请求对象")
    })
    public RespResult<String> modValueStatus(@RequestParam Integer sortId, @Max(2) @Min(1) @RequestParam Integer status){
        return dropdownValueService.updateValueStatus(sortId,status);
    }
}
