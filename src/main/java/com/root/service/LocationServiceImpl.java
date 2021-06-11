package com.root.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.dao.LocationDao;
import com.root.dao.LocationDaoImpl;

/**
 * This class is to interact with Controller
 * 
 * LocationServiceImpl will interact with LocationDaoImpl internally
 * 
 * This Service class is mainly works with BEAN objects
 */

@Service
public class LocationServiceImpl implements LocationService{
	static final Logger LOGGER = Logger.getLogger(LocationServiceImpl.class);

	/**
	 * AutoWiring LocationDaoIMPL object (it will create locationDaoImpl object automatically)
	 */
	@Autowired
	LocationDaoImpl locationDao;
	
	
	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call addLocationWithProperty method from dao layer internally store object in database
	 * 
	 */
	@Override
	public void addLocationWithProperty(LocationBean locationBean, PropertyBean propertyBean, UserBean userBean)
			throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Add Location with Property Method from LocationServiceImpl");
		locationDao.addLocationWithProperty(locationBean, propertyBean, userBean);
		
	}

	
	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call removeLoactionAndProperty method from dao layer internally to remove object in database
	 * 
	 */
	@Override
	public void removeLoactionAndProperty(LocationBean location) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Remove Location and Property Method from LocationServiceImpl");
		locationDao.removeLoactionAndProperty(location);
	}
	
	/**
	 * 	This method will be invoked from Controller to find the object which is stored in database
	 * 	
	 *  It will call findLocationByUserId method from dao layer internally to find the object from database
	 * 
	 */
	public LocationBean findLocationByUserId(int userId) throws ClassNotFoundException, SQLException {
		return locationDao.findLocationByUserId(userId);
		
	}

}