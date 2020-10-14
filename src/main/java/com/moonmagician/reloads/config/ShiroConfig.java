package com.moonmagician.reloads.config;

import com.moonmagician.reloads.shiro.realm.UserRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;


public class ShiroConfig {

    @Bean
    public UserRealm myShiroRealm(){
        return new UserRealm();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        //通用配置（跳转登录页面，未授权跳转的页面）
        factoryBean.setLoginUrl("/index");//未登录跳转地址，返回json
        factoryBean.setUnauthorizedUrl("/index");//未授权跳转地址，返回json

        Map<String, String> filterRuleMap = new LinkedHashMap<String, String>();
        //设置shiro内置过滤器
        /**
         *      Shiro内置过滤器，可以实现权限相关的拦截器
         *          常用的过滤器：
         *              anon:无需认证就可以访问
         *              authc: 必须认证才可以访问
         *              user: 如果使用rememberMe的功能可以直接访问
         *              perms: 该资源必须得到资源权限可以访问
         *              role: 该资源必须得到角色权限才可以访问
         */

        filterRuleMap.put("/login", "anon");//登陆
        filterRuleMap.put("/index.html","anon");
        filterRuleMap.put("/","anon");
        filterRuleMap.put("/system/register", "anon");//注册
        filterRuleMap.put("/autherror", "anon");//跳转地址
        filterRuleMap.put("/resources/**", "anon");
        //不建议使用这个匹配规则，他把resources下面的所有我们设置的静态资源全部展示出来了，那么我们上面的匹配规则已经没有意义了。初衷：我们只是想把某些想要展示的静态资源展示出来。
        //filterRuleMap.put("/resources/**","anon");
        //放行静态资源
        filterRuleMap.put("/static/**", "anon");
        filterRuleMap.put("/public/**", "anon");
        filterRuleMap.put("/templates/**", "anon");
        filterRuleMap.put("/druid/**","anon");

        filterRuleMap.put("/upload/**", "anon");
        filterRuleMap.put("/files/**", "anon");
//        filterRuleMap.put("/", "anon");

        //放行swagger文档
        filterRuleMap.put("/swagger-ui.html", "anon");
        filterRuleMap.put("/swagger-resources/**", "anon");
        filterRuleMap.put("/v2/**", "anon");
        filterRuleMap.put("/webjars/**", "anon");

        filterRuleMap.put("/logout", "logout");
        filterRuleMap.put("/**", "authc");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }

    /**
     * 之后要使用的类需要这个类的存在，所以从这里把他加入到bean中
     * @return
     */

    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     *
     * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})//控制bean加载顺序，等到它加载好之后才可以加载
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean      //Advisor:顾问 //开启对shior注解的支持
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public SecurityManager securityManager(UserRealm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(realm);

//        //将自定义的会话管理器注册到安全管理器中
//        securityManager.setSessionManager(sessionManager());
        //将自定义的redis缓存管理器注册到安全管理器中
        //securityManager.setCacheManager(cacheManager());

        return securityManager;
    }
}
