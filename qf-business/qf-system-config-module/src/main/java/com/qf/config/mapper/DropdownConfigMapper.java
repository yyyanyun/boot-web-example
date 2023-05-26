package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.common.vo.DropdownConfigVO;
import com.qf.config.entity.DropdownConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DropdownConfigMapper extends BaseMapper<DropdownConfig> {
    default int insertKey(DropdownConfig dropdownConfig) {
        return insert(dropdownConfig);
    }

    default int updateKey(DropdownConfig dropdownConfig) {
        return updateById(dropdownConfig);
    }

    default int updateKeyStatus(Integer dropdownId,Integer status) {
        DropdownConfig dropdownConfig = new DropdownConfig();
        LambdaUpdateWrapper<DropdownConfig> luw = new LambdaUpdateWrapper<>();
        luw.set(DropdownConfig::getStatus,status)
                .eq(DropdownConfig::getDropdownId,dropdownId);
        return this.update(dropdownConfig, luw);
    }

    List<DropdownConfigVO> selectList(@Param("kw") String kw);


    
}