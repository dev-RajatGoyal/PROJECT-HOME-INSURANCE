package com.junit.dao.test;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.root.bean.UserBean;
import com.root.dao.UserDAO;
import com.root.dao.UserDAOImpl;
import com.root.service.UserService;
import com.root.service.UserServiceImpl;

public class UserBeanDaoTest {
	private static UserDAO userdao=null;
	

	private static UserBean userBean=null;;

	
	@BeforeAll
	public static void setup() {
		userdao=new UserDAOImpl();
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
		userdao.insertUser(userBean);
	}
	@Test
	void viewUserByUserIdTest()  throws ClassNotFoundException,SQLException{
		userdao.viewUserByUserId(11);
	}
	@Test
	void updatePasswordTest() throws ClassNotFoundException, SQLException{
		userdao.updatePassword(userBean);
	}


	@AfterAll
	public static void closeSetup() {
		userdao=null;
	}



	

	





}
