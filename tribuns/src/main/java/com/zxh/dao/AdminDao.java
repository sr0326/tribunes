package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zxh.entity.Admins;
@Mapper
public interface AdminDao {
	public List<Admins> login(Admins admin);
}
 