package com.qf.advertisement.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.advertisement.server.AdvertisingServer;
import com.qf.advertisement.vo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;
import com.qf.common.base.result.RespResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Resource
@RestController
public class AdvertisingController {

    @Resource
    AdvertisingServer  advertisingServer;

    @GetMapping("list")
    public RespResult<IPage<AdvertisingVo>>  list(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "20") Integer size, @RequestParam AdvertisingQo advertisingQo){
        return  RespResult.success(advertisingServer.queryList(page,size,advertisingQo));
    }

    @PostMapping("insert")
    public String  insertAdvertising(@RequestParam AdvertisingVo advertisingVo) {
        return null;
    }
}
