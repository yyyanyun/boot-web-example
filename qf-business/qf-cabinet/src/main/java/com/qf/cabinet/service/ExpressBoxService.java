package com.qf.cabinet.service;

import com.github.pagehelper.PageInfo;
import com.qf.cabinet.qo.ExpressBoxQo;
import com.qf.cabinet.vo.ExpressBoxVo;

public interface ExpressBoxService {
    PageInfo<ExpressBoxVo> listBy(int page, int size, ExpressBoxQo expressBoxQo);

    PageInfo<ExpressBoxVo> listByLog(int page, int size, int boxId);

    Integer alter(ExpressBoxQo expressBoxQo);


}
