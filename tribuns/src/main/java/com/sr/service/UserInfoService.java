package com.sr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.UserInfoDao;
import com.sr.entity.UserInfo;

@Service
public class UserInfoService {

	@Autowired
	UserInfoDao ud;
	
	public UserInfo login(UserInfo u){
		return ud.login(u);
	}
}
