package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.BasicSetting;
import com.qf.config.service.BasicSettingService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("BasicSetting")
public class BasicSettingController {
    @Resource
    private BasicSettingService basicSettingService;

    @GetMapping("select")
    public RespResult<BasicSetting> selectByBasicId(@RequestParam int basicId){
        return basicSettingService.selectByBasicId(basicId);
    }

    @PostMapping("update")
    public RespResult<String> updateBasicSetting(@RequestBody BasicSetting basicSetting){
        return basicSettingService.updateBasicSetting(basicSetting);
    }

}
