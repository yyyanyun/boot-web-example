package com.qf.advertisement.server.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.advertisement.entity.Advertising;

import com.qf.advertisement.mapper.AdvertisingMapper;
import com.qf.advertisement.mapper.VideoMapper;
import com.qf.advertisement.server.AdvertisingServer;
import com.qf.advertisement.utils.CopyPropertiesUtils;
import com.qf.advertisement.vo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class AdvertisingServerImpl  implements AdvertisingServer {

    @Resource
    AdvertisingMapper advertisingMapper;

    @Resource
    VideoMapper videoMapper;

    @Override
    public IPage<AdvertisingVo> queryList(int page,int size,AdvertisingQo advertisingQo) {

        Advertising advertising = new Advertising();
        //注意： BeanUtils.copyProperties() 不能将 LocalDateTime 类型的属性 赋值给 目标对象
        // 如果想  赋值 调用  可以定义 自己 定义工具类
        CopyPropertiesUtils.copyLocalDateTime(advertisingQo,advertising);


        LambdaQueryWrapper<Advertising> queryWrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(advertisingQo.getAdvertisingTitle())){
            queryWrapper.like(Advertising::getAdvertisingTitle,advertising.getAdvertisingTitle());
        }

        if (!ObjectUtils.isEmpty(advertisingQo.getCreateTime()) && !ObjectUtils.isEmpty(advertisingQo.getExpiryTime())){
            queryWrapper.between(Advertising::getCreateTime,advertising.getCreateTime(),advertising.getExpiryTime());
        }

        if (!ObjectUtils.isEmpty(advertisingQo.getExpiryTime())){
            queryWrapper.le(Advertising::getExpiryTime,advertising.getExpiryTime());
        }

        //查询 出
        Page<Advertising> aPage = advertisingMapper.selectPage(new Page<>(page,size), queryWrapper);

        return CopyPropertiesUtils.copyPageToAdvertisingVo(aPage,new Page<AdvertisingVo>(),videoMapper,AdvertisingVo::new);
    }

    @Override
    public int addAdvertising(AdvertisingQo advertisingQo) {
        //1. 上传 文件
        //2. 将 QO-->PO  插入数据
        //3. 返回值
        return 0;
    }


}
