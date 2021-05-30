package com.root.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.dao.LocationDao;
import com.root.dao.LocationDaoImpl;

public class LocationServiceImpl implements LocationService{
	static final Logger LOGGER = Logger.getLogger(LocationServiceImpl.class);

	LocationDao locationDao = new LocationDaoImpl();
	@Override
	public void addLocationWithProperty(LocationBean locationBean, PropertyBean propertyBean, UserBean userBean)
			throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Add Location with Property Method from LocationServiceImpl");
		locationDao.addLocationWithProperty(locationBean, propertyBean, userBean);
		
	}

	@Override
	public void removeLoactionAndProperty(LocationBean location) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Remove Location and Property Method from LocationServiceImpl");
		locationDao.removeLoactionAndProperty(location);
	}

}
