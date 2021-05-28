package com.root.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Location")
public class LocationEntity {

	@Id
	private int location_id ;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="property_id", unique=true)
	private PropertyEntity propertyEntity ;
	
	@OneToOne
	private UserEntity userEntity;
	
	private String residence_type;
	private String address_line_1;
	private String address_line_2;
	private String city;
	private String location_state ;
	private String zip_code ;
	private String residence_use ;
	
	
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
     
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public PropertyEntity getPropertyEntity() {
		return propertyEntity;
	}
	public void setPropertyEntity(PropertyEntity propertyEntity) {
		this.propertyEntity = propertyEntity;
	}
	public String getResidence_type() {
		return residence_type;
	}
	public void setResidence_type(String residence_type) {
		this.residence_type = residence_type;
	}
	public String getAddress_line_1() {
		return address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation_state() {
		return location_state;
	}
	public void setLocation_state(String location_state) {
		this.location_state = location_state;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getResidence_use() {
		return residence_use;
	}
	public void setResidence_use(String residence_use) {
		this.residence_use = residence_use;
	}
	
}
