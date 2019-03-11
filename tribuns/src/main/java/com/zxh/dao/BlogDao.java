package com.zxh.dao;

import org.apache.ibatis.annotations.Mapper;

import com.zxh.entity.Blog;
@Mapper
public interface BlogDao {
	public Integer addBlog(Blog blog);
}
