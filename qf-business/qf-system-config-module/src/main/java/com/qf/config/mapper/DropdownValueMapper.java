package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.entity.DropdownConfig;
import com.qf.config.entity.DropdownValue;

public interface DropdownValueMapper extends BaseMapper<DropdownValue> {
    default int insertKey(DropdownValue dropdownValue) {
        return insert(dropdownValue);
    }

    default int updateKey(DropdownValue dropdownValue) {
        return updateById(dropdownValue);
    }

    default int updateKeyStatus(Integer sortId,Integer status) {
        DropdownValue dropdownValue = new DropdownValue();
        LambdaUpdateWrapper<DropdownValue> luw = new LambdaUpdateWrapper<>();
        luw.set(DropdownValue::getStatus,status)
                .eq(DropdownValue::getSortId,sortId);
        return this.update(dropdownValue, luw);
    }
}