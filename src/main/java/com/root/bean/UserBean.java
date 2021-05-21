package com.root.bean;

public class UserBean {

	private int user_id;
	
	private String username;
	private String role;
	private String password;
	private String cpassword;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
		return "UserBean [user_id=" + user_id + ", username=" + username + ", role=" + role + ", password=" + password
				+ ", cpassword=" + cpassword + "]";
	}

	
	
}
