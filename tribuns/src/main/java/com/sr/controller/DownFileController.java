package com.sr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sr.entity.DownFile;
import com.sr.entity.DownType;
import com.sr.entity.UserInfo;
import com.sr.service.DownFileService;
import com.sr.service.DownTypeService;
import com.sr.service.UserInfoService;

@Controller
@RequestMapping("downfilec")
public class DownFileController {

	@Autowired
	DownFileService dfs;
	
	@Autowired
	DownTypeService dts;
	
	@Autowired
	UserInfoService ufs;
	//下载首页
	@RequestMapping("queryDownFile")
	public String queryDownFile(Model model){
		//查询所有下载类型
		List<DownType> querytype = dts.queryAll();
		model.addAttribute("querytype", querytype);
		//下载资源(所有资源)
		List<DownFile> queryDownFile = dfs.queryDownFile(null,null,null,null,null,null);
		model.addAttribute("queryDownFile", queryDownFile);
		//精品推荐
		List<DownFile> recommend = dfs.recommend();
		model.addAttribute("recommend", recommend);
		return "download";
	}
	
	/**
	 * 根据类型查询
	 * @param downtypeid
	 * @param filetype
	 * @return
	 */
	@RequestMapping("queryfile")
	@ResponseBody
	public List<DownFile> queryfile(String downtype,String filetype){
		Integer downtypeid = 0;
		Integer filetypeid = 0;
		List<DownType> querytype = dts.queryAll();
		if (downtype.length()<10) {
			for (DownType down : querytype) {
				if (downtype.equals(down.getDowntypeName()+",")) {
					downtypeid = down.getDowntypeid();
				}
			}
		}else{
			downtypeid = null;
		}
		if ("文档类,".equals(filetype)) {
			filetypeid = 1;
		}else if ("代码类,".equals(filetype)) {
			filetypeid = 2;
		}else if ("工具类,".equals(filetype)) {
			filetypeid = 3;
		}else if ("其他,".equals(filetype)) {
			filetypeid = 4;
		}else{
			filetypeid = null;
		}
		System.out.println("downtypeid:"+downtypeid+",filetypeid:"+filetypeid);
		List<DownFile> query = dfs.queryDownFile(downtypeid,null,null,null,filetypeid,null);
		System.out.println(query);
		return query;
	}
	
	//模糊搜索
	@RequestMapping("findByName")
	@ResponseBody
	public List<DownFile> findByName(String fileName){
		System.out.println(fileName);
		List<DownFile> byName = dfs.queryDownFile(null,fileName,null,null,null,null);
		System.out.println(byName);
		return byName;
	}
	
	//根据资源id查询资源信息
	@RequestMapping("queryById")
	public String queryById(Integer fileid,String userid,Integer downtypeid,Model model){
		DownFile queryById = dfs.queryById(fileid);
		model.addAttribute("queryById", queryById);
		//根据类型查询资源
		List<DownFile> bydowntypeid = dfs.queryDownFile(downtypeid, null,fileid,null,null,null);
		model.addAttribute("bydowntypeid", bydowntypeid);
		//根据资源ID查询作者信息
		DownFile queryUser = dfs.queryUser(fileid);
		model.addAttribute("queryUser", queryUser);
		//根据用户ID查询资源
		List<DownFile> queryByUseridfiles = dfs.queryByUseridfiles(userid,fileid);
		model.addAttribute("queryByUseridfiles", queryByUseridfiles);
		return "downfile";
	}
	
	//根据最新时间查询
	@RequestMapping("bynewTime")
	@ResponseBody
	public List<DownFile> bynewTime(){
		return dfs.BynewTime();
	}

	//我的资源
	@RequestMapping("myResources")
	public String myResources(String userid,Model model){
		UserInfo u = new UserInfo();
		u.setUserId(userid);
		UserInfo login = ufs.login(u);
		model.addAttribute("login", login);
		List<Map<String, Object>> queryPaiming = dfs.queryPaiming(userid);
		model.addAttribute("rownum", queryPaiming.get(0).get("rownum"));
		model.addAttribute("integral", queryPaiming.get(0).get("integral"));
		model.addAttribute("upload", queryPaiming.get(0).get("upload"));
		model.addAttribute("down", queryPaiming.get(0).get("down"));
		return "mydown";
	}
	
	/**
	 * 查询上传信息
	 * @param userid
	 * @return
	 */
	@RequestMapping("queryMyUp")
	@ResponseBody
	public List<DownFile> queryMyUp(String userid,Integer upfilestate){
		List<DownFile> queryMyDowns = dfs.queryDownFile(null, null, null, userid,null,upfilestate);
		System.out.println(queryMyDowns);
		return queryMyDowns;
	}
	
	
}
