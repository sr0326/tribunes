package com.zxh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxh.dao.AdminDao;
import com.zxh.entity.Admins;



@Service
public class AdminService {
	
	@Autowired
	AdminDao userdao;
	
	public List<Admins> login(Admins admin){
		return userdao.login(admin);
	}
}
