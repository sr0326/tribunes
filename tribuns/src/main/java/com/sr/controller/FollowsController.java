package com.sr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sr.service.FollowsService;

@Controller
@RequestMapping("followsc")
public class FollowsController {

	@Autowired
	FollowsService fs;
	
	@RequestMapping("insertfollow")
	public String insertfollow(String uid,String fid){
		int addfollow = fs.addfollow(uid,fid);
		System.out.println(addfollow);
		return "redirect:/downfilec/queryDownFile";
	}
	
}
