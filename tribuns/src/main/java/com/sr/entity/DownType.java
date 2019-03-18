package com.sr.entity;

import java.io.Serializable;

public class DownType implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer downtypeid;
	private String downtypeName;
	public Integer getDowntypeid() {
		return downtypeid;
	}
	public void setDowntypeid(Integer downtypeid) {
		this.downtypeid = downtypeid;
	}
	public String getDowntypeName() {
		return downtypeName;
	}
	public void setDowntypeName(String downtypeName) {
		this.downtypeName = downtypeName;
	}
	public DownType(Integer downtypeid, String downtypeName) {
		super();
		this.downtypeid = downtypeid;
		this.downtypeName = downtypeName;
	}
	public DownType() {
		super();
	}
	@Override
	public String toString() {
		return "DownType [downtypeid=" + downtypeid + ", downtypeName="
				+ downtypeName + "]";
	}
	
}
