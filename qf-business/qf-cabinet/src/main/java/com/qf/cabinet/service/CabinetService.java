package com.qf.cabinet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.vo.CabinetVo;

public interface CabinetService {
    IPage<CabinetVo> listSimple(int page, int size, CabinetQo cabinetQo, String param);

    IPage<CabinetVo> list(int page, int size, CabinetQo cabinetQo);
}
