package com.sr.entity;

import java.io.Serializable;
import java.util.Date;

public class DownFile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer fileId;
	private String fileName;
	private Integer downtypeid;
	private Integer filetype;
	private String userid;
	private Date uploadtime;
	private String fileDis;
	private Integer downtime;
	private Integer filesize;
	private Integer need_score;
	private String url;
	private Integer upfilestate;//0全部,1已通过,2待审核,3未通过,4已删除
	//多对一
	private UserInfo uindo;
	private DownType dtype;
	
	public UserInfo getUindo() {
		return uindo;
	}
	public void setUindo(UserInfo uindo) {
		this.uindo = uindo;
	}
	public DownType getDtype() {
		return dtype;
	}
	public void setDtype(DownType dtype) {
		this.dtype = dtype;
	}
	public Integer getFileId() {
		return fileId;
	}
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getDowntypeid() {
		return downtypeid;
	}
	public void setDowntypeid(Integer downtypeid) {
		this.downtypeid = downtypeid;
	}
	public Integer getFiletype() {
		return filetype;
	}
	public void setFiletype(Integer filetype) {
		this.filetype = filetype;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getFileDis() {
		return fileDis;
	}
	public void setFileDis(String fileDis) {
		this.fileDis = fileDis;
	}
	public Integer getDowntime() {
		return downtime;
	}
	public void setDowntime(Integer downtime) {
		this.downtime = downtime;
	}
	public Integer getFilesize() {
		return filesize;
	}
	public void setFilesize(Integer filesize) {
		this.filesize = filesize;
	}
	public Integer getNeed_score() {
		return need_score;
	}
	public void setNeed_score(Integer need_score) {
		this.need_score = need_score;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getUpfilestate() {
		return upfilestate;
	}
	public void setUpfilestate(Integer upfilestate) {
		this.upfilestate = upfilestate;
	}
	public DownFile() {
		super();
	}
	public DownFile(Integer fileId, String fileName, Integer downtypeid,
			Integer filetype, String userid, Date uploadtime, String fileDis,
			Integer downtime, Integer filesize, Integer need_score, String url,
			Integer upfilestate, UserInfo uindo, DownType dtype) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.downtypeid = downtypeid;
		this.filetype = filetype;
		this.userid = userid;
		this.uploadtime = uploadtime;
		this.fileDis = fileDis;
		this.downtime = downtime;
		this.filesize = filesize;
		this.need_score = need_score;
		this.url = url;
		this.upfilestate = upfilestate;
		this.uindo = uindo;
		this.dtype = dtype;
	}
	@Override
	public String toString() {
		return "DownFile [fileId=" + fileId + ", fileName=" + fileName
				+ ", downtypeid=" + downtypeid + ", filetype=" + filetype
				+ ", userid=" + userid + ", uploadtime=" + uploadtime
				+ ", fileDis=" + fileDis + ", downtime=" + downtime
				+ ", filesize=" + filesize + ", need_score=" + need_score
				+ ", url=" + url + ", upfilestate=" + upfilestate + ", uindo="
				+ uindo + ", dtype=" + dtype + "]";
	}
	
}
