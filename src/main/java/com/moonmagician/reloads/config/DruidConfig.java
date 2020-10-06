package com.moonmagician.reloads.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    // 真正整合的地方
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean(name="dataSource")
    public DataSource dataSource(){
        return  new DruidDataSource();
    }

    //配置Druid监控
    @Bean
    public ServletRegistrationBean statViewServlet(){
        //StatViewServlet是druid内置的用来展示druid统计信息的页面，注册为服务servlet后可以使用
        ServletRegistrationBean bean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");

        Map<String,String> initParams=new HashMap<>();
        initParams.put("allow", "");// IP白名单 (没有配置或者为空，则允许所有访问)
        // IP黑名单 (存在共同时，deny优先于allow),但是他的使用效果是怎样的呢？设置了所有以后本机还是可以随便访问。
        //initParams.put("deny", "");
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        initParams.put("resetEnable","false");

        bean.setInitParameters(initParams);
        return bean;
    }
}
