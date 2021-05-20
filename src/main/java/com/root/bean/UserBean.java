package com.root.bean;

public class UserBean {

	private int user_id;
	
	private String user_name;
	private String role;
	private String password;
	private String confirmPassword;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public UserBean(int user_id, String user_name, String password, String role) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.password = password;
		this.role = role;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", password=" + password + ", role=" + role
				+ "]";
	}
	
	
}
