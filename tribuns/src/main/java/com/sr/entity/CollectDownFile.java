package com.sr.entity;

import java.io.Serializable;

public class CollectDownFile implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer collectdownid;
	private Integer fileid;
	private Integer userid;
	private Integer cdstate;
	public Integer getCollectdownid() {
		return collectdownid;
	}
	public void setCollectdownid(Integer collectdownid) {
		this.collectdownid = collectdownid;
	}
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getCdstate() {
		return cdstate;
	}
	public void setCdstate(Integer cdstate) {
		this.cdstate = cdstate;
	}
	public CollectDownFile(Integer collectdownid, Integer fileid,
			Integer userid, Integer cdstate) {
		super();
		this.collectdownid = collectdownid;
		this.fileid = fileid;
		this.userid = userid;
		this.cdstate = cdstate;
	}
	public CollectDownFile() {
		super();
	}
	@Override
	public String toString() {
		return "CollectDownFile [collectdownid=" + collectdownid + ", fileid="
				+ fileid + ", userid=" + userid + ", cdstate=" + cdstate + "]";
	}
	
}
