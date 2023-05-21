package com.qf.advertisement.server.Impl;


import com.qf.advertisement.entity.Video;
import com.qf.advertisement.mapper.VideoMapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class AdvertisingServerImplTest {
    @Resource
    VideoMapper videoMapper;

    @Test
    void queryList() {
        Video video = videoMapper.selectById(100);
        System.out.println(video);
    }
}