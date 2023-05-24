package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.entity.PickupSetting;

public interface PickupSettingMapper extends BaseMapper<PickupSetting> {
    default PickupSetting selectByPickupId(int pickupId){
        return selectById(pickupId);
    }
    default int updatePickupSetting(PickupSetting pickupSetting){
        return updateById(pickupSetting);
    }
}