package com.sr.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sr.entity.DownFile;
import com.sr.entity.DownType;
import com.sr.entity.UserInfo;
import com.sr.service.DownFileService;
import com.sr.service.DownTypeService;

@Controller
@RequestMapping("downfilec")
public class DownFileController {

	@Autowired
	DownFileService dfs;
	
	@Autowired
	DownTypeService dts;
	
	//下载首页
	@RequestMapping("queryDownFile")
	public String queryDownFile(Model model){
		//查询所有下载类型
		List<DownType> querytype = dts.queryAll();
		model.addAttribute("querytype", querytype);
		//下载资源(所有资源)
		List<DownFile> queryDownFile = dfs.queryDownFile(null,null,null,null,null,1);
		model.addAttribute("queryDownFile", queryDownFile);
		//精品推荐
		List<DownFile> recommend = dfs.recommend();
		model.addAttribute("recommend", recommend);
		return "download";
	}
	
	//根据类型查询
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
		List<DownFile> query = dfs.queryDownFile(downtypeid,null,null,null,filetypeid,1);
		System.out.println(query);
		return query;
	}
	
	//模糊搜索
	@RequestMapping("findByName")
	@ResponseBody
	public List<DownFile> findByName(String fileName,String downtype,String filetype){
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
		List<DownFile> byName = dfs.queryDownFile(downtypeid,fileName,null,null,filetypeid,1);
		System.out.println(byName);
		return byName;
	}
	
	//根据资源id查询资源信息
	@RequestMapping("queryById")
	public String queryById(Integer fileid,String userid,Integer downtypeid,Model model){
		DownFile queryById = dfs.queryById(fileid);
		model.addAttribute("queryById", queryById);
		System.out.println(queryById);
		//根据类型查询资源
		List<DownFile> bydowntypeid = dfs.queryDownFile(downtypeid, null,fileid,null,null,1);
		model.addAttribute("bydowntypeid", bydowntypeid);
		System.out.println(bydowntypeid);
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
		System.out.println(userid);
		List<Map<String, Object>> queryPaiming = dfs.queryPaiming(userid);
		List<Map<String, Object>> downnum = dfs.downnum(userid);
		List<Map<String, Object>> uploadnum = dfs.uploadnum(userid);
		model.addAttribute("rownum", queryPaiming.get(0).get("rownum"));
		model.addAttribute("integral", queryPaiming.get(0).get("integral"));
		model.addAttribute("upload", uploadnum.get(0).get("uploads"));
		model.addAttribute("down", downnum.get(0).get("down"));
		return "mydown";
	}

	//查询上传信息
	@RequestMapping("queryMyUp")
	@ResponseBody
	public List<DownFile> queryMyUp(String userid,Integer upfilestate){
		System.out.println(userid+","+upfilestate);
		List<DownFile> queryMyDowns = dfs.queryDownFile(null, null, null, userid,null,upfilestate);
		System.out.println(queryMyDowns);
		return queryMyDowns;
	}
	
	//上传资源
	@RequestMapping("uploadfile")
	@ResponseBody
	public void uploadfile(DownFile df,MultipartFile urlfile){
		System.out.println(df);
		System.out.println(urlfile);
		//获取文件名
		String filename = urlfile.getOriginalFilename();
		//文件存储路径
		String filepath = "E:/worktemp/"+UUID.randomUUID().toString().replaceAll("-", "")+"_"+filename;
		System.out.println("save file to:" + filepath);
		File dest = new File(filepath);
		if (dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			df.setUrl(filepath);
			dfs.addfile(df);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("success")
	public String success(){
		return "uploadsuccess";
	}
	
	//查询他人的资源
	@RequestMapping("heresour")
	public String heresour(String userid,Integer pageindex,Model model){
		System.out.println(userid);
		if (null == pageindex) {
			pageindex = 1;
		}
		int total = 0;
		int size = dfs.queryHeResour(userid,null).size();
		if (size%2 == 0) {
			total = size/2;
		}else{
			total = size/2+1;
		}
		Integer limit = (pageindex-1)*2;
		List<Map<String, Object>> queryhe = dfs.queryHeResour(userid,limit);
		System.out.println(total);
		model.addAttribute("queryhe", queryhe);
		UserInfo heUser = dfs.queryHeUser(userid);
		model.addAttribute("heUser", heUser);
		model.addAttribute("total", total);
		model.addAttribute("pageindex", pageindex);
		model.addAttribute("size", size);
		return "heresource";
	}
}
