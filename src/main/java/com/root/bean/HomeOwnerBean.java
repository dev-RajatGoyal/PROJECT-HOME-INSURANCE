package com.root.bean;

import java.util.Date;

import javax.validation.constraints.Size;

import org.apache.log4j.Logger;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import com.sun.istack.NotNull;

/**
 * This is homeOwnerBean class 
 * 
 * This bean class contains data member, constructor, getter setter methods and toString() method
 * 
 * it contain spring validation by using some annotation like:- @Range, @Size, @NotNull etc
 * 
 * Bean class mainly interact with the Service Layer
 */
public class HomeOwnerBean {
	static final Logger LOGGER = Logger.getLogger(HomeOwnerBean.class);

	@Range(min=100,max=200,message="* it should be between 100-200")
	private int ownerId;
	
	@Size(max=10,min=2)
	private String fname;
	
	private String lname;
	
	@NotNull
	private Date dob;
	
	@NotEmpty
	private String retired;
	
	@NotNull
	private int socialSocietyNumber;
	
	@NotEmpty
	private String email;
	
	private UserBean user;
	
	
	public UserBean getUser() {
		LOGGER.info("Inside the Home Owner Bean");
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public HomeOwnerBean() {
		// TODO Auto-generated constructor stub
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getRetired() {
		return retired;
	}

	public void setRetired(String retired) {
		this.retired = retired;
	}

	public int getSocialSocietyNumber() {
		return socialSocietyNumber;
	}

	public void setSocialSocietyNumber(int socialSocietyNumber) {
		this.socialSocietyNumber = socialSocietyNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "HomeOwner [ownerId=" + ownerId + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob + ", retired="
				+ retired + ", socialSocietyNumber=" + socialSocietyNumber + ", email=" + email + "]";
	}

}
