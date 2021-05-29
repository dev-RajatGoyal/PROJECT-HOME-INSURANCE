package com.root.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="quotes")
public class QuoteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int quote_id;
	
	@OneToOne
	private LocationEntity locationEntity;
	
	private float monthly_premium;
	private float dwelling_coverage;
	private float detached_structures;
	private float personal_property;
	private float add_living_exp;
	private float medical_expense;
	private float deductible;
	
	
	public int getQuote_id() {
		return quote_id;
	}
	public void setQuote_id(int quote_id) {
		this.quote_id = quote_id;
	}
	public LocationEntity getLocationEntity() {
		return locationEntity;
	}
	public void setLocationEntity(LocationEntity locationEntity) {
		this.locationEntity = locationEntity;
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
	
	
}
