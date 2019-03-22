package com.zxh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zxh.entity.Downtypezxh;
import com.zxh.service.DownTypezxhService;

@Controller
@RequestMapping("zxhdowntype")
public class DownTypezxhController {
	
	@Resource
	DownTypezxhService downservice; 
	
	@RequestMapping("querydowntype")
	@ResponseBody
	public Map<String,Object> querydowntype(){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Downtypezxh> list = downservice.queryDowntype();
		map.put("data", list);
		map.put("code", 0);
		map.put("count", list.size());
		map.put("msg", "");
		return map;
	}
}	
