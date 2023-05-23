package com.qf.config.service.impl;

import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.config.entity.DeliverySetting;
import com.qf.config.mapper.DeliverySettingMapper;
import com.qf.config.service.DeliverySettingService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class DeliverySettingServiceImpl implements DeliverySettingService {
    @Resource
    private DeliverySettingMapper deliverySettingMapper;

    @Override
    public RespResult<DeliverySetting> selectByDeliveryId(int deliveryId) {
        DeliverySetting deliverySetting = deliverySettingMapper.selectByDeliveryId(deliveryId);
        if (!ObjectUtils.isEmpty(deliverySetting)) {
            return RespResult.success(deliverySetting);
        } else {
            throw new ServiceException(ResultCode.RESPONSE_NULL);
        }
    }

    @Override
    public RespResult<String> updateDeliverySetting(DeliverySetting deliverySetting) {
        if (!ObjectUtils.isEmpty(deliverySetting)){
            int i = deliverySettingMapper.updateDeliverySetting(deliverySetting);
            if(i>0){
                return RespResult.success("修改成功");
            }else {
                return RespResult.error("修改失败");
            }
        }else {
            throw new ServiceException(ResultCode.PARAMETER_MISSING);
        }
    }
}
