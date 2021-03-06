package com.sr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.dao.DownFileDao;
import com.sr.entity.DownFile;
import com.sr.entity.UserInfo;

@Service
public class DownFileService {

	@Autowired
	DownFileDao dfd;
	
	public List<DownFile> queryDownFile(Integer downtypeid,String fileName,Integer fileid,String userid,Integer filetype,Integer upfilestate){
		return dfd.queryDownFile(downtypeid,fileName,fileid,userid,filetype,upfilestate);
	}
	
	public DownFile queryById(Integer fileid){
		return dfd.queryById(fileid);
	}
	
	public List<DownFile> recommend(){
		return dfd.recommend();
	}
	
	public List<DownFile> BynewTime(){
		return dfd.BynewTime();
	}
	
	public DownFile queryUser(Integer fileid){
		return dfd.queryUser(fileid);
	}
	
	public List<DownFile> queryByUseridfiles(String userid,Integer fileid){
		return dfd.queryByUseridfiles(userid,fileid);
	}
	
	public List<Map<String,Object>> queryPaiming(String userid){
		return dfd.queryPaiming(userid);
	}
	
	public List<Map<String,Object>> downnum(String userid){
		return dfd.downnum(userid);
	}
	
	public List<Map<String,Object>> uploadnum(String userid){
		return dfd.uploadnum(userid);
	}
	
	public int addfile(DownFile df){
		return dfd.addfile(df);
	}
	
	public List<Map<String,Object>> queryHeResour(String uid,Integer pageindex){
		return dfd.queryHeResour(uid,pageindex);
	}
	
	public UserInfo queryHeUser(String uid){
		return dfd.queryHeUser(uid);
	}

}
