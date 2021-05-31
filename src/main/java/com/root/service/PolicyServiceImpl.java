package com.root.service;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.root.bean.LocationBean;
import com.root.bean.PolicyBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.bean.QuoteBean;
import com.root.dao.PolicyDAO;
import com.root.dao.PolicyDAOImpl;
import com.root.entity.UserEntity;

public class PolicyServiceImpl implements PolicyService {
	static final Logger LOGGER = Logger.getLogger(PolicyServiceImpl.class);

	PolicyDAO policyDao = new  PolicyDAOImpl();

	public void buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Buy Policy Method from PolicyServiceImpl");
		policyDao.buyPolicy(policyBean,userBean,quoteBean);
	}

	@Override
	public PolicyBean viewPolicy(int policyId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside View Policy Method from PolicyServiceImpl");
		return policyDao.viewPolicy(policyId);
	}

	@Override
	public void canclePoicy(int policyId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Cancle Policy Method from PolicyServiceImpl");
		policyDao.canclePoicy(policyId);
	}
}

