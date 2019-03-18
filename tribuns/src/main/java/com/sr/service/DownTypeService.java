package com.sr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.DownTypeDao;
import com.sr.entity.DownType;

@Service
public class DownTypeService {

	@Autowired
	DownTypeDao dtd;
	
	public List<DownType> queryAll(){
		return dtd.queryAll();
	}
}
