package com.qf.config.service;

import com.qf.common.base.result.RespResult;
import com.qf.config.entity.DeliverySetting;

public interface DeliverySettingService {
    RespResult<DeliverySetting> selectByDeliveryId(int deliveryId);

    RespResult<String> updateDeliverySetting(DeliverySetting deliverySetting);
}
