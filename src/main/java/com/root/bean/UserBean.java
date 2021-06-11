package com.root.bean;

import org.apache.log4j.Logger;

/**
 * This is UserBean class 
 * 
 * This bean class contains data member, constructor, getter setter methods and toString() method
 * 
 * it contain spring validation by using some annotation like:- @Range, @Size, @NotNull etc
 * 
 * Bean class mainly interact with the Service Layer
 */
public class UserBean {
	static final Logger LOGGER = Logger.getLogger(UserBean.class);
	private int userid;
	private String username;
	private String role;
	private String password;
	private String cpassword;
	private String email;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public int getuserid() {
		LOGGER.info("Inside the User Bean");
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

	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserBean [userid=" + userid + ", username=" + username + ", role=" + role + ", password=" + password
				+ ", cpassword=" + cpassword + ", email=" + email + "]";
	}

	
}
