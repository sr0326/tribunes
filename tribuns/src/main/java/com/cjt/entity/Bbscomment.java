package com.cjt.entity;

import java.sql.Date;

public class Bbscomment {

	private Integer bbsCommentId;
	private String content;
	private String userid;
	private Integer bbsid;
	private Date pushtime;
	public Integer getBbsCommentId() {
		return bbsCommentId;
	}
	public void setBbsCommentId(Integer bbsCommentId) {
		this.bbsCommentId = bbsCommentId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Integer getBbsid() {
		return bbsid;
	}
	public void setBbsid(Integer bbsid) {
		this.bbsid = bbsid;
	}
	public Date getPushtime() {
		return pushtime;
	}
	public void setPushtime(Date pushtime) {
		this.pushtime = pushtime;
	}
	@Override
	public String toString() {
		return "Bbscomment [bbsCommentId=" + bbsCommentId + ", content="
				+ content + ", userid=" + userid + ", bbsid=" + bbsid
				+ ", pushtime=" + pushtime + "]";
	}
	
	
	
	

}
