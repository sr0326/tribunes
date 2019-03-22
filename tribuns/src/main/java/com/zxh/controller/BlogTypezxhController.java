package com.zxh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.entity.BlogTypezxh;
import com.zxh.service.BlogTypezxhService;

@Controller
@RequestMapping("zxhblogtype")
public class BlogTypezxhController {
	@Resource
	BlogTypezxhService blogtypeservice;
	
	@RequestMapping("querytype")
	@ResponseBody
	public List<BlogTypezxh> query(){
		List<BlogTypezxh> listtype = blogtypeservice.queryblogtype();
		return listtype;
	}
	
	@RequestMapping("blogtype")
	@ResponseBody
	public Map<String,Object> blogtype(){
		Map<String,Object> map=new HashMap<String,Object>();
		List<BlogTypezxh> listtype = blogtypeservice.queryblogtype();
		map.put("data", listtype);
		map.put("count", listtype.size());
		map.put("msg", "");
		map.put("code", "");
		return map;
	}
	
}
