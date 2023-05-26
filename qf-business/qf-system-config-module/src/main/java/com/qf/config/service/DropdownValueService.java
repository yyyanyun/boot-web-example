package com.qf.config.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DropdownConfig;
import com.qf.config.entity.DropdownValue;

public interface DropdownValueService {
    RespResult<String> insertValue(DropdownValue dropdownValue);
    RespResult<String> updateValue(DropdownValue dropdownValue);
    RespResult<String> updateValueStatus(Integer sortId,Integer status);

    IPage<DropdownValue> search(int page ,int size,String kw);
}
