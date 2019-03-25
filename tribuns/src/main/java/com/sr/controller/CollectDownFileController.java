package com.sr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sr.service.CollectDownFileService;

@Controller
@RequestMapping("collectdownc")
public class CollectDownFileController {

	@Autowired
	CollectDownFileService cdfs;
	
	@RequestMapping("addCollect")
	public String addCollect(Integer fileid,String uid){
		System.out.println(fileid+","+uid);
		int collectFIle = cdfs.collectFIle(fileid,uid);
		System.out.println(collectFIle);
		return "redirect:/downfilec/myResources?userid="+uid;
	}
	
	@RequestMapping("queryConectUid")
	@ResponseBody
	public List<Map<String, Object>> queryConectUid(String userid){
		List<Map<String, Object>> queryCollectAll = cdfs.queryCollectDown(userid);
		System.out.println(queryCollectAll);
		return queryCollectAll;
	}
	
	@RequestMapping("closeCon")
	@ResponseBody
	public int closeCon(Integer collectdownid){
		System.out.println(collectdownid);
		int closeConects = cdfs.closeConects(collectdownid);
		System.out.println(closeConects);
		return 1;
	}
}
