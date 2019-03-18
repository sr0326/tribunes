package com.sr.entity;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	private String userId;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", nickname=" + nickname
				+ ", realName=" + realName + ", phone=" + phone + ", usepwd="
				+ usepwd + ", sex=" + sex + ", birthday=" + birthday
				+ ", curjob=" + curjob + ", selfdesc=" + selfdesc + ", pic="
				+ pic + ", integral=" + integral + "]";
	}
	public UserInfo(String userId, String nickname, String realName,
			String phone, String usepwd, Integer sex, Date birthday,
			String curjob, String selfdesc, String pic, Integer integral) {
		super();
		this.userId = userId;
		this.nickname = nickname;
		this.realName = realName;
		this.phone = phone;
		this.usepwd = usepwd;
		this.sex = sex;
		this.birthday = birthday;
		this.curjob = curjob;
		this.selfdesc = selfdesc;
		this.pic = pic;
		this.integral = integral;
	}
	
	
}
