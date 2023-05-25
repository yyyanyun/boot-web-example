package com.qf.config.service.impl;

import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.config.entity.DropdownConfig;
import com.qf.config.mapper.DropdownConfigMapper;
import com.qf.config.service.DropdownConfigService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
@Service
public class DropdownConfigServiceImpl implements DropdownConfigService {
    @Resource
    private DropdownConfigMapper dropdownConfigMapper;

    @Override
    public RespResult<String> insertKey(DropdownConfig dropdownConfig) {
        if (!ObjectUtils.isEmpty(dropdownConfig)) {
            int i = dropdownConfigMapper.insertKey(dropdownConfig);
            if (i > 0) {
                return RespResult.success("增加成功");
            } else {
                return RespResult.error("增加失败");
            }
        } else {
            throw new ServiceException(ResultCode.PARAMETER_MISSING);
        }
    }

    @Override
    public RespResult<String> updateKey(DropdownConfig dropdownConfig) {
        if (!ObjectUtils.isEmpty(dropdownConfig)){
            int i = dropdownConfigMapper.updateKey(dropdownConfig);
            if (i > 0) {
                return RespResult.success("修改成功");
            } else {
                return RespResult.error("修改失败");
            }
        } else {
            throw new ServiceException(ResultCode.PARAMETER_MISSING);
        }
    }

    @Override
    public RespResult<String> updateKeyStatus(Integer dropdownId, Integer status) {
        if (!ObjectUtils.isEmpty(dropdownId) && !ObjectUtils.isEmpty(status)) {
            int i = dropdownConfigMapper.updateKeyStatus(dropdownId, status);
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
