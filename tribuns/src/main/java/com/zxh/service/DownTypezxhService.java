package com.zxh.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.dao.DownTypezxhDao;
import com.zxh.entity.Downtypezxh;

@Service
public class DownTypezxhService {
	@Autowired(required=true)
	DownTypezxhDao downtypedao;
	
	public List<Downtypezxh> queryDowntype(){
		return downtypedao.querydowntype();
	}
}
