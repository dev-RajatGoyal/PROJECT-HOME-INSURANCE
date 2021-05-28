package com.root.service;
import java.sql.SQLException;
import com.root.bean.LocationBean;
import com.root.bean.PolicyBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.bean.QuoteBean;
import com.root.dao.PolicyDAO;
import com.root.dao.PolicyDAOImpl;
import com.root.entity.UserEntity;

public class PolicyServiceImpl implements PolicyService {

	PolicyDAO pldao=new  PolicyDAOImpl();

	public void buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean) throws ClassNotFoundException, SQLException {
		pldao.buyPolicy(policyBean,userBean,quoteBean);
	}
}

