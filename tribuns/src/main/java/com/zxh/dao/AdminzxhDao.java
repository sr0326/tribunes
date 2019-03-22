package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zxh.entity.Adminszxh;
@Mapper
public interface AdminzxhDao {
	public List<Adminszxh> login(Adminszxh admin);
}
 