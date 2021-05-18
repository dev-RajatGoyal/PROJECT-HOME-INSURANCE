package com.root.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class HomeOwner {

	
	private int user;
	private String first_name;
	private String last_name;
	
	//@Temporal(TemporalType.DATE)
	private Date date;
	private int retired_status;
	private String ssn;
	private String email;
	
}
