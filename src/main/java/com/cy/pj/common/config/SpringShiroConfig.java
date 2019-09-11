package com.cy.pj.common.config;

import java.util.LinkedHashMap;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShiroConfig {
     /**shiro的核心管理器对象(负责提供认证和授权操作)*/
	 @Bean
	 public SecurityManager securityManager(Realm realm) {
		 DefaultWebSecurityManager sm=
		 new DefaultWebSecurityManager();
		 sm.setRealm(realm);
		 return sm;
	 }
	 /**负责创建过滤器工厂,通过此工厂创建过滤器*/
	 @Bean("shiroFilterFactory")
	 public ShiroFilterFactoryBean newShirofFactoryBean(
			SecurityManager securityManager) {
		 ShiroFilterFactoryBean fBean=
		 new ShiroFilterFactoryBean();
		 fBean.setSecurityManager(securityManager);
		 fBean.setLoginUrl("/doLoginUI");
		 LinkedHashMap<String,String> filterMap=
			new LinkedHashMap<>();
		 filterMap.put("/bower_components/**", "anon");
		 filterMap.put("/build/**", "anon");//anon表示允许匿名访问
		 filterMap.put("/dist/**", "anon");
		 filterMap.put("/plugins/**", "anon");
		 filterMap.put("/user/doLogin","anon");
		 filterMap.put("/doLogout","logout");
		 filterMap.put("/**", "authc");//authc表示要认证才可访问
		 fBean.setFilterChainDefinitionMap(filterMap);
		 return fBean;
	 }
	 
	 
}






