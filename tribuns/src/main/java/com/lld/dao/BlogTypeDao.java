package com.lld.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;





import com.lld.entity.Blog;
import com.lld.entity.BlogType;
import com.lld.entity.UserInfo;
@Mapper
public interface BlogTypeDao {
	
	public List<BlogType> left();//查询左侧导航栏
	
	public List<Blog> center(String typeid);//博客中间板块
	
	public List<UserInfo> right();//博客专家	
}
