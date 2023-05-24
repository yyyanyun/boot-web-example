package com.qf.cabinet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.vo.CabinetVo;
import com.qf.common.base.result.RespResult;
import io.swagger.models.auth.In;

import java.util.List;

public interface CabinetService {
    IPage<CabinetVo> listSimple(int page, int size, CabinetEasyQo cabinetEasyQo, String param);

    IPage<CabinetVo> list(int page, int size, CabinetHighQo cabinetHighQo);

    RespResult<Integer> add(CabinetQo cabinetQo);

    RespResult<Integer> listAdd(List<CabinetQo> cabinetQoList);

    RespResult<CabinetVo> listOne(int cabinetId);

    RespResult<Integer> alter(int cabinetId,int type);
}
