package com.zxh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zxh.util.FileUtils;

@Controller
public class WriteController {
	@RequestMapping("write")
	public String write(){
		return "writart";
	}
	@RequestMapping("userlogin")
	public String tologin(){
		return "login";
	}
	@RequestMapping("fileread")
	public String ww555(Model model,Integer blogid){
		String path="E://files//txtinfo";
		String a=FileUtils.readFile(path+"/41768864_qtx_39019.txt");
		model.addAttribute("s", a);   
		return "readfile";
	}
	@RequestMapping("person")
	public String person(){
		return "personal";
	}
	@RequestMapping("test2")
	public String test(){
		return "text";
	}
}
