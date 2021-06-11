package com.junit.service.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.service.PolicyService;
import com.root.service.PolicyServiceImpl;



public class PolicyServiceTest {
	
	


	
	private static PolicyService policyService=null;
	
	
	
// bean class

	private static UserBean userBean=null;
	private static PolicyBean policyBean=null;
	private static QuoteBean quoteBean=null;
	
	@BeforeAll
	public static void setup() {
		policyService=new PolicyServiceImpl();
		//creating user bean && property bean , location bean  class object
		userBean=new UserBean();
		policyBean=new PolicyBean();
		quoteBean=new QuoteBean()
				;
		
		userBean.setCpassword("Arvind");
		userBean.setPassword("Arvind");
		userBean.setEmail("arvindv7238@gmail.com");
		userBean.setRole("user");
		userBean.setUserid(11);
		userBean.setUsername("Arvind Verma");

		policyBean.setPolicyId(101);
		policyBean.setUser(userBean);
		policyBean.setEffectiveDate("12-Aug-2020");
		policyBean.setEndDate("15-SEP-2013");
		policyBean.setPolicyStatus("success");
		policyBean.setPolicyTerm(25);
		policyBean.setQuote(quoteBean);
		
		
		quoteBean.setQuote_id(101);
		quoteBean.setAdd_living_exp(10.20f);
		quoteBean.setDeductible(15.02f);
		quoteBean.setAdd_living_exp(10.20f);
		quoteBean.setDetached_structures(525.0f);
		quoteBean.setDwelling_coverage(562.0f);
		quoteBean.setMedical_expense(56.30f);
		quoteBean.setMonthly_premium(5f);
		quoteBean.setPersonal_property(5.6f);
		
	}
	
	@Test
	void buyPolicyTest() throws ClassNotFoundException, SQLException{
		policyService.buyPolicy(policyBean, userBean, quoteBean);
		
	}
	@Test
	void viewPolicyTest() throws ClassNotFoundException, SQLException{
		policyService.viewPolicy(1010);
	}
	@Test
	void canclePoicy() throws ClassNotFoundException,SQLException{
		policyService.canclePoicy(101);
	}
	@Test
	void viewAllPolicy() throws ClassNotFoundException,SQLException{
		policyService.viewAllPolicy();
	}
	@Test
	void renewPolicy() throws ClassNotFoundException, SQLException{
		policyService.renewPolicy(101);
	}

	@AfterAll
	public static void closeSetup() {
		//nulllfy the homecontroller object
		
	}



	


}
