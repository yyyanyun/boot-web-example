package com.qf.cabinet.service;

import com.github.pagehelper.PageInfo;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.result.RespResult;

public interface ExpressBoxService {
    RespResult<PageInfo<ExpressBoxVo>> listBy(int page, int size, ExpressBoxQo expressBoxQo);

    RespResult<PageInfo<ExpressBoxVo>> listByLog(int page, int size, int boxId);

    RespResult<Integer> alter(ExpressBoxQo expressBoxQo);


}
