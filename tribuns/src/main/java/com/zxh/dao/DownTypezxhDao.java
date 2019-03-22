package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zxh.entity.Downtypezxh;
@Mapper
public interface DownTypezxhDao {
	public List<Downtypezxh> querydowntype();
}
