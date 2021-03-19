package com.oraclejava.boot.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="USERINFO")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberGenerator")
	@SequenceGenerator(name = "memberGenerator",sequenceName = "userno" ,allocationSize = 1)
	@Column(name = "USERNO")
	private Integer userNo;
	
	@Column(name = "USERID")
	private String userId;
	
	@Column(name = "USERPASS")
	private String userPass;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "EMAIL")
	private String email;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Column(name = "WRITEDATE")
	private Date writeDate;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	@Override
	public String toString() {
		return "Member [userNo=" + userNo + ", userId=" + userId + ", userPass=" + userPass + ", userName=" + userName
				+ ", email=" + email + ", writeDate=" + writeDate + "]";
	}
	
}
