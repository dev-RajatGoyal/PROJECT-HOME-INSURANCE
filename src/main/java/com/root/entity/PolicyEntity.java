package com.root.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;

/**
 * This is PolicyEntity class 
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
@Table(name="policy")
public class PolicyEntity {
	static final Logger LOGGER = Logger.getLogger(PolicyEntity.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int policy_id;
	private String effective_date;
	private String end_date;
	private int term;
	private String policy_status;

	@OneToOne
	private UserEntity userEntity;
	@OneToOne
	private QuoteEntity quoteEntity;
	
	
	
	public QuoteEntity getQuoteEntity() {
		LOGGER.info("Inside the Policy Entity");
		return quoteEntity;
	}

	public void setQuoteEntity(QuoteEntity quoteEntity) {
		this.quoteEntity = quoteEntity;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getPolicy_status() {
		return policy_status;
	}

	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}
	
	/**
	 * @return the policy_id
	 */
	public int getPolicy_id() {
		return policy_id;
	}

	/**
	 * @param policy_id the policy_id to set
	 */
	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}


	/**
	 * @return the effective_date
	 */
	public String getEffective_date() {
		return effective_date;
	}

	/**
	 * @param effective_date the effective_date to set
	 */
	public void setEffective_date(String effective_date) {
		this.effective_date = effective_date;
	}

	/**
	 * @return the end_date
	 */
	public String getEnd_date() {
		return end_date;
	}

	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	/**
	 * @return the term
	 */
	public int getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(int term) {
		this.term = term;
	}

}
