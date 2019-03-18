package com.sr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sr.entity.DownType;

@Mapper
public interface DownTypeDao {

	/**
	 * 查询所有类型
	 * @return
	 */
	public List<DownType> queryAll();
}
