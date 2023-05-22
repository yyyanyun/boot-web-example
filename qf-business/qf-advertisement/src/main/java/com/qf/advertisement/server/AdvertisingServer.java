package com.qf.advertisement.server;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.advertisement.vo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;
import com.qf.common.base.result.RespResult;

public interface AdvertisingServer {

    IPage<AdvertisingVo>  queryList(int page, int size,AdvertisingQo advertisingQo);

    int  addAdvertising(AdvertisingQo advertisingQo);

    AdvertisingVo queryAdvertising(Long AdvertisingId);

    RespResult<Object> update(AdvertisingQo advertisingQo);
}
