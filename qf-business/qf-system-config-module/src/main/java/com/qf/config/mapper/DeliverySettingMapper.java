package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.entity.DeliverySetting;

public interface DeliverySettingMapper extends BaseMapper<DeliverySetting> {
    default DeliverySetting selectByDeliveryId(int deliveryId){
        LambdaQueryWrapper<DeliverySetting> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DeliverySetting::getDeliveryId,deliveryId);
        return this.selectOne(lqw);
    }
    default int updateDeliverySetting(DeliverySetting deliverySetting){
        return updateById(deliverySetting);
    }
}