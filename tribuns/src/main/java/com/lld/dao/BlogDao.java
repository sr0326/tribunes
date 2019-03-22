package com.lld.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lld.entity.Blog;
import com.lld.entity.UserInfo;

@Mapper
public interface BlogDao {
	
	public List<Blog> middle(String userId);//添加中间模块
	
	public List<UserInfo> name(String userId);//添加博客的姓名
	
	public List<UserInfo> bo(String userId);//UserInfo 页面  博客专家
	
	//public List<Blog> center(Integer typeid);//UserInfo 中间  显示 和此人头像有关的数据
}
