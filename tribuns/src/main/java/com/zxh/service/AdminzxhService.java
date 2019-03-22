package com.zxh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.dao.AdminzxhDao;
import com.zxh.entity.Adminszxh;



@Service
public class AdminzxhService {
	
	@Autowired(required=true)
	AdminzxhDao userdao;
	
	public List<Adminszxh> login(Adminszxh admin){
		return userdao.login(admin);
	}
}
