package com.root.bean;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * This is PolicyBean class 
 * 
 * This bean class contains data member, constructor, getter setter methods and toString() method
 * 
 * it contain spring validation by using some annotation like:- @Range, @Size, @NotNull etc
 * 
 * Bean class mainly interact with the Service Layer
 */
public class PolicyBean {
	static final Logger LOGGER = Logger.getLogger(PolicyBean.class);
	private int policyId;
	private QuoteBean quote;
	private UserBean user;
	private String effectiveDate;
	private String endDate;
	private int policyTerm;
	private String policyStatus;

	

	public QuoteBean getQuote() {
		LOGGER.info("Inside the Policy Bean");
		return quote;
	}

	public void setQuote(QuoteBean quote) {
		this.quote = quote;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}



	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	@Override
	public String toString() {
		return "PolicyBean [policyId=" + policyId + ", quote=" + quote + ", user=" + user + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate + ", policyTerm=" + policyTerm + ", policyStatus="
				+ policyStatus + "]";
	}

}