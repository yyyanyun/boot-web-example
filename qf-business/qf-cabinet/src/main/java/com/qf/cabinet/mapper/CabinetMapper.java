package com.qf.cabinet.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.cabinet.entity.Cabinet;
import com.qf.common.base.exception.DaoException;
import org.springframework.util.ObjectUtils;

public interface CabinetMapper extends BaseMapper<Cabinet> {
    /**
     * 简单条件查询
     */
    default IPage<Cabinet> selectBy(int page, int size, Cabinet cabinet, String param) throws DaoException {
        LambdaQueryWrapper<Cabinet> queryWrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(cabinet.getCabinetStatus())) {
            queryWrapper.eq(Cabinet::getCabinetStatus, cabinet.getCabinetStatus());
        }
        if (!ObjectUtils.isEmpty(cabinet.getBoxBoorStatus())) {
            queryWrapper.eq(Cabinet::getBoxBoorStatus, cabinet.getBoxBoorStatus());
        }
        if (!ObjectUtils.isEmpty(param)) {
            queryWrapper.and(w -> w.like(Cabinet::getAddress, param)
                    .or()
                    .like(Cabinet::getCabinetCode, param)
                    .or()
                    .like(Cabinet::getSysVersion, param)
                    .or()
                    .like(Cabinet::getStorageType, param)
                    .or()
                    .like(Cabinet::getCabinetId, param));
        }
        return this.selectPage(new Page<>(page, size), queryWrapper);
    }

    /**
     * 高级条件查询
     */
    default IPage<Cabinet> selectBy(int page, int size, Cabinet cabinet) throws DaoException {
        LambdaQueryWrapper<Cabinet> queryWrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(cabinet.getCabinetId())) {
            queryWrapper.eq(Cabinet::getCabinetId, cabinet.getCabinetId());
        }
        if (!ObjectUtils.isEmpty(cabinet.getCabinetCode())) {
            queryWrapper.eq(Cabinet::getCabinetCode, cabinet.getCabinetCode());
        }
        if (!ObjectUtils.isEmpty(cabinet.getDeviceModel())) {
            queryWrapper.eq(Cabinet::getDeviceModel, cabinet.getDeviceModel());
        }
        if (!ObjectUtils.isEmpty(cabinet.getVersion())) {
            queryWrapper.eq(Cabinet::getVersion, cabinet.getVersion());
        }
        if (!ObjectUtils.isEmpty(cabinet.getRegion())) {
            queryWrapper.eq(Cabinet::getRegion, cabinet.getRegion());
        }
        if (!ObjectUtils.isEmpty(cabinet.getAddress())) {
            queryWrapper.eq(Cabinet::getAddress, cabinet.getAddress());
        }
        if (!ObjectUtils.isEmpty(cabinet.getCreateData())) {
            queryWrapper.eq(Cabinet::getCreateData, cabinet.getCreateData());
        }
        if (!ObjectUtils.isEmpty(cabinet.getActivationData())) {
            queryWrapper.eq(Cabinet::getActivationData, cabinet.getActivationData());
        }
        if (!ObjectUtils.isEmpty(cabinet.getCabinetStatus())) {
            queryWrapper.eq(Cabinet::getCabinetStatus, cabinet.getCabinetStatus());
        }
        if (!ObjectUtils.isEmpty(cabinet.getStorageType())) {
            queryWrapper.eq(Cabinet::getStorageType, cabinet.getStorageType());
        }
        if (!ObjectUtils.isEmpty(cabinet.getBoxBoorStatus())) {
            queryWrapper.eq(Cabinet::getBoxBoorStatus, cabinet.getBoxBoorStatus());
        }
        if (!ObjectUtils.isEmpty(cabinet.getBoxStarter())) {
            queryWrapper.eq(Cabinet::getBoxStarter, cabinet.getBoxStarter());
        }
        return this.selectPage(new Page<>(page, size), queryWrapper);
    }

}