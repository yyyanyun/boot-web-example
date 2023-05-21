package com.qf.advertisement.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.advertisement.entity.Advertising;
import com.qf.advertisement.vo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;

public interface AdvertisingServer {

    IPage<AdvertisingVo>  queryList(int page, int size,AdvertisingQo advertisingQo);

    int  addAdvertising(AdvertisingQo advertisingQo);
}
