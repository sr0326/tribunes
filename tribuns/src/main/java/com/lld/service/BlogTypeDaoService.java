package com.lld.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lld.dao.BlogTypeDao;
import com.lld.entity.Blog;
import com.lld.entity.BlogType;
import com.lld.entity.UserInfo;

@Service
public class BlogTypeDaoService {
	@Resource
	BlogTypeDao db;
	
	public List<BlogType> left() {
		return db.left();
	}

	public List<Blog> center(String typeid){
		return db.center(typeid);
	}
	
	//博客专家
	public List<UserInfo> right(){  
		return db.right();
	}

	
	public Map<String,Object> centers(String typeid){
		Map<String,Object> maps=new HashMap<String,Object>();
		maps.put("list", db.left());
		maps.put("lists", db.center(typeid));
		System.out.println(maps);
		return maps;
	}
}
