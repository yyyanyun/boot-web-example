package com.qf.config.service;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DropdownConfig;
import com.qf.config.entity.DropdownValue;

public interface DropdownValueService {
    RespResult<String> insertValue(DropdownValue dropdownValue);
    RespResult<String> updateValue(DropdownValue dropdownValue);
    RespResult<String> updateValueStatus(Integer sortId,Integer status);
}
