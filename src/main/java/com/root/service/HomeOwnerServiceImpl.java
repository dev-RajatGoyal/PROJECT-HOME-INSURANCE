
package com.root.service;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;

public class HomeOwnerServiceImpl implements HomeOwnerService {
	HomeownerDAO homeownerDao = new HomeownerDAOImpl();

	public int insertHomeOwner(HomeOwnerBean homeOwner)
  {
      return homeownerDao.insertHomeOwner(homeOwner);
  
  }
}
