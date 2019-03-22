package com.lld.controller;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lld.service.BlogTypeDaoService;

@Controller()
@RequestMapping("blogs")
public class BlogTypeDaoController {

	@Resource
	BlogTypeDaoService bs;
	
	@RequestMapping("rm")
	public String left(Model model,String typeid){
		Map<String, Object> map = bs.centers(typeid);
		System.out.println(map);
		model.addAttribute("map",map);
		model.addAttribute("right",bs.right());//博客专家
		return "blog";
	}
	
}
