package com.sr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.FollowsDao;

@Service
public class FollowsService {

	@Autowired
	FollowsDao fd;
	
	public int addfollow(String uid,String fid){
		return fd.addfollow(uid,fid);
	}
}
