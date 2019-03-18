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
	
	public List<Map<String,Object>> queryFileById(String uid){
		return drd.queryFileById(uid);
	}

}
