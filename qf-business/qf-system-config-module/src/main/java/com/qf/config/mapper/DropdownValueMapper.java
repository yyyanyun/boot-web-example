package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.entity.DropdownValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DropdownValueMapper extends BaseMapper<DropdownValue> {
    default int insertValue(DropdownValue dropdownValue) {
        return insert(dropdownValue);
    }

    default int updateValue(DropdownValue dropdownValue) {
        return updateById(dropdownValue);
    }

    default int updateValueStatus(Integer sortId,Integer status) {
        DropdownValue dropdownValue = new DropdownValue();
        LambdaUpdateWrapper<DropdownValue> luw = new LambdaUpdateWrapper<>();
        luw.set(DropdownValue::getStatus,status)
                .eq(DropdownValue::getSortId,sortId);
        return this.update(dropdownValue, luw);
    }

    default QueryWrapper<DropdownValue> searchValue(String kw){
        QueryWrapper<DropdownValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(DropdownValue.COL_VALUE_CN,kw);
        return queryWrapper;
    }

    DropdownValue searchValues(@Param("dropdownId") String dropdownId);

}