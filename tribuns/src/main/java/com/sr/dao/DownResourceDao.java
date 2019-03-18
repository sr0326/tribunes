package com.sr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DownResourceDao{

	//根据用户ID查询下载文件信息
	public List<Map<String,Object>> queryFileById(String uid);
	
	
}
