package com.cjt.entity;

import java.sql.Date;

public class Bbs {

	private Integer bbsid;
	private String bbsTitle;
	private String bbsContent;
	private Date pushtime;
	private String userId;
	private Integer BTid;
	private Integer score;
	private Integer state;
	public Integer getBbsid() {
		return bbsid;
	}
	public void setBbsid(Integer bbsid) {
		this.bbsid = bbsid;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public Date getPushtime() {
		return pushtime;
	}
	public void setPushtime(Date pushtime) {
		this.pushtime = pushtime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getBTid() {
		return BTid;
	}
	public void setBTid(Integer bTid) {
		BTid = bTid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Bbs [bbsid=" + bbsid + ", bbsTitle=" + bbsTitle
				+ ", bbsContent=" + bbsContent + ", pushtime=" + pushtime
				+ ", userId=" + userId + ", BTid=" + BTid + ", score=" + score
				+ ", state=" + state + "]";
	}
	
	
}
