package com.lld.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.lld.dao.BlogDao;
import com.lld.entity.Blog;
import com.lld.entity.UserInfo;


@Controller
public class BlogDaoService {
	
	@Resource
	BlogDao db;
	
	public List<Blog> middle(String userId){ 
		return db.middle(userId);
	}

	///时哈哈哈哈
	//UserInfo 页面  博客专家
	public List<UserInfo> bo(String userId){
		return db.bo(userId);
				
	}
	
	/*//UserInfo 中间  显示 和此人头像有关的数据
	public List<Blog> center(Integer typeid){
		return db.center(typeid);
		
	}*/
}
