package com.sr.entity;

import java.io.Serializable;
import java.util.Date;

public class DownResource implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer downid;
	private Integer fileid;
	private String userid;
	private Date downtime;
	private String downurl;
	private DownFile df;
	public Integer getDownid() {
		return downid;
	}
	public void setDownid(Integer downid) {
		this.downid = downid;
	}
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getDowntime() {
		return downtime;
	}
	public void setDowntime(Date downtime) {
		this.downtime = downtime;
	}
	public String getDownurl() {
		return downurl;
	}
	public void setDownurl(String downurl) {
		this.downurl = downurl;
	}
	public DownFile getDf() {
		return df;
	}
	public void setDf(DownFile df) {
		this.df = df;
	}
	public DownResource() {
		super();
	}
	public DownResource(Integer downid, Integer fileid, String userid,
			Date downtime, String downurl, DownFile df) {
		super();
		this.downid = downid;
		this.fileid = fileid;
		this.userid = userid;
		this.downtime = downtime;
		this.downurl = downurl;
		this.df = df;
	}
	@Override
	public String toString() {
		return "DownResource [downid=" + downid + ", fileid=" + fileid
				+ ", userid=" + userid + ", downtime=" + downtime
				+ ", downurl=" + downurl + ", df=" + df + "]";
	}
	
}
