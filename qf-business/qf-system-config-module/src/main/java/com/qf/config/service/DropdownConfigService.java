package com.qf.config.service;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DropdownConfig;

public interface DropdownConfigService {
    RespResult<String> insertKey(DropdownConfig dropdownConfig);
    RespResult<String> updateKey(DropdownConfig dropdownConfig);
    RespResult<String> updateKeyStatus(Integer dropdownId,Integer status);
}
