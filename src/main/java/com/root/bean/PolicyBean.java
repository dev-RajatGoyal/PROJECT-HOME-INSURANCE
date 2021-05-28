package com.root.bean;
import java.util.Date;

public class PolicyBean {
	private int policyId;
	private QuoteBean quote;
	private UserBean user;
	private Date effectiveDate;
	private Date endDate;
	private int policyTerm;
	private String policyStatus;

	

	public QuoteBean getQuote() {
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



	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
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