package com.cjt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.cjt.entity.Bbstype;
@Mapper
public interface BbstypeDao {

	@Select("SELECT btid, BTName,parentid from bbstype where parentid =#{parm1}")
	public List<Bbstype> querytype(Integer parentid);
	
	/*
	 * 树形菜单
	 */
	@Select("SELECT btid, BTName,parentid from bbstype")
	public List<Map<String,Object>> querytypeall();
}
