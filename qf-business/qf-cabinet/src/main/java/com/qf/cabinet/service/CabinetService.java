package com.qf.cabinet.service;

import com.github.pagehelper.PageInfo;
import com.qf.cabinet.qo.CabinetEasyQo;
import com.qf.cabinet.qo.CabinetHighQo;
import com.qf.cabinet.qo.CabinetQo;
import com.qf.cabinet.vo.CabinetVo;

import java.util.List;

public interface CabinetService {
    PageInfo<CabinetVo> listSimple(int page, int size, CabinetEasyQo cabinetEasyQo, String param);

    PageInfo<CabinetVo> list(int page, int size, CabinetHighQo cabinetHighQo);

    Integer add(CabinetQo cabinetQo);

    Integer listAdd(List<CabinetQo> cabinetQoList);

    CabinetVo listOne(int cabinetId);

    Integer alter(int cabinetId,int type);

    CabinetVo showBox(int cabinetId);

    CabinetVo goAlter(int cabinetId, int boxId);

}
