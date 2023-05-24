package com.qf.config.service;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.CabinetChargeSetting;

public interface CabinetChargeSettingService {
    RespResult<CabinetChargeSetting> selectByCabinetId(int cabinetId);

    RespResult<String> updateCabinetChargeSetting(CabinetChargeSetting cabinetChargeSetting);
}
