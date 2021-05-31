package com.junit.service.test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
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
	private static UserService userService = null;
	private static QuoteService quoteService = null;
	private static PolicyService policyService=null;
	private static LocationService locationservice=null;
	private static HomeOwnerService homeOwnerservice=null;
	
	
	private static UserBean userBean=null;
	private static LocationBean locationBean=null;
	private static PolicyBean policyBean=null;
	private static PropertyBean propertyBean=null;
	private static QuoteBean quoteBean=null;
	private static HomeOwnerBean homeowner=null;
	
	private int userid;
	private String username;
	private String role;
	private String password;
	private String cpassword;
	private String email;

	@BeforeAll
	public static void setup() {
		hc=new HomeController();
		userBean=new UserBean();
		userService=new UserServiceImpl();
		quoteService=new QuoteServiceImpl();
		locationBean=new LocationBean();
		policyService=new PolicyServiceImpl();
		propertyBean=new PropertyBean();
		quoteBean=new QuoteBean();
		locationservice=new LocationServiceImpl();
		homeOwnerservice=new HomeOwnerServiceImpl();
		homeowner=new  HomeOwnerBean();
		
		
		
		quoteBean.setQuote_id(101);
		quoteBean.setAdd_living_exp(10.20f);
		quoteBean.setDeductible(15.02f);
		quoteBean.setAdd_living_exp(10.20f);
		quoteBean.setDetached_structures(525.0f);
		quoteBean.setDwelling_coverage(562.0f);
		quoteBean.setMedical_expense(56.30f);
		quoteBean.setMonthly_premium(5f);
		quoteBean.setPersonal_property(5.6f);
		
		
		
		userBean.setCpassword("arvind");
		userBean.setEmail("arvindv7238@gmail.com");
		userBean.setPassword("arvind");
		userBean.setRole("User");
		userBean.setuserid(1);
		userBean.setUsername("Arvind Verma ");
		userBean.setUserid(1010);
		//==============property beans 
		/*
		
		policyBean.setPolicyId(101);
		policyBean.setUser(userBean);
		policyBean.setEffectiveDate(new Date());
		policyBean.setEndDate(new Date());
		policyBean.setPolicyStatus("success");
		policyBean.setPolicyTerm(25);
		policyBean.setQuote(quoteBean);
		
		propertyBean.setDwelling_type("ABC");
		propertyBean.setFull_baths(101);
		propertyBean.setGarage_type("GCTY");
		propertyBean.setHalf_baths(5);
		propertyBean.setMarket_value(2);
		propertyBean.setPool(2);
		propertyBean.setProperty_id(10);
		propertyBean.setRoof_material("floor");
		propertyBean.setSquare_footage(1512);
		propertyBean.setYear_built(2020);
		
		
		locationBean.setLocation_id(10);
		locationBean.setAddress_line_1("jay");
		locationBean.setAddress_line_2("agara");
		locationBean.setCity("Ayodhya");
		locationBean.setLocation_state("UP");
		locationBean.setProperty(propertyBean);
		locationBean.setResidence_type("2 BHK");
		locationBean.setResidence_use("Single familty");
		locationBean.setZip_code("zipt");
		
		*/
		
	}
	@Test
	public  void showUserDashboardTest() throws ClassNotFoundException, SQLException {
			userService.viewUserByUserId(userBean.getuserid());
	}
	
	@Test
	public void showHomePageTest(){
		hc.showHomePage();
	}
	
	@Test
	public void  insertUserTest() throws ClassNotFoundException, SQLException {
		userService.insertUser(userBean);
	}
	@Test
	public void updatePasswordTest() throws ClassNotFoundException, SQLException {
		userService.updatePassword(userBean);
	}
	
	
	
//	//==========================for quoteServie imple ========================
	
	/*
	@Test
	public void addQuoteTest(){
		System.out.println(quoteService+"------------------");
		try {
			quoteService.addQuote(locationBean.getLocation_id());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	*/
//	================================================================
	@Test
	 public void buyPolicyTest() throws ClassNotFoundException, SQLException{
		 policyService.buyPolicy(policyBean, userBean, quoteBean);
	 }
	
	
	
	@Test
	public void addLocationWithPropertyTest() throws ClassNotFoundException, SQLException{
		locationservice.addLocationWithProperty(locationBean, propertyBean, userBean);
	}
	@Test
	public void removeLoactionAndPropertyTest() throws ClassNotFoundException, SQLException{
		locationservice.removeLoactionAndProperty(locationBean);
	}

	@Test
	public void insertHomeOwnerTest() {
		homeOwnerservice.insertHomeOwner(homeowner);
	}
	
	
	
	
	@AfterAll
	public static void closeSetup() {
		HomeController hc=null;
		UserService userService = null;
		UserBean userBean=null;
		quoteService=null;
		
	}
}