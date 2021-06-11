package com.root.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.bean.HomeOwnerBean;
import com.root.dao.HomeownerDAOImpl;
/**
 * This class is to interact with Controller
 * 
 * HomeOwnerServiceImpl will interact with HomeownerDaoImpl internally
 * 
 * This Service class is mainly works with BEAN objects
 */
@Service
public class HomeOwnerServiceImpl implements HomeOwnerService {
	static final Logger LOGGER = Logger.getLogger(HomeOwnerServiceImpl.class);

	//@Autowired
	/**
	 * create homeownerDAO class object for calling the method of DAOImpl
	 */
	HomeownerDAOImpl homeownerDao = new HomeownerDAOImpl();
	
	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call insertHomeOwner method from dao layer internally store object in database
	 * 
	 */
	public int insertHomeOwner(HomeOwnerBean homeOwner) {
		LOGGER.info("Inside Insert Home Owner Method from HomeOwnerServiceImpl");
		return homeownerDao.insertHomeOwner(homeOwner);

	}

	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call findHomeownerByUserId method from dao layer internally find data from database
	 * 
	 */
	@Override
	public HomeOwnerBean findHomeownerByUserId(int id) {
		System.out.println(id);
		HomeOwnerBean home = homeownerDao.findHomeownerByUserId(id);
		return home;
		
	}
}