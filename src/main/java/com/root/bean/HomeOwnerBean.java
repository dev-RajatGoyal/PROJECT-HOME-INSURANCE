package com.root.bean;

import java.util.Date;

public class HomeOwnerBean {

	private int ownerId;
	private String fname;
	private String lname;
	private Date dob;
	private String retired;
	private int socialSocietyNumber;
	private String email;
	
	
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