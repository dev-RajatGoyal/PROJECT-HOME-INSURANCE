package com.root.bean;

import org.apache.log4j.Logger;

public class LocationBean {
	static final Logger LOGGER = Logger.getLogger(LocationBean.class);

	private int location_id ;
	private String residence_type;
	private String address_line_1;
	private String address_line_2;
	private String city;
	private String location_state ;
	private String zip_code ;
	private String residence_use ;
	
	
	private UserBean user;
	private PropertyBean property;
	
	
	public UserBean getUser() {
		LOGGER.info("Inside the Location Bean");
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public PropertyBean getProperty() {
		return property;
	}
	public void setProperty(PropertyBean property) {
		this.property = property;
	}
	public int getLocation_id() {
		return location_id;
	}
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
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
	@Override
	public String toString() {
		return "LocationBean [location_id=" + location_id + ", residence_type=" + residence_type + ", address_line_1="
				+ address_line_1 + ", address_line_2=" + address_line_2 + ", city=" + city + ", location_state="
				+ location_state + ", zip_code=" + zip_code + ", residence_use=" + residence_use + "]";
	}
	
	
	

}
