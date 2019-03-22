package com.lld.entity;

public class BlogType {
	
	private Integer typeid;
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
	@Override
	public String toString() {
		return "BlogType [typeid=" + typeid + ", typeName=" + typeName + "]";
	}
	public BlogType(Integer typeid, String typeName) {
		super();
		this.typeid = typeid;
		this.typeName = typeName;
	}
	public BlogType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
