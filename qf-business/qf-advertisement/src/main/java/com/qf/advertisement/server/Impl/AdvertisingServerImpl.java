package com.qf.advertisement.server.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qf.advertisement.entity.Advertising;
import com.qf.advertisement.entity.Video;
import com.qf.advertisement.mapper.AdvertisingMapper;
import com.qf.advertisement.mapper.VideoMapper;
import com.qf.advertisement.server.AdvertisingServer;
import com.qf.advertisement.utils.CopyPropertiesUtils;
import com.qf.advertisement.utils.FileUpdateUtils;
import com.qf.advertisement.vo.AdvertisingQo;
import com.qf.advertisement.vo.AdvertisingVo;
import com.qf.common.base.result.RespResult;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class AdvertisingServerImpl implements AdvertisingServer {

    @Resource
    AdvertisingMapper advertisingMapper;

    @Resource
    FileUpdateUtils fileUpdateUtils;

    @Resource
    VideoMapper videoMapper;

    @Override
    public IPage<AdvertisingVo> queryList(int page, int size, AdvertisingQo advertisingQo) {

        Advertising advertising = new Advertising();
        //注意： BeanUtils.copyProperties() 不能将 LocalDateTime 类型的属性 赋值给 目标对象
        // 如果想  赋值 调用  可以定义 自己 定义工具类
        CopyPropertiesUtils.copyLocalDateTime(advertisingQo, advertising);

        //多条件查询判断
        LambdaQueryWrapper<Advertising> queryWrapper = new LambdaQueryWrapper<>();
        if (!ObjectUtils.isEmpty(advertising.getAdvertisingTitle())) {
            queryWrapper.like(Advertising::getAdvertisingTitle, advertising.getAdvertisingTitle());
        }

        if (!ObjectUtils.isEmpty(advertising.getCreateTime()) && !ObjectUtils.isEmpty(advertising.getExpiryTime())) {
            queryWrapper.between(Advertising::getCreateTime, advertising.getCreateTime(), advertising.getExpiryTime());
        }

        if (!ObjectUtils.isEmpty(advertising.getExpiryTime())) {
            queryWrapper.le(Advertising::getExpiryTime, advertising.getExpiryTime());
        }

        if (!ObjectUtils.isEmpty(advertising.getStatus())){
            queryWrapper.eq(Advertising::getStatus,advertising.getStatus());
        }

        //查询 出
        Page<Advertising> aPage = advertisingMapper.selectPage(new Page<>(page, size), queryWrapper);
        return CopyPropertiesUtils.copyPageToAdvertisingVo(aPage, new Page<AdvertisingVo>(), videoMapper, AdvertisingVo::new);
    }

    @Override
    public int addAdvertising(AdvertisingQo advertisingQo) {
        //1. 上传 文件
        //2. 将 QO-->PO
        Advertising advertising = new Advertising();
        Video video = new Video();
        //QO-->PO
        CopyPropertiesUtils.copyLocalDateTime(advertisingQo, advertising);

        //QO-->PO
        BeanUtils.copyProperties(advertisingQo, video);
        //3. 调用 oss 文件上传  将视频文件上传  返回 url  视频大小  时长
//        fileUpdateUtils.load(advertisingQo.getFile())
        video.setUrl("https:baidu.com");
        video.setSize(15L);
        video.setDuration((short) 10);
        System.out.println(video);
        //4. 返回值
        videoMapper.insert(video);
        System.out.println("视频ID"+video.getVideoId());
        //创建时间
        advertising.setCreateTime(LocalDateTime.now());
        //视频id
        advertising.setVideoId(video.getVideoId());
        //广告状态默认为  1
        advertising.setStatus((byte)1);

        System.out.println(advertising);

        return advertisingMapper.insert(advertising);
    }

    @Override
    public AdvertisingVo queryAdvertising(Long advertisingId) {
        //根据 ID 查询出 Advertising 对象
        Advertising advertising = advertisingMapper.selectByPrimaryKey(advertisingId);
        //创建展示的给 前端的  Vo
        AdvertisingVo vo = new AdvertisingVo();
        // 根据 查询出的 Advertising 的 VideoId 查询出  视频对象  然后 对 Vo 进行赋值
        BeanUtils.copyProperties(videoMapper.selectByPrimaryKey(advertising.getVideoId()),vo);
        return  !ObjectUtils.isEmpty(advertising)? CopyPropertiesUtils.copyLocalDateTime(advertising,vo):null;
    }

    @Override
    public RespResult<Object> update(AdvertisingQo advertisingQo) {
        try {
            //QO->VO
            Advertising advertising = advertisingMapper.selectByPrimaryKey(advertisingQo.getAdvertisingId());

            // 1 . 状态修改
            //如果前端传递的状态不为空   则修改状态
            if (!ObjectUtils.isEmpty(advertisingQo.getStatus())){
                //如果 状态为 3 表示 删除
                if (advertisingQo.getStatus()==3){
                  advertisingMapper.deleteByPrimaryKey(advertising.getAdvertisingId());
                  videoMapper.deleteByPrimaryKey(advertising.getVideoId());
                  return RespResult.success("删除成功");
                }else {
                    //更改 状态
                    advertising.setStatus(advertisingQo.getStatus());
                }
            }

            // 2.修改 url

            //查询出 video 信息
            Video video = videoMapper.selectById(advertising.getVideoId());
            //判断是否 对 视频 url 信息 进行了修改
            if (!ObjectUtils.isEmpty(advertisingQo.getFile())){
                //更改上传的url
                String url = fileUpdateUtils.load(advertisingQo.getFile());
                video.setUrl(url);
            }

            AdvertisingVo advertisingVo = new AdvertisingVo();
            //更改后 赋值
            CopyPropertiesUtils.copyLocalDateTime(advertising,advertisingVo);
            CopyPropertiesUtils.copyProperties(video,advertisingVo);
            return RespResult.success(advertisingVo);
        } catch (BeansException e) {
            throw new RuntimeException(e);
        }
    }


}
