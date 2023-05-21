package com.qf.advertisement.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.advertisement.entity.Advertising;
import com.qf.advertisement.entity.Video;
import com.qf.advertisement.vo.AdvertisingVo;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CopyPropertiesUtils {

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
}
