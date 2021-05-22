package com.root.bean;

public class UserBean {

	private int userid;
	private String username;
	private String role;
	private String password;
	private String cpassword;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public int getuserid() {
		return userid;
	}

	public void setuserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	@Override
	public String toString() {
		return "UserBean [userid=" + userid + ", username=" + username + ", role=" + role + ", password=" + password
				+ ", cpassword=" + cpassword + "]";
	}

	
	
}
