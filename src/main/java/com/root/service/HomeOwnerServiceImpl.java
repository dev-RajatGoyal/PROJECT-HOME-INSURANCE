
package com.root.service;

import org.apache.log4j.Logger;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;

public class HomeOwnerServiceImpl implements HomeOwnerService {
	static final Logger LOGGER = Logger.getLogger(HomeOwnerServiceImpl.class);
	HomeownerDAO homeownerDao = new HomeownerDAOImpl();

	public int insertHomeOwner(HomeOwnerBean homeOwner)
  {
		LOGGER.info("Inside Insert Home Owner Method from HomeOwnerServiceImpl");
      return homeownerDao.insertHomeOwner(homeOwner);
  
  }
}
