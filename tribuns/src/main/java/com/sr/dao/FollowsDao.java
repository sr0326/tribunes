package com.sr.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FollowsDao {

	/**
	 * 关注
	 * @param f
	 * @return
	 */
	public int addfollow(String userid,String followedid);
}
