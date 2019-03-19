package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.zxh.entity.UserInfo;
@Mapper
public interface UserInfoDao {
	public List<UserInfo> queryUserInfo();

	public UserInfo queryUserbyphone(String phone);
	
	public Integer register(UserInfo userinfo);
}
