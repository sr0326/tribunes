package com.cjt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjt.dao.BbstypeDao;
import com.cjt.entity.Bbstype;



@Service
@Transactional
public class BbstypeService {

	@Autowired
	BbstypeDao dao;
	
	public List<Bbstype> querytype(Integer parentid){
		 return dao.querytype(parentid);
	}
	
	
	public List<Map<String,Object>> querytypeall(){
		
		return dao.querytypeall();
	}
}
