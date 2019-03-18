package com.sr.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sr.entity.UserInfo;
import com.sr.service.UserInfoService;

@Controller
@RequestMapping("userc")
public class UserInfoController {

	@Autowired
	UserInfoService userinfos;
	
	@RequestMapping("login")
	public String login(UserInfo u,Model model){
		UserInfo userinfo = userinfos.login(u);
		model.addAttribute("userinfo", userinfo);
		return "personal";
	}
}
