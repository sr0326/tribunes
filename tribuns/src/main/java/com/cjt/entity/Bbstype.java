package com.cjt.entity;

import java.util.List;

public class Bbstype {

	private Integer BTid;
	private String BTName;
	private Integer parentid;
	public Integer getBTid() {
		return BTid;
	}
	public void setBTid(Integer bTid) {
		BTid = bTid;
	}
	public String getBTName() {
		return BTName;
	}
	public void setBTName(String bTName) {
		BTName = bTName;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	
	@Override
	public String toString() {
		return "Bbstype [BTid=" + BTid + ", BTName=" + BTName + ", parentid="
				+ parentid + "]";
	}
	
	
}
