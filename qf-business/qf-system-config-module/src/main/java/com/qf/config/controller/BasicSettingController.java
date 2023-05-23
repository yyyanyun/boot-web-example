package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.BasicSetting;
import com.qf.config.service.BasicSettingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("BasicSetting")
@Api(tags = "基础设置接口")
public class BasicSettingController {
    @Resource
    private BasicSettingService basicSettingService;

    @GetMapping("select")
    @ApiOperation("基础设置数据回显")
    @ApiImplicitParam(name = "basicId",value = "基础设置的方案号",defaultValue = "1")
    public RespResult<BasicSetting> selectByBasicId(@RequestParam(defaultValue = "1") int basicId){
        return basicSettingService.selectByBasicId(basicId);
    }

    @PostMapping("update")
    @ApiOperation("基础设置数据修改")
    @ApiImplicitParam(name = "basicSetting",value = "请求对象")
    public RespResult<String> updateBasicSetting(@RequestBody BasicSetting basicSetting){
        return basicSettingService.updateBasicSetting(basicSetting);
    }

}
