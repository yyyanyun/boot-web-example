package com.qf.advertisement.server.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.advertisement.entity.AppAdvertising;
import com.qf.advertisement.mapper.AppAdvertisingMapper;
import com.qf.advertisement.qo.AppAdvertisingQo;
import com.qf.advertisement.server.AppAdvertisingServer;
import com.qf.advertisement.utils.CopyPropertiesUtils;
import com.qf.advertisement.utils.FileUpdateUtils;
import com.qf.advertisement.vo.AppAdvertisingVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

@Service
public class AppAdvertisingServerImpl implements AppAdvertisingServer {

    @Resource
    AppAdvertisingMapper appAdvertisingMapper;

    @Resource
    FileUpdateUtils fileUpdateUtils;
    @Override
    public IPage<AppAdvertisingVo> queryList(int page, int size, AppAdvertisingQo appAdvertisingQo) {
        AppAdvertising appAdvertising = new AppAdvertising();
        BeanUtils.copyProperties(appAdvertisingQo,appAdvertising);
        // 判断
        LambdaQueryWrapper<AppAdvertising> wrapper  = appAdvertisingMapper.QueryWrapper(appAdvertising);
        //执行查询 Page 语句
        Page<AppAdvertising> appAdvertisingPage = appAdvertisingMapper.selectPage(new Page<>(page, size), wrapper);
        return   CopyPropertiesUtils.copyIPage(appAdvertisingPage, new Page<>(),AppAdvertisingVo::new);

    }

    @Override
    public Integer addAppAdvertising(AppAdvertisingQo appAdvertisingQo) {
        AppAdvertising appAdvertising = new AppAdvertising();
        //文件上传
        String enUrl = fileUpdateUtils.load(appAdvertisingQo.getEnFile());
        String chUrl = fileUpdateUtils.load(appAdvertisingQo.getCnFile());
        //设置url 地址
        appAdvertising.setEnImage(enUrl);
        appAdvertising.setCnImage(chUrl);
        //转换
        CopyPropertiesUtils.copyProperties(appAdvertisingQo,appAdvertising);
        return appAdvertisingMapper.insert(appAdvertising);
    }

    @Override
    public int updateAppAdvertising(AppAdvertisingQo appAdvertisingQo) {
        AppAdvertising appAdvertising = new AppAdvertising();
        BeanUtils.copyProperties(appAdvertisingQo,appAdvertising);

        LambdaQueryWrapper<AppAdvertising> wrapper = appAdvertisingMapper.QueryWrapper(appAdvertising);

        return appAdvertisingMapper.update(appAdvertising, wrapper);
    }
}
