package com.qf.config.controller;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.BasicSetting;
import com.qf.config.service.BasicSettingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

}
