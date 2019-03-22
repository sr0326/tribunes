package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zxh.entity.UserInfozxh;

@Mapper
public interface UserInfozxhDao {
	public List<UserInfozxh> queryUserInfo();

	public UserInfozxh queryUserbyphone(String phone);
	
	public Integer register(UserInfozxh userinfo);
	
	public UserInfozxh login(UserInfozxh user);
}
