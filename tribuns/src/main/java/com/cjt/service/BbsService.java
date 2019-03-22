package com.cjt.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cjt.dao.BbsDao;
import com.cjt.entity.Bbscomment;
import com.cjt.entity.Bbstype;
import com.cjt.entity.Userinfo;
@Service
@Transactional
public class BbsService {
 
	@Autowired
	BbsDao dao;
	
	public List<Map<String,Object>> querybbs(){
		return dao.querybbs();
	}
	public List<Map<String,Object>> queryTbbs(){
		return dao.queryTbbs();
	}
	public List<Map<String,Object>> querybbscomment(Integer bbsid){
		return dao.querybbscomment(bbsid);
	}
	
   public List<Map<String,Object>> queryblog(String userid){
	   return dao.querybolg(userid);
   }
   public List<Userinfo> queryIntegral(){
	   return dao.qeuryIntegral();
   }
   public List<Bbstype> querytypeTwo(Integer parentid){
	   return dao.querytypeTwo(parentid);
   }
   public List<Map<String,Object>> querybbst(Integer bbsid){
	   return dao.querybbst(bbsid);
   }
   public void addComment(Bbscomment b){
	   dao.addComment(b);
	   
   }
}
