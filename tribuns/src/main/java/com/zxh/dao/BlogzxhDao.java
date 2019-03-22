package com.zxh.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zxh.entity.Blogzxh;
@Mapper
public interface BlogzxhDao {
	public Integer addBlog(Blogzxh blog);
}
