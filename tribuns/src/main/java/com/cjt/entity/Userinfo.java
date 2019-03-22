package com.cjt.entity;

import java.sql.Date;

public class Userinfo {

	private String  userid;
	private String nickname;
	private String realName;
	private String phone;
	private String usepwd;
	private Integer sex;
	private Date birthday;
	private String curjob;
	private String selfdesc;
	private String pic;
	private Integer integral;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsepwd() {
		return usepwd;
	}
	public void setUsepwd(String usepwd) {
		this.usepwd = usepwd;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCurjob() {
		return curjob;
	}
	public void setCurjob(String curjob) {
		this.curjob = curjob;
	}
	public String getSelfdesc() {
		return selfdesc;
	}
	public void setSelfdesc(String selfdesc) {
		this.selfdesc = selfdesc;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", nickname=" + nickname
				+ ", realName=" + realName + ", phone=" + phone + ", usepwd="
				+ usepwd + ", sex=" + sex + ", birthday=" + birthday
				+ ", curjob=" + curjob + ", selfdesc=" + selfdesc + ", pic="
				+ pic + ", integral=" + integral + "]";
	}
	
	
	

}
