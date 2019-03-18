package com.sr.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sr.entity.UserInfo;

@Mapper
public interface UserInfoDao {

	/**
	 * 登录方法
	 * @param u
	 * @return
	 */
	public UserInfo login(UserInfo u);

}
