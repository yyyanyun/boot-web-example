package com.qf.advertisement.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.advertisement.qo.AdvertisingQo;
import com.qf.advertisement.qo.AppAdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;
import com.qf.advertisement.vo.AppAdvertisingVo;

public interface AppAdvertisingServer {
    IPage<AppAdvertisingVo> queryList(int page, int size, AppAdvertisingQo appAdvertisingQo);


    Integer  addAppAdvertising(AppAdvertisingQo appAdvertisingQo);

     int updateAppAdvertising(AppAdvertisingQo appAdvertisingQo);

}
