package com.qf.cabinet.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.cabinet.entity.ExpressBox;
import org.springframework.util.ObjectUtils;

public interface ExpressBoxMapper extends BaseMapper<ExpressBox> {

    /**
     * 统计使用中的个数
     */
    default Long count(int cabinetId,int status){
        LambdaQueryWrapper<ExpressBox> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExpressBox::getCabinetId,cabinetId).eq(ExpressBox::getUsageStatus,status);
        return this.selectCount(queryWrapper);
    }

    /**
     * 每个柜机的箱格数
     */
    default Long countByCid(int cabinetId){
        LambdaQueryWrapper<ExpressBox> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExpressBox::getCabinetId,cabinetId);
        return this.selectCount(queryWrapper);
    }
    /**
     * 根据柜机ID查询
     */
    default IPage<ExpressBox> selectById(int page,int size,ExpressBox expressBox){
        LambdaQueryWrapper<ExpressBox> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ExpressBox::getCabinetId,expressBox.getCabinetId());
        if (!ObjectUtils.isEmpty(expressBox.getBoxType())){
            queryWrapper.eq(ExpressBox::getBoxType,expressBox.getBoxType());
        }
        if (!ObjectUtils.isEmpty(expressBox.getDoorStatus())){
            queryWrapper.eq(ExpressBox::getDoorStatus,expressBox.getDoorStatus());
        }
        if (!ObjectUtils.isEmpty(expressBox.getStorageType())){
            queryWrapper.eq(ExpressBox::getStorageType,expressBox.getStorageType());
        }
        if (!ObjectUtils.isEmpty(expressBox.getUsageStatus())){
            queryWrapper.eq(ExpressBox::getUsageStatus,expressBox.getUsageStatus());
        }
        return this.selectPage(new Page<>(page,size),queryWrapper);

    }



}