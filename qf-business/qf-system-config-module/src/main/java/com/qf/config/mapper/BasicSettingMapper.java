package com.qf.config.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.config.entity.BasicSetting;

public interface BasicSettingMapper extends BaseMapper<BasicSetting> {
    default BasicSetting selectByBasicId(int basicId){
        LambdaQueryWrapper<BasicSetting> lqw = new LambdaQueryWrapper<>();
        lqw.eq(BasicSetting::getBasicId, basicId);
        return this.selectOne(lqw);
    }

    default int updateBasicSetting(BasicSetting basicSetting){
        LambdaUpdateWrapper<BasicSetting> luw = new LambdaUpdateWrapper<>();
        luw.eq(BasicSetting::getBasicId,basicSetting.getBasicId());
        return this.update(basicSetting,luw);
    }
}