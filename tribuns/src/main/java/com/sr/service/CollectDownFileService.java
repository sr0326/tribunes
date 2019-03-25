package com.sr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.CollectDownFileDao;

@Service
public class CollectDownFileService{
	
	@Autowired
	CollectDownFileDao cdfd;
	
	public int collectFIle(Integer fileid,String uid){
		return cdfd.collectFIle(fileid,uid);
	}
	
	public List<Map<String,Object>> queryCollectDown(String userid){
		return cdfd.queryCollectDown(userid);
	}
	
	public int closeConects(Integer collectdownid){
		return cdfd.closeConects(collectdownid);
	}
}
