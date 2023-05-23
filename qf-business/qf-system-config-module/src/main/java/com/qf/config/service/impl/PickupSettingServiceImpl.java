package com.qf.config.service.impl;

import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.config.entity.PickupSetting;
import com.qf.config.mapper.PickupSettingMapper;
import com.qf.config.service.PickupSettingService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class PickupSettingServiceImpl implements PickupSettingService {
    @Resource
    private PickupSettingMapper pickupSettingMapper;

    @Override
    public RespResult<PickupSetting> selectByPickupId(int pickupId) {
        PickupSetting pickupSetting = pickupSettingMapper.selectByPickupId(pickupId);
        if (!ObjectUtils.isEmpty(pickupSetting)) {
            return RespResult.success(pickupSetting);
        } else {
            throw new ServiceException(ResultCode.RESPONSE_NULL);
        }

    }

    @Override
    public RespResult<String> updatePickupSetting(PickupSetting pickupSetting) {
        if (!ObjectUtils.isEmpty(pickupSetting)) {
            int i = pickupSettingMapper.updatePickupSetting(pickupSetting);
            if (i > 0) {
                return RespResult.success("修改成功");
            } else {
                return RespResult.error("修改失败");
            }
        } else {
            throw new ServiceException(ResultCode.PARAMETER_MISSING);
        }
    }
}
