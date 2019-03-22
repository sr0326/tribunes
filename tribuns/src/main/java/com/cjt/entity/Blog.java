package com.cjt.entity;

import java.sql.Date;

public class Blog {

	private Integer blogId;
	private String blogTitle;
	private String blogContent;
	private Integer artType;
	private Integer blogType;
	private String userId;
	private Date pushtime;
	public Integer getBlogId() {
		return blogId;
	}
	public void setBlogId(Integer blogId) {
		this.blogId = blogId;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public Integer getArtType() {
		return artType;
	}
	public void setArtType(Integer artType) {
		this.artType = artType;
	}
	public Integer getBlogType() {
		return blogType;
	}
	public void setBlogType(Integer blogType) {
		this.blogType = blogType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getPushtime() {
		return pushtime;
	}
	public void setPushtime(Date pushtime) {
		this.pushtime = pushtime;
	}
	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", blogTitle=" + blogTitle
				+ ", blogContent=" + blogContent + ", artType=" + artType
				+ ", blogType=" + blogType + ", userId=" + userId
				+ ", pushtime=" + pushtime + "]";
	}

	
}
