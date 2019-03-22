package com.zxh.service;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.zxh.entity.UserInfozxh;

public class UserinfoRealm extends AuthorizingRealm{
	
	@Resource
	UserInfozxhService userService;
	/**
	 * 执行授权逻辑
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 执行认证逻辑
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken token=(UsernamePasswordToken)arg0;
		UserInfozxh user = userService.queryUserbyphone(token.getUsername());
		if (user == null) {
		  return null;
		}
		//ByteSource credentialsSalt = ByteSource.Util.bytes(token.getUsername());
		//System.out.println(new SimpleAuthenticationInfo("", user.getUsepwd(),credentialsSalt,""));
		return new SimpleAuthenticationInfo("",user.getUsepwd(),null,"");
	}
	
	
	
}
