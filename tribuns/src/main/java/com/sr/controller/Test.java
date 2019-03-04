package com.sr.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {

	@RequestMapping("test")
	public String test(){
		return "bbs";
	}
	@RequestMapping("test2")
	public String test2(){
		return "blog";
	}
	@RequestMapping("test3")
	public String test3(){
		return "download";
	}
}
