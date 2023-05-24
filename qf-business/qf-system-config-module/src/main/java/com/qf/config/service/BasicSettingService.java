package com.qf.config.service;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.BasicSetting;

public interface BasicSettingService {
    RespResult<BasicSetting> selectByBasicId(int basicId);
    RespResult<String> updateBasicSetting(BasicSetting basicSetting);
}
