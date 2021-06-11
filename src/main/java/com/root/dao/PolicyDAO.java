package com.root.dao;
import java.sql.SQLException; 
import java.util.List;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
public interface PolicyDAO {

	int buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException;
	void renewPolicy(PolicyBean policyBean) throws ClassNotFoundException, SQLException;
	PolicyBean viewPolicy(int policyId) throws ClassNotFoundException, SQLException;
	void canclePoicy(int policyId) throws ClassNotFoundException,SQLException;

	List<PolicyBean> viewAllPolicy() throws ClassNotFoundException,SQLException;
	public PolicyBean viewPolicyByUserId(int userId) throws ClassNotFoundException, SQLException;

}


