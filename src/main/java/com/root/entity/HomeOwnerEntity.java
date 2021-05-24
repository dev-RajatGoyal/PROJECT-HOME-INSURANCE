package com.root.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="homeOwnerDetails")
public class HomeOwnerEntity {
	
	@Id
	private int ownerId;
	
	@Column(name="first_name")
	private String fname;
	
	@Column(name="last_name")
	private String lname;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dob;

	@Column(name="are you retired")
	private String retired;
	
	@Column(name="Social_Society_Number")
	private int socialSocietyNumber;
	
	@Column(name="email")
	private String email;
	

	@OneToOne

	private UserEntity userEntity;

	public HomeOwnerEntity() {
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


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}


	@Override
	public String toString() {
		return "HomeOwnerEntity [ownerId=" + ownerId + ", fname=" + fname + ", lname=" + lname + ", dob=" + dob
				+ ", retired=" + retired + ", socialSocietyNumber=" + socialSocietyNumber + ", email=" + email
				+ ", userEntity=" + userEntity + "]";
	}

	
}