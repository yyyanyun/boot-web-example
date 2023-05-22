package com.qf.advertisement.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.advertisement.entity.Advertising;
import com.qf.advertisement.entity.Video;
import com.qf.advertisement.qo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;
import com.qf.common.base.utils.CommonBeanUtils;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CopyPropertiesUtils extends CommonBeanUtils {

    /**
     * 自定义 工具类
     *                  PO->VO
     * 将  IPage <Advertising>  类型 数据       转换为    提供给其前端的 类型   IPage<AdvertisingVo>   数据       中间需要  多表查询
     * @param source    查询出的 源数据
     * @param target    需要转换成的类型
     * @param server     转换需要的  mapper
     * @param supplier
     * @return
     */
    public static  IPage<AdvertisingVo>   copyPageToAdvertisingVo(IPage <Advertising> source, IPage<AdvertisingVo> target, BaseMapper<Video> server, Supplier<AdvertisingVo> supplier) {
        //源数据 的 记录
        List<Advertising> records = source.getRecords();
        //需要转换成的类型
        IPage<AdvertisingVo> voIPage = new Page<>();

        // 对记录 进行 流转换     并在 其过程中  查询 子表  并 进行 转换
        List<AdvertisingVo> collect = records.stream().map(a -> {
            Video video = server.selectById(a.getVideoId());
            AdvertisingVo vo = supplier.get();
            BeanUtils.copyProperties(a, vo);
            BeanUtils.copyProperties(video, vo);
            return vo;
        }).collect(Collectors.toList());
        System.out.println(collect);

        //复制  源数据 其他 数据
        BeanUtils.copyProperties(source,voIPage);
        return voIPage.setRecords(collect);
    }


    public static  Advertising  copyLocalDateTime(AdvertisingQo advertisingQo, Advertising advertising){
        // 将 其他属性 赋值
        copyProperties(advertisingQo,advertising);
        //将 LocalDateTime 属性赋值
        advertising.setPushTime(advertisingQo.getPushTime());
        advertising.setExpiryTime(advertisingQo.getExpiryTime());
        advertising.setCreateTime(advertisingQo.getCreateTime());
        return advertising;
    }

    public static  AdvertisingVo  copyLocalDateTime( Advertising advertising,AdvertisingVo advertisingVo){
        // 将 其他属性 赋值
        copyProperties(advertising,advertisingVo);
        //将 LocalDateTime 属性赋值
        advertisingVo.setCreateTime(advertising.getCreateTime());
        advertisingVo.setExpiryTime(advertising.getExpiryTime());
        advertisingVo.setPushTime(advertising.getPushTime());
        return  advertisingVo;
    }



    public static <E,T> IPage<E>  copyIPage( IPage<T> source, IPage<E> target,Supplier<E> supplier){


        copyProperties(source,target);
        target.setRecords(source.getRecords().stream().map(a->{
            E e = supplier.get();
            copyProperties(a,e);
            return e;
        }).collect(Collectors.toList()));


        return  target;
    }

}
