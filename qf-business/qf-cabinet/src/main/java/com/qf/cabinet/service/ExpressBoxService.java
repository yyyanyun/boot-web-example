package com.qf.cabinet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.result.RespResult;

public interface ExpressBoxService {
    RespResult<IPage<ExpressBoxVo>> listBy(int page, int size,ExpressBoxQo expressBoxQo);

}
