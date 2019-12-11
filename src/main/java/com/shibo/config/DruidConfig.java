package com.shibo.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.google.common.collect.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author shibo
 * @createTime 2019-12-11 22:41
 * @description Druid配置
 */
@Configuration
public class DruidConfig {
    /**
     * 注解说明
     * 用在类上 此注解将类属性和application.properties绑定
     * 与@Bean同用在方法上 将返回对象和application.properties绑定
     * 思想：将配置文件中spring.druid.XXX的值 映射到此方法返回对象的XXX属性中
     * 目的：将重要或可能要修改的配置，写在配置文件中。这样修改时，不需要再此处改代码
     */
    @ConfigurationProperties(prefix = "spring.druid")
    @Bean(initMethod = "init", destroyMethod = "close")//指定初始化和关闭的方法
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        //guava工具类创建ArrayList
        //ArrayList<Filter> arrayList = new ArrayList<>((Collection<? extends Filter>) statFilter());
        ArrayList<Filter> filters = Lists.newArrayList(statFilter());
        druidDataSource.setProxyFilters(filters);
        return druidDataSource;
    }

    /**
     * 慢sql日志  sql执行超时则打印日志
     * druid的Filtet  com.alibaba.druid.filter.Filter;
     *
     * @return
     */
    @Bean
    public Filter statFilter() {
        StatFilter statFilter = new StatFilter();
        //sql执行时间为100ms时触发
        statFilter.setSlowSqlMillis(100);
        //是否打印慢sql日志
        statFilter.setLogSlowSql(true);
        //是否将日志合并
        statFilter.setMergeSql(true);
        statFilter.setDbType("mysql");
        return statFilter;
    }

    /**
     * druid监控
     * servlet通过此类封装 ServletRegistrationBean
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
    }
}
