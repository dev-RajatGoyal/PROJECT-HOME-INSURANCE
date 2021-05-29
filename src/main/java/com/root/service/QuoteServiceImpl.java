package com.root.service;

import java.sql.SQLException;

import com.root.bean.LocationBean;
import com.root.bean.QuoteBean;
import com.root.dao.LocationDao;
import com.root.dao.LocationDaoImpl;
import com.root.dao.QuoteDAO;
import com.root.dao.QuoteDAOImpl;
import com.root.entity.PropertyEntity;

public class QuoteServiceImpl implements QuoteService {

	private QuoteDAO quoteDao = new QuoteDAOImpl();

	LocationDao locationDao = new LocationDaoImpl();

	public int addQuote(int locationId) throws ClassNotFoundException, SQLException {

		LocationBean locationBean = locationDao.findLocationByLocationId(locationId);
		
		System.out.println("test location in quoteService"+locationBean);
        System.out.println(locationBean.getProperty().getProperty_id());
		
		QuoteBean quoteBean = new QuoteBean();

		float FamilyYearlyPremium = 0;
		float FamilyMonthlyPremium = 0;

		PropertyEntity propertyEntity = new PropertyEntity();

		float coverage = locationBean.getProperty().getMarket_value();

		// quoteBean.setLocation_id(locationBean.getLocation_id());

		float annualPremium = 0;

		//quoteBean.setLocation_id(locationBean.getLocation_id());

		String residenceType = locationBean.getResidence_type();

		if (residenceType.equalsIgnoreCase("Single-Family Home")) {
			annualPremium = (float) (coverage * 0.005);
			System.out.println("Single Family Home Annual Premium   " + annualPremium);
		} else if (residenceType.equals("Condo") || residenceType.equals("Duplex")
				|| residenceType.equals("Apartment")) {
			annualPremium = (float) (coverage * 0.006);
			System.out.println("Condo Family  " + annualPremium);
		} else if (residenceType.equalsIgnoreCase("Townhouse") || residenceType.equalsIgnoreCase("Row House")) {
			annualPremium = (float) (coverage * 0.007);
			System.out.println("Townhouse Family  " + annualPremium);
		} else {
			System.out.println("Residence Type did not match.....");
		}

		float monthlyPremium = annualPremium / 12;
		quoteBean.setMonthly_premium(monthlyPremium);

		// ---------------------------- business logic for dwelling
		// coverage------------------------------

		float squareFeet = locationBean.getProperty().getSquare_footage();
		float buildYear = locationBean.getProperty().getYear_built();
		// float dwellingCoverage=120*squareFeet;

		float homeValue = 0;
		if (buildYear < 5) {
			homeValue = (float) (coverage - 0.1 * coverage);
			System.out.println("Build Year less than 5 Year " + homeValue);
		} else if (buildYear <= 5 || buildYear < 10) {
			homeValue = (float) (coverage - 0.2 * coverage);
			System.out.println("Build Year equal to 5 and less than 10  " + homeValue);
		} else if (buildYear <= 10 || buildYear < 20) {
			homeValue = (float) (coverage - 0.3 * coverage);
			System.out.println("Build Year equal to 10  and less than 20   " + homeValue);
		} else if (buildYear > 20) {
			homeValue = (float) (coverage - 0.5 * coverage);
			System.out.println("Build Year more than 20  " + homeValue);
		}

		coverage = (float) (coverage * 0.5);
		float dwellingCoverage1 = coverage + homeValue;

		System.out.println("final dwelling coverage   " + dwellingCoverage1);
		System.out.println("Dwelling Coverage 50% of market Value   " + coverage);

		quoteBean.setDwelling_coverage(dwellingCoverage1);

		// ------------------------- business logic for Detached
		// Structures------------------------------

		float detachedStructure = (float) (dwellingCoverage1 * 0.10);
		System.out.println("Detached Structure   " + detachedStructure);
		quoteBean.setDetached_structures(detachedStructure);

		// -------------------------- business logic for Personal
		// property--------------------------------

		float personalProperty = (float) (dwellingCoverage1 * 0.60);
		System.out.println("Personal Property   " + personalProperty);
		quoteBean.setPersonal_property(personalProperty);

		// ---------------------------business logic for Additional
		// living--------------------------------

		float additionalLiving = (float) (dwellingCoverage1 * 0.20);
		System.out.println("Additional Living   " + additionalLiving);
		quoteBean.setAdd_living_exp(additionalLiving);

		// -------------------------- business logic for Medical
		// Expense---------------------------------

		float medicalExpense = 5000;

		System.out.println("Medical Expense    " + medicalExpense);

		// -------------------------- business logic for deductible
		// ---------------------------------------

		float deductible = (float) ((float) coverage * 0.01);
		quoteBean.setDeductible(deductible);

		System.out.println("Deductible = " + deductible);
		quoteBean.setMedical_expense(medicalExpense);

		int id =quoteDao.addQuote(locationBean, quoteBean);
		
		return id;

	}

}