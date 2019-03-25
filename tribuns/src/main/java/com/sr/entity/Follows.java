package com.sr.entity;

import java.io.Serializable;

public class Follows implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String userid;
	private String followedid;
	private Integer state;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFollowedid() {
		return followedid;
	}
	public void setFollowedid(String followedid) {
		this.followedid = followedid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Follows(String userid, String followedid, Integer state) {
		super();
		this.userid = userid;
		this.followedid = followedid;
		this.state = state;
	}
	public Follows() {
		super();
	}
	@Override
	public String toString() {
		return "Follows [userid=" + userid + ", followedid=" + followedid
				+ ", state=" + state + "]";
	}
	
}
