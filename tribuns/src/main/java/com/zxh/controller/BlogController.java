package com.zxh.controller;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.entity.Blogzxh;
import com.zxh.service.BlogzxhService;
import com.zxh.util.CheckTextUtil;
import com.zxh.util.FileConfig;

@Controller
@RequestMapping("zxhblog")
public class BlogController {
	//insertblog
	@Resource
	BlogzxhService blogservice;
	@Resource
	private FileConfig config;
	@RequestMapping("insertblog")
	@ResponseBody
	public Integer insertblog(Blogzxh blog){
		System.out.println(blog);
		String content = blog.getBlogContent();
		JSONObject check = CheckTextUtil.check(content);
		System.out.println(check);
		Object object = check.get("result");
		//获取结果集
		JSONObject object1=JSONObject.fromObject(object);
		Object i = object1.get("spam");
		//获取结果集中的spam的值
		int result = Integer.parseInt(i.toString());
		if(result==0){
			return blogservice.addBlog(config.getTxtSavePath(),blog);
		}else{
			return result;
		}
		
	}
}
