package com.qf.cabinet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.result.RespResult;
import org.springframework.web.bind.annotation.RequestParam;

public interface ExpressBoxService {
    RespResult<IPage<ExpressBoxVo>> list( int page, int size, int cabinetId);
}
