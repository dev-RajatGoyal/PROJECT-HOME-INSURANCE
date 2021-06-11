package com.root.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * This is homeOwnerEntity class 
 * 
 * This entity class contains data member, getter setter methods
 * 
 * it contain annotations, these annotation create the table name(@Table), column name(@column), primarykey(@Id) etc
 * 
 * it is mainly used to JPA with the help of entity class user able to insert,update,delete data into database
 * 
 * Entity class mainly interact with the Dao layer
 */
@Entity
@Table(name="homeowner")
public class HomeOwnerEntity {
	static final Logger LOGGER = Logger.getLogger(HomeOwnerEntity.class);
	

	@Id
	private int ownerId;
	private String fname;
	private String lname;
	private Date dob;
	private String retired;
	private int socialSocietyNumber;
	private String email;
	
	@OneToOne
	private UserEntity user;
	
	

	public UserEntity getUser() {
		LOGGER.info("Inside the Home Owner Entity");
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

}
