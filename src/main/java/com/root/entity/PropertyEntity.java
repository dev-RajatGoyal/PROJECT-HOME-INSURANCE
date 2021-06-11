package com.root.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * This is PropertyEntity class 
 * 
 * This entity class contains data member, getter setter methods
 * 
 * it contain annotations, these annotation create the table name(@Table), column name(@column), primarykey(@Id) etc
 * 
 * it is mainly used to JPA with the help of entity class user able to insert,update,delete data into database
 * 
 * Entity class mainly interact with the Dao layer
 */
@Entity
@Table(name = "property")
public class PropertyEntity {
	static final Logger LOGGER = Logger.getLogger(PropertyEntity.class);
	@Id
	private int property_id;
	private int market_value;
	private int year_built;
	private int square_footage;
	private String dwelling_type;
	private String roof_material;
	private String garage_type;
	private int full_baths;
	private int half_baths;
	private int pool;
	
	public int getProperty_id() {
		LOGGER.info("Inside the Property Entity");
		return property_id;
	}
	public void setProperty_id(int property_id) {
		this.property_id = property_id;
	}
	public int getMarket_value() {
		return market_value;
	}
	public void setMarket_value(int market_value) {
		this.market_value = market_value;
	}
	public int getYear_built() {
		return year_built;
	}
	public void setYear_built(int year_built) {
		this.year_built = year_built;
	}
	public int getSquare_footage() {
		return square_footage;
	}
	public void setSquare_footage(int square_footage) {
		this.square_footage = square_footage;
	}
	public String getDwelling_type() {
		return dwelling_type;
	}
	public void setDwelling_type(String dwelling_type) {
		this.dwelling_type = dwelling_type;
	}
	public String getRoof_material() {
		return roof_material;
	}
	public void setRoof_material(String roof_material) {
		this.roof_material = roof_material;
	}
	public String getGarage_type() {
		return garage_type;
	}
	public void setGarage_type(String garage_type) {
		this.garage_type = garage_type;
	}
	public int getFull_baths() {
		return full_baths;
	}
	public void setFull_baths(int full_baths) {
		this.full_baths = full_baths;
	}
	public int getHalf_baths() {
		return half_baths;
	}
	public void setHalf_baths(int half_baths) {
		this.half_baths = half_baths;
	}
	public int getPool() {
		return pool;
	}
	public void setPool(int pool) {
		this.pool = pool;
	}



}
