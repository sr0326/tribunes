package com.sr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.DownResourceDao;

@Service
public class DownResourceService {

	@Autowired
	DownResourceDao drd;
	
	public List<Map<String,Object>> queryUpscoreById(String uid){
		return drd.queryUpscoreById(uid);
	}
	
	public List<Map<String,Object>> queryDownscoreById(String uid){
		return drd.queryDownscoreById(uid);
	}

}
