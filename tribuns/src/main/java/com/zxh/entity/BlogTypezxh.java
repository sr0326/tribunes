package com.zxh.entity;

public class BlogTypezxh {
	private Integer	typeid;
	private String typeName;
	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public BlogTypezxh(Integer typeid, String typeName) {
		super();
		this.typeid = typeid;
		this.typeName = typeName;
	}
	public BlogTypezxh() {
		super();
	}
	@Override
	public String toString() {
		return "BlogType [typeid=" + typeid + ", typeName=" + typeName + "]";
	}
	
}
