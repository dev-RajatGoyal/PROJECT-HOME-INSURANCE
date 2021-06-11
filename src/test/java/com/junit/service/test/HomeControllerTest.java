package com.junit.service.test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpRequest;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PolicyBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.controller.HomeController;
import com.root.service.HomeOwnerService;
import com.root.service.HomeOwnerServiceImpl;
import com.root.service.LocationService;
import com.root.service.LocationServiceImpl;
import com.root.service.PolicyService;
import com.root.service.PolicyServiceImpl;
import com.root.service.QuoteService;
import com.root.service.QuoteServiceImpl;
import com.root.service.UserService;
import com.root.service.UserServiceImpl;

public class HomeControllerTest {
	private static HomeController hc=null;
	
	
	
// bean class
	
	private static UserBean ub=null;
	
	@BeforeAll
	public static void setup() {
		hc=new HomeController();
		
		//creating bean class object
		ub=new UserBean();
		ub.setCpassword("Arvind");
		ub.setPassword("Arvind");
		ub.setEmail("arvindv7238@gmail.com");
		ub.setRole("user");
		ub.setUserid(11);
		ub.setUsername("Arvind Verma");
	}
	
	@Test
	public void  showHomePageTest() {
		//calling homecontroller class showhomepage methods object
		hc.showHomePage();
	}
	@Test
	public void  AdminLoginTest() {
		//calling homecontroller AdminLogin methods object
		hc.AdminLogin();
	}
	
	@Test
	public void updatePassword() {
		//calling homecontroller updatePassword methods 
		hc.updatePassword();
		;
	}
	
	
	
	
	@AfterAll
	public static void closeSetup() {
		//nulllfy the homecontroller object
		hc=null;
	}
}