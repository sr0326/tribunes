package com.sr.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CollectDownFileDao{
	/**
	 * 收藏资源功能
	 * @param cdf
	 * @return
	 */
	public int collectFIle(Integer fileid,String uid);
	
	/**
	 * 查看我的收藏
	 * @param userid
	 * @return
	 */
	public List<Map<String,Object>> queryCollectDown(String userid);
	
	/**
	 * 取消收藏
	 * @param collectdownid
	 * @return
	 */
	public int closeConects(Integer collectdownid);
}
