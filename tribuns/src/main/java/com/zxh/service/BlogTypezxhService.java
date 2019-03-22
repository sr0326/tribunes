package com.zxh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.dao.BlogTypezxhDao;
import com.zxh.entity.BlogTypezxh;

@Service
public class BlogTypezxhService {
	@Autowired(required=true)
	BlogTypezxhDao blogtypedao;
	
	public List<BlogTypezxh> queryblogtype(){
		return blogtypedao.queryblogtype();
	}
}
