package com.oraclejava.boot.dto;

import java.util.Date;

public class MemberVO {
	
	private Integer userNo;
	private String userId;
	private String userPass;
	private String userName;
	private Date writeDate;
	private String email;
	
	
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Override
	public String toString() {
		return "Join [userNo=" + userNo + ", userId=" + userId + ", userPass=" + userPass + ", userName=" + userName
				+ ", writeDate=" + writeDate + ", email=" + email + "]";
	}
	
}
