package com.root.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DummyEntity {
	
	@Id
	private int id;
	
	private String name;
	
	public DummyEntity() {
		// TODO Auto-generated constructor stub
	}
}
