package com.ubaid.jtech.userService.entity;

public class AuthUser {
	private String email;
	private String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AuthUser(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public AuthUser() {
		super();
	}
	@Override
	public String toString() {
		return "AuthUser [email=" + email + ", password=" + password + "]";
	}


}
