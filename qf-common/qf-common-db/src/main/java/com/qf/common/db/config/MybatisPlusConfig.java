package com.qf.common.db.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
//@MapperScan("com.qf.**.mapper")
public class MybatisPlusConfig {

    /**
     * mybatis plus  核心 配置类   MybatisPlusInterceptor
     *
     * @return
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(PaginationInnerInterceptor paginationInnerInterceptor,
                                                         OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor,
                                                         BlockAttackInnerInterceptor blockAttackInnerInterceptor) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(paginationInnerInterceptor);
        interceptor.addInnerInterceptor(optimisticLockerInnerInterceptor);
        interceptor.addInnerInterceptor(blockAttackInnerInterceptor);
        return interceptor;
    }

    /**
     * 分页插件
     *
     * @return
     */

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        interceptor.setMaxLimit(200L);
        interceptor.setOverflow(true);
        return interceptor;
    }

    /**
     * 乐观锁 插件
     */

    @Bean
    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor() {
        return new OptimisticLockerInnerInterceptor();
    }

    /**
     * 内部拦截器
     * @return
     */
    @Bean
    public BlockAttackInnerInterceptor blockAttackInnerInterceptor() {
        return new BlockAttackInnerInterceptor();
    }

}
