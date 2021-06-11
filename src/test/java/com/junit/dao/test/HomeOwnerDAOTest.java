package com.junit.dao.test;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;

public class HomeOwnerDAOTest {
	
	

	private static HomeownerDAO homeOwnerDao=null;
	
	
	
// bean class

	private static UserBean userBean=null;
	private static HomeOwnerBean homeownerbean=null;
	
	@BeforeAll
	public static void setup() {
		homeOwnerDao=new HomeownerDAOImpl();
		//creating bean class object
		userBean=new UserBean();
		userBean.setCpassword("Arvind");
		userBean.setPassword("Arvind");
		userBean.setEmail("arvindv7238@gmail.com");
		userBean.setRole("user");
		userBean.setUserid(11);
		userBean.setUsername("Arvind Verma");
		
		homeownerbean=new HomeOwnerBean();
		//creating homeownerbean class object
		homeownerbean=new HomeOwnerBean();
		homeownerbean.setDob(new Date());
		homeownerbean.setFname("Arvind");
		homeownerbean.setLname("Verma");
		homeownerbean.setEmail("arvindv7238@gmail.com");
		homeownerbean.setOwnerId(1010);
		homeownerbean.setRetired("Yes");
		homeownerbean.setUser(userBean);
	}
	@Test
	void insertHomeOwnerTest() {
		homeOwnerDao.insertHomeOwner(homeownerbean);
	}
	@Test
	public void findHomeownerByUserIdTest() {
		homeOwnerDao.findHomeownerByUserId(1010);
	}
	
	
	@AfterAll
	public static void closeSetup() {
		//nulllfy the homecontroller object
		
		homeOwnerDao=null;
		userBean=null;
	}

	

}
