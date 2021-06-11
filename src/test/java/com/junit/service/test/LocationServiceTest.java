package com.junit.service.test;

import java.sql.SQLException;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.service.HomeOwnerService;
import com.root.service.HomeOwnerServiceImpl;
import com.root.service.LocationService;
import com.root.service.LocationServiceImpl;

public class LocationServiceTest {

	
	private static LocationService locationService=null;
	
	
	
// bean class

	private static UserBean userBean=null;
	private static LocationBean locatioBean=null;
	private static PropertyBean propertyBean=null;
	
	@BeforeAll
	public static void setup() {
		locationService=new LocationServiceImpl();
		//creating user bean && property bean , location bean  class object
		userBean=new UserBean();
		propertyBean=new PropertyBean();
		locatioBean=new LocationBean();
		
		
		userBean.setCpassword("Arvind");
		userBean.setPassword("Arvind");
		userBean.setEmail("arvindv7238@gmail.com");
		userBean.setRole("user");
		userBean.setUserid(11);
		userBean.setUsername("Arvind Verma");

		propertyBean.setProperty_id(1010);
		propertyBean.setDwelling_type("Dwellings");
		propertyBean.setFull_baths(25);
		propertyBean.setGarage_type("dustiblem");
		propertyBean.setHalf_baths(100);
		propertyBean.setMarket_value(50);
		propertyBean.setPool(451);
		propertyBean.setRoof_material("Solid");
		propertyBean.setSquare_footage(12);
		propertyBean.setYear_built(2020);
		
		locatioBean.setLocation_id(10);
		locatioBean.setAddress_line_1("jay");
		locatioBean.setAddress_line_2("agara");
		locatioBean.setCity("Ayodhya");
		locatioBean.setLocation_state("UP");
		locatioBean.setProperty(propertyBean);
		locatioBean.setResidence_type("2 BHK");
		locatioBean.setResidence_use("Single familty");
		locatioBean.setZip_code("zipt");
		
	}
	

	@Test
	public void addLocationWithProperty() throws ClassNotFoundException, SQLException{
		locationService.addLocationWithProperty(locatioBean, propertyBean, userBean);
	}
	@Test
	public void removeLoactionAndProperty() throws ClassNotFoundException, SQLException{
		locationService.removeLoactionAndProperty(locatioBean);
		
	}
	@Test
	public void findLocationByUserId() throws ClassNotFoundException, SQLException{
		locationService.findLocationByUserId(10);
	}

	@AfterAll
	public static void closeSetup() {
		//nulllfy the homecontroller object
		locationService=null;
		userBean=null;
	}



	
}
