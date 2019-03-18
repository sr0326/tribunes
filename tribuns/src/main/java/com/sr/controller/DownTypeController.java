package com.sr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sr.entity.DownType;
import com.sr.service.DownTypeService;

@Controller
@RequestMapping("downtypec")
public class DownTypeController {

	@Autowired
	DownTypeService dts;
	
	@RequestMapping("queryTypeAll")
	public String queryTypeAll(Model model){
		List<DownType> querytype = dts.queryAll();
		model.addAttribute("querytype", querytype);
		System.out.println(querytype);
		return "myuploadfile";
	}
	
	@RequestMapping("test")
	public String test(){
		return "recommend";
	}
}
