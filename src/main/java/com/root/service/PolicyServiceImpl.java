package com.root.service;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.bean.PolicyBean;
import com.root.bean.UserBean;
import com.root.bean.QuoteBean;
import com.root.dao.PolicyDAOImpl;

/**
 * This class is to interact with Controller 
 * PolicyServiceImpl will interact with PolicyDAOImpl internally
 * This Service class is mainly works with BEAN objects
 */
@Service
public class PolicyServiceImpl implements PolicyService {
	static final Logger LOGGER = Logger.getLogger(PolicyServiceImpl.class);

	/**
	 * AutoWiring PolicyDAOImpl object (it will create PolicyDAOImpl object automatically)
	 */
	PolicyDAOImpl policyDao = new PolicyDAOImpl();

	
	/**
	 * 	This method will be invoked from Controller to generate the policy schemes 
	 *  It will call buyPolicy method from dao layer internally to store calculated policy details  in database
	 */
	public int buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Buy Policy Method from PolicyServiceImpl");
		return policyDao.buyPolicy(policyBean,userBean,quoteBean);
	}

	
	/**
	 * 	This method will be invoked from Controller to view the policy schemes to the user 
	 *  It will call viewPolicy method from dao layer internally to fetch calculated policy details  from database
	 */
	@Override
	public PolicyBean viewPolicy(int policyId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside View Policy Method from PolicyServiceImpl");
		return policyDao.viewPolicy(policyId);
	}

	
	/**
	 * 	This method will be invoked from Controller to cancel the policy schemes as per User request
	 *  It will call canclePoicy method from dao layer internally to remove policy details from database
	 */
	@Override
	public void canclePoicy(int policyId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Cancle Policy Method from PolicyServiceImpl");
		policyDao.canclePoicy(policyId);
	}


	

	/**
	 * 	This method will be invoked from Controller to show all the policy details to admin 
	 *  It will call viewAllPolicy method from dao layer internally to fetch all policy details from database
	 */
	@Override
	public List<PolicyBean> viewAllPolicy() throws ClassNotFoundException, SQLException {
		
		return policyDao.viewAllPolicy();
	}

	
	
	/**
	 * 	This method will be invoked from Controller to renew the policy as per User Request
	 *  It will call renewPolicy method from dao layer internally to renew the  policy 
	 */
	@Override
	public void renewPolicy(int id) throws ClassNotFoundException, SQLException {
		
		  PolicyBean policy =policyDao.viewPolicy(id);
		    
		    if(policy != null)
		    {
		     policyDao.renewPolicy(policy);
		    }else
		    {
		    	System.out.println("id not found");
		    }
	}

	
	/**
	 * 	This method will be invoked from Controller to fetch all the policy details as per Admin Request
	 *  It will call viewPolicyByUserId method from dao layer internally to retrieve all the policy details
	 */
	@Override
	public PolicyBean viewPolicyByUserId(int userId) throws ClassNotFoundException, SQLException {
		
		return policyDao.viewPolicyByUserId(userId);
	}
}