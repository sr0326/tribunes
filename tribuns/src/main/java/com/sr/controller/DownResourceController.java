package com.sr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sr.service.DownResourceService;

@Controller
@RequestMapping("downresourcec")
public class DownResourceController {

	@Autowired
	DownResourceService drs;
	
	/**
	 * 根据用户编号查询所下载的资源信息
	 * @param uid
	 * @return
	 */
	@RequestMapping("queryFileById")
	@ResponseBody
	public Map<String,Object> queryFileById(String uid){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String, Object>> queryDownscore = drs.queryDownscoreById(uid);
		List<Map<String, Object>> queryUpscore = drs.queryUpscoreById(uid);
		map.put("queryDownscore", queryDownscore);
		map.put("queryUpscore", queryUpscore);
		return map;
	}

}
