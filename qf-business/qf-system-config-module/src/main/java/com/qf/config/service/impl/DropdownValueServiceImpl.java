package com.qf.config.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.qf.common.base.exception.ServiceException;
import com.qf.common.base.result.RespResult;
import com.qf.common.base.result.ResultCode;
import com.qf.config.entity.DropdownValue;
import com.qf.config.mapper.DropdownValueMapper;
import com.qf.config.service.DropdownValueService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class DropdownValueServiceImpl implements DropdownValueService {
    @Resource
    private DropdownValueMapper dropdownValueMapper;

    @Override
    public RespResult<String> insertValue(DropdownValue dropdownValue) {
        if (!ObjectUtils.isEmpty(dropdownValue)) {
            int i = dropdownValueMapper.insertValue(dropdownValue);
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
    public RespResult<String> updateValue(DropdownValue dropdownValue) {
        if (!ObjectUtils.isEmpty(dropdownValue)){
            int i = dropdownValueMapper.updateValue(dropdownValue);
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
    public RespResult<String> updateValueStatus(Integer sortId, Integer status) {
        if (!ObjectUtils.isEmpty(sortId) && !ObjectUtils.isEmpty(status)) {
            int i = dropdownValueMapper.updateValueStatus(sortId,status);
            if(i>0){
                return RespResult.success("修改成功");
            }else {
                return RespResult.error("修改失败");
            }
        }else {
            throw new ServiceException(ResultCode.PARAMETER_MISSING);
        }
    }



    @Override
    public IPage<DropdownValue> search(int page, int size, String kw) {
       return dropdownValueMapper.selectPage(new Page<>(page,size),kw == null ? null :dropdownValueMapper.searchValue(kw));
    }


}
