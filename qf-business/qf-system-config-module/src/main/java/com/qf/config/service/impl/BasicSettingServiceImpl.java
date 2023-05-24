package com.qf.config.service.impl;

import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.config.entity.BasicSetting;
import com.qf.config.mapper.BasicSettingMapper;
import com.qf.config.service.BasicSettingService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
@Service
public class BasicSettingServiceImpl implements BasicSettingService {
    @Resource
    private BasicSettingMapper basicSettingMapper;

    @Override
    public RespResult<BasicSetting> selectByBasicId(int basicId) {
        BasicSetting basicSetting = basicSettingMapper.selectByBasicId(basicId);
        if (!ObjectUtils.isEmpty(basicSetting)){
           return RespResult.success(basicSetting);
        }else {
            throw new ServiceException(ResultCode.RESPONSE_NULL);
        }
    }

    @Override
    public RespResult<String> updateBasicSetting(BasicSetting basicSetting) {
        if (!ObjectUtils.isEmpty(basicSetting)){
            int i = basicSettingMapper.updateBasicSetting(basicSetting);
            if (i>0){
                return RespResult.success("修改成功");
            }else {
                return RespResult.error("修改失败");
            }
        }else {
            throw new ServiceException(ResultCode.PARAMETER_MISSING);
        }

    }

}
