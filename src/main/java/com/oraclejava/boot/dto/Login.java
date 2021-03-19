package com.oraclejava.boot.dto;

public class Login {
	private String id;
	private String password;
	private String loginType;	// 개인회원, 기업회원, 관리자
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLoginType() {
		return loginType;
	}
	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	
}
