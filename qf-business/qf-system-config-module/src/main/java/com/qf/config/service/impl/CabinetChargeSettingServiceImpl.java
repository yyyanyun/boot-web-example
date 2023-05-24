package com.qf.config.service.impl;

import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.config.entity.CabinetChargeSetting;
import com.qf.config.mapper.CabinetChargeSettingMapper;
import com.qf.config.service.CabinetChargeSettingService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class CabinetChargeSettingServiceImpl implements CabinetChargeSettingService {
    @Resource
    private CabinetChargeSettingMapper cabinetChargeSettingMapper;

    @Override
    public RespResult<CabinetChargeSetting> selectByCabinetId(int cabinetId) {
        CabinetChargeSetting cabinetChargeSetting = cabinetChargeSettingMapper.selectByCabinetId(cabinetId);
        if (!ObjectUtils.isEmpty(cabinetChargeSetting)) {
            return RespResult.success(cabinetChargeSetting);
        } else {
            throw new ServiceException(ResultCode.RESPONSE_NULL);
        }
    }

    @Override
    public RespResult<String> updateCabinetChargeSetting(CabinetChargeSetting cabinetChargeSetting) {
        if (!ObjectUtils.isEmpty(cabinetChargeSetting)) {
            int i = cabinetChargeSettingMapper.updateCabinetChargeSetting(cabinetChargeSetting);
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
