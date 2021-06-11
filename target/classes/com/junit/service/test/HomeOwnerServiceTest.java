 package com.junit.service.test;

import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.controller.HomeController;
import com.root.service.HomeOwnerService;
import com.root.service.HomeOwnerServiceImpl;

public class HomeOwnerServiceTest {

	private static HomeOwnerService ho=null;
	
	
	
// bean class
	
	private static HomeOwnerBean hob=null;
	private static UserBean ub=null;
	
	@BeforeAll
	public static void setup() {
		ho=new HomeOwnerServiceImpl();
		ub=new UserBean();
		//creating bean class object
		
		ub.setCpassword("Arvind");
		ub.setPassword("Arvind");
		ub.setEmail("arvindv7238@gmail.com");
		ub.setRole("user");
		ub.setUserid(11);
		ub.setUsername("Arvind Verma");

		//creating homeownerbean class object
		hob=new HomeOwnerBean();
		hob.setDob(new Date());
		hob.setFname("Arvind");
		hob.setLname("Verma");
		hob.setEmail("arvindv7238@gmail.com");
		hob.setOwnerId(1010);
		hob.setRetired("Yes");
		hob.setUser(ub);
	}
	
	@Test
	public void insertHomeOwnerTest() {
		ho.insertHomeOwner(hob);
	}
	@Test
	public void findHomeownerByUserIdTest() {
		ho.findHomeownerByUserId(1010);
	}
	@AfterAll
	public static void closeSetup() {
		//nulllfy the homecontroller object
		ho=null;
		hob=null;
	}


}
