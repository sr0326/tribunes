package com.zxh.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.entity.Blog;
import com.zxh.service.BlogService;
import com.zxh.util.FileConfig;

@Controller
@RequestMapping("zxhblog")
public class BlogController {
	//insertblog
	@Resource
	BlogService blogservice;
	@Resource
	private FileConfig config;
	@RequestMapping("insertblog")
	@ResponseBody
	public Integer insertblog(Blog blog){
		
		return blogservice.addBlog(config.getTxtSavePath(),blog);
	}
}
