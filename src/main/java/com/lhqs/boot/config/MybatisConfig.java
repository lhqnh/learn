package com.lhqs.boot.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {

    @Bean
    public MybatisPlusInterceptor paginationInnerInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //你的最大单页限制数量，默认 500 条，小于 0 如 -1 不受限制
        //paginationInterceptor.setLimit(2);
        //这是分页拦截器，就是将每个查询都加上limit
        PaginationInnerInterceptor paginationInnerInterceptor=new PaginationInnerInterceptor();
        //可以设置这个拦截器,请求页面大于最大页的操作，true跳回首页，false继续请求
        //paginationInnerInterceptor.setOverflow(true);
        //设置每页的最大记录数
        //paginationInnerInterceptor.setMaxLimit(50L);

        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }


}
