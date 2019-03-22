package com.lld.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lld.entity.Blog;
import com.lld.entity.UserInfo;
import com.lld.service.BlogDaoService;

@Controller()
@RequestMapping("blog")
public class BlogDaoController {

	@Resource
	BlogDaoService bd;
	
	@RequestMapping("ra")
	public String middle(Model model,String userId){
		List<Blog> list=bd.middle(userId);//UserInfo 中间
		List<UserInfo> list2=bd.bo(userId);	//UserInfo 页面  博客专家
		//List<Blog> list3=bd.center(typeid);//UserInfo 中间  显示 和此人头像有关的数据
		System.out.println(list2);
		System.out.println(list);	
		model.addAttribute("list",list);
		model.addAttribute("list2", list2);
		//model.addAttribute("list3", list3);
		return "userInfo";
	}
	
}
