package com.qf.cabinet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.vo.CabinetVo;

public interface CabinetService {
    IPage<CabinetVo> listSimple(int page, int size, CabinetEasyQo cabinetEasyQo, String param);

    IPage<CabinetVo> list(int page, int size, CabinetHighQo cabinetHighQo);

    int add(CabinetQo cabinetQo);
}
