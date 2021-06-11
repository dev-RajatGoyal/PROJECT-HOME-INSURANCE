package com.root.bean;

import org.apache.log4j.Logger;

/**
 * This is QuoteBean class 
 * 
 * This bean class contains data member, constructor, getter setter methods and toString() method
 * 
 * it contain spring validation by using some annotation like:- @Range, @Size, @NotNull etc
 * 
 * Bean class mainly interact with the Service Layer
 */
public class QuoteBean {
	static final Logger LOGGER = Logger.getLogger(QuoteBean.class);
	private int quote_id;
	private float monthly_premium;
	private float dwelling_coverage;
	private float detached_structures;
	private float personal_property;
	private float add_living_exp;
	private float medical_expense;
	private float deductible;
	
	private LocationBean location_id;
	
	public int getQuote_id() {
		LOGGER.info("Inside the Quote Bean");
		return quote_id;
	}
	public void setQuote_id(int quote_id) {
		this.quote_id = quote_id;
	}

	public LocationBean getLocation_id() {
		return location_id;
	}
	public void setLocation_id(LocationBean location_id) {
		this.location_id = location_id;
	}
	public float getMonthly_premium() {
		return monthly_premium;
	}
	public void setMonthly_premium(float monthly_premium) {
		this.monthly_premium = monthly_premium;
	}
	public float getDwelling_coverage() {
		return dwelling_coverage;
	}
	public void setDwelling_coverage(float dwelling_coverage) {
		this.dwelling_coverage = dwelling_coverage;
	}
	public float getDetached_structures() {
		return detached_structures;
	}
	public void setDetached_structures(float detached_structures) {
		this.detached_structures = detached_structures;
	}
	public float getPersonal_property() {
		return personal_property;
	}
	public void setPersonal_property(float personal_property) {
		this.personal_property = personal_property;
	}
	public float getAdd_living_exp() {
		return add_living_exp;
	}
	public void setAdd_living_exp(float add_living_exp) {
		this.add_living_exp = add_living_exp;
	}
	public float getMedical_expense() {
		return medical_expense;
	}
	public void setMedical_expense(float medical_expense) {
		this.medical_expense = medical_expense;
	}
	public float getDeductible() {
		return deductible;
	}
	public void setDeductible(float deductible) {
		this.deductible = deductible;
	}
	@Override
	public String toString() {
		return "QuoteBean [quote_id=" + quote_id + ", location_id=" + location_id + ", monthly_premium="
				+ monthly_premium + ", dwelling_coverage=" + dwelling_coverage + ", detached_structures="
				+ detached_structures + ", personal_property=" + personal_property + ", add_living_exp="
				+ add_living_exp + ", medical_expense=" + medical_expense + ", deductible=" + deductible + "]";
	}
	
	
	
}