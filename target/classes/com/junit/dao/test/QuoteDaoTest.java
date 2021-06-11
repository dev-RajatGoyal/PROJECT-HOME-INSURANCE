package com.junit.dao.test;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.dao.QuoteDAO;
import com.root.dao.QuoteDAOImpl;
import com.root.service.QuoteService;
import com.root.service.QuoteServiceImpl;

public class QuoteDaoTest {
	



	
	private static QuoteDAO quotedao=null;
	private static LocationBean locatioBean=null;
	

	private static PropertyBean propertyBean=null;

	private static QuoteBean quoteBean=null;

	
	@BeforeAll
	public static void setup() {
		quotedao=new QuoteDAOImpl();
		//creating user bean && property bean , location bean  class object
		propertyBean=new PropertyBean();
		locatioBean=new LocationBean();
		quoteBean=new QuoteBean();
	
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
		locatioBean.setResidence_use("Single-Family Home");
		locatioBean.setZip_code("zipt");
		
		
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
	void addQuoteTest() throws ClassNotFoundException, SQLException{
		quotedao.addQuote(locatioBean, quoteBean);
	}
	@Test
	void findQuoteByIdTest() throws ClassNotFoundException, SQLException{
		quotedao.findQuoteById(10);
	}
	@Test
	void findQuoteByLocationIdTest()throws ClassNotFoundException, SQLException{
		quotedao.findQuoteByLocationId(10);
	}
	

	@AfterAll
	public static void closeSetup() {
		//nulllfy the homecontroller object
		quotedao=null;
	}



	

	



}
