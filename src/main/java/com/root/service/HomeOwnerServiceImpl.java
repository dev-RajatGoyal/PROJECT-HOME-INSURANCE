package com.root.service;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;

public class HomeOwnerServiceImpl implements HomeOwnerService {
	HomeownerDAO homeownerDao=new HomeownerDAOImpl();
	@Override
	public void insertHomeOwner(HomeOwnerBean homeOwner, UserBean user) {
		
		homeownerDao.insertHomeOwner(homeOwner, user);
	}

}
