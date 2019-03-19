package com.zxh.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zxh.realm.UserinfoRealm;
@Configuration
public class ShiroConfig {
	@Bean
	public ShiroFilterFactoryBean getshirFilter(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//添加shiro 过滤器
		// anon 无需登录
		// authc 必须登录才可访问
		// user : remember 
		// perms:该资源必须得到资源权限才能访问
		// roles 必须得到角色权限才可访问
		Map<String,String> filterChainDefinitionMap=new LinkedHashMap<String,String>();
		filterChainDefinitionMap.put("/write", "authc");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/zxhuserinfo/userlogin", "anon");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		shiroFilterFactoryBean.setLoginUrl("/userlogin");
		return shiroFilterFactoryBean;
		
	}
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("authRealm")UserinfoRealm userRealm){
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
		
	}
	
	@Bean(name="hashedCredentialsMatcher")
	public HashedCredentialsMatcher hashedCredentialsMatcher(){
		HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
		credentialsMatcher.setHashAlgorithmName("MD5");
		credentialsMatcher.setHashIterations(1000);
		return credentialsMatcher;
	}
	
	@Bean("authRealm")
    public UserinfoRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
		UserinfoRealm authRealm = new UserinfoRealm();
        authRealm.setAuthorizationCachingEnabled(false);
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }
	
	/**
     * 配置shiro跟spring的关联
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
