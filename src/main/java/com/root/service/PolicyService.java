package com.root.service;
import java.sql.SQLException;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;


public interface PolicyService {
  public void buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException;
 //void renewPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException;
// void viewPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException;
  PolicyBean viewPolicy(int policyId) throws ClassNotFoundException, SQLException;
	void canclePoicy(int policyId) throws ClassNotFoundException,SQLException;
}
