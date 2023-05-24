package com.qf.config.service;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.PickupSetting;

public interface PickupSettingService {
    RespResult<PickupSetting> selectByPickupId(int pickupId);

    RespResult<String> updatePickupSetting(PickupSetting pickupSetting);
}
