package com.cjt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjt.entity.Bbstype;
import com.cjt.service.BbstypeService;

@Controller

public class BbstypeController {

	@Autowired
	BbstypeService serice;
	
	
	@RequestMapping("lefttype")
	@ResponseBody
	public List<Map<String, Object>> query(Model model){
		List<Map<String, Object>> list = serice.querytypeall();
		return list;
	}
	
	@RequestMapping("type")
	public String  query1(){
		//List<Map<String, Object>> list = serice.querytypeall();
		return "left";
	}
	
}
