package com.qf.advertisement.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.qf.advertisement.qo.AppAdvertisingQo;
import com.qf.advertisement.server.AppAdvertisingServer;
import com.qf.advertisement.vo.AppAdvertisingVo;
import com.qf.common.base.result.RespResult;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("appAdvertising")
public class AppAdvertisingController {

    @Resource
    AppAdvertisingServer appAdvertisingServer;
    /**
     * 添加 广告信息
     * @param appAdvertisingQo
     * @return
     */
    @PostMapping("add")
    public RespResult<Object>  insert(@ModelAttribute AppAdvertisingQo appAdvertisingQo){
        return RespResult.success(appAdvertisingServer.addAppAdvertising(appAdvertisingQo));
    }
    /**
     * 查询  广告信息
     * @param page
     * @param size
     * @param appAdvertisingQo
     * @return
     */
    @GetMapping("list")
    public RespResult<IPage<AppAdvertisingVo>>  list(@RequestParam(defaultValue = "1") Integer page,
                                                     @RequestParam(defaultValue = "10") Integer size,
                                                     @ModelAttribute AppAdvertisingQo appAdvertisingQo){
        return  RespResult.success(appAdvertisingServer.queryList(page,size,appAdvertisingQo));
    }

    @PostMapping("update")
    public  RespResult<Object> mod(@ModelAttribute AppAdvertisingQo appAdvertisingQo){
        return appAdvertisingServer.updateAppAdvertising(appAdvertisingQo)>0?RespResult.success("修改成功"):RespResult.success("修改失败");
    }

}
