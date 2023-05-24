package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.entity.CabinetChargeSetting;
import org.apache.ibatis.annotations.Param;

public interface CabinetChargeSettingMapper extends BaseMapper<CabinetChargeSetting> {
    CabinetChargeSetting selectByCabinetId(@Param("cabinetId") int cabinetId);

    int updateCabinetChargeSetting(@Param("cabinetChargeSetting") CabinetChargeSetting cabinetChargeSetting);
}