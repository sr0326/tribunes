package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zxh.entity.BlogTypezxh;
@Mapper
public interface BlogTypezxhDao {
	public List<BlogTypezxh> queryblogtype();
}
