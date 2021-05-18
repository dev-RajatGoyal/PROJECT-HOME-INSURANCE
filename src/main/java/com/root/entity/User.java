package com.root.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	@Column(unique = true, nullable = false)
	private String user_name;
	
	@Column(unique = true, nullable = false)
	private String password;
	
	@Column(nullable = false, columnDefinition = "user")
	private String admin_role;

}
