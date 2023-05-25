package com.qf.cabinet.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class ExpressBoxMapperTest {

    @Resource
    private ExpressBoxMapper expressBoxMapper;
    @Test
    void count() {
        Long count = expressBoxMapper.count(1L);
        log.info(count.toString());
    }

    @Test
    void countByCid() {
        Long aLong = expressBoxMapper.countByCid(1L);
        log.info(aLong.toString());
    }
}