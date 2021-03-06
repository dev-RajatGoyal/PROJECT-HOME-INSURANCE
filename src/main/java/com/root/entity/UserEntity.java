package com.root.entity;

import javax.persistence.Column;
//import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * This is UserEntity class 
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
@Table(name="user")
public class UserEntity {
	static final Logger LOGGER = Logger.getLogger(UserEntity.class);
	
	@Id
	private int user_id;
	@Column(unique = true)
	private String user_name;
	private String role;
	private String password;
	private String confirmPassword;
	private String email;
	
	public UserEntity() {
		
	}
	public int getUser_id() {
		LOGGER.info("Inside the User Entity");
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "UserEntity [user_id=" + user_id + ", user_name=" + user_name + ", role=" + role + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", email=" + email + "]";
	}

}
