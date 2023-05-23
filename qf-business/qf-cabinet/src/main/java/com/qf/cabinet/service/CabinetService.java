package com.qf.cabinet.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.vo.CabinetVo;
import com.qf.cabinet.vo.ExpressBoxVo;
import com.qf.common.base.result.RespResult;
import io.swagger.models.auth.In;

import java.util.List;

public interface CabinetService {
    RespResult<PageInfo<CabinetVo>> listSimple(int page, int size, CabinetEasyQo cabinetEasyQo, String param);

    RespResult<PageInfo<CabinetVo>> list(int page, int size, CabinetHighQo cabinetHighQo);

    RespResult<Integer> add(CabinetQo cabinetQo);

    RespResult<Integer> listAdd(List<CabinetQo> cabinetQoList);

    RespResult<CabinetVo> listOne(int cabinetId);

    RespResult<Integer> alter(int cabinetId,int type);

    RespResult<CabinetVo> showBox(int cabinetId);

    RespResult<CabinetVo> goAlter(int cabinetId, int boxId);

}
