package com.zxh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.crypto.spec.SecretKeySpec;












import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.entity.UserInfo;
import com.zxh.service.UserInfoService;
import com.zxh.util.SendTelMsgUtils;
import com.zxh.util.ShiroMD5Util;
@Controller
@RequestMapping("zxhuserinfo")
public class UserInfoController {
	@Resource
	UserInfoService userinfo;
	@RequestMapping("/queryuser")
	@ResponseBody
	public Map<String,Object> query(){
		List<UserInfo> query = userinfo.queryuserinfo();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("data", query);
		map.put("code",0);
		map.put("msg", "");
		map.put("count", 500);
		return map;
	}
	
	@RequestMapping("/userlogin")
	@ResponseBody
	public Integer login(UserInfo userinfo){
		Subject subject =SecurityUtils.getSubject();
		
		//封装用户数据
		UsernamePasswordToken token=new UsernamePasswordToken(userinfo.getPhone(),userinfo.getUsepwd());
		try {
			subject.login(token);
			//登录成功
		} catch (UnknownAccountException e) {
			// TODO Auto-generated catch block
			//登录失败:用户名不存在
			return 1;
		}catch (IncorrectCredentialsException e) {
			// TODO Auto-generated catch block
			//登录失败 密码错误
			return 2;
		}
		return 0;
		
	}
	@RequestMapping("/userReg")
	@ResponseBody
	public Integer register(UserInfo user){
		user.setUsepwd(ShiroMD5Util.SysMd5(user));
		System.out.println(user.getUsepwd());
		Integer i = userinfo.register(user);
		return i;
	}
	
	@RequestMapping("/getMsgs")
	@ResponseBody
	public String getMsgs(String phone){
		String result = SendTelMsgUtils.sendMsgToPhone(phone);
		return result;
	}
}
