package com.junit.service.test;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.root.bean.UserBean;
import com.root.service.UserService;
import com.root.service.UserServiceImpl;

public class UserServiceTest {



	
	private static UserService userservice=null;
	

	private static UserBean userBean=null;;

	
	@BeforeAll
	public static void setup() {
		userservice=new UserServiceImpl();
		//creating user bean && property bean , location bean  class object
		userBean=new UserBean();
		
		userBean.setCpassword("Arvind");
		userBean.setPassword("Arvind");
		userBean.setEmail("arvindv7238@gmail.com");
		userBean.setRole("user");
		userBean.setUserid(11);
		userBean.setUsername("Arvind Verma");

	}
	

	@Test
	void insertUserTest()  throws ClassNotFoundException,SQLException{
		userservice.insertUser(userBean);
	}
	@Test
	void viewUserByUserIdTest()  throws ClassNotFoundException,SQLException{
		userservice.viewUserByUserId(11);
	}
	@Test
	void updatePasswordTest() throws ClassNotFoundException, SQLException{
		userservice.updatePassword(userBean);
	}


	@AfterAll
	public static void closeSetup() {
		
	}



	

	



}
