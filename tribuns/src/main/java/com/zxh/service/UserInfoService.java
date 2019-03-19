package com.zxh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.dao.UserInfoDao;
import com.zxh.entity.UserInfo;
import com.zxh.util.RandomUtil;



@Service
public class UserInfoService {
	
	@Autowired(required=true)
	UserInfoDao userdao;
	
	public List<UserInfo> queryuserinfo(){
		return userdao.queryUserInfo();
	}
	
	public UserInfo queryUserbyphone(String phone){
		return userdao.queryUserbyphone(phone);
	}
	
	public Integer register(UserInfo user){
		String letter=RandomUtil.generateLowerString(3);
		String nums=RandomUtil.generateNumber(5);
		user.setUserId(letter+"_"+nums);
		System.out.println(user.getUserId());
		return userdao.register(user);
	}
}
