package com.root.service;

import java.sql.SQLException;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.dao.LocationDao;
import com.root.dao.LocationDaoImpl;

public class LocationServiceImpl implements LocationService{

	LocationDao locationDao = new LocationDaoImpl();
	@Override
	public void addLocationWithProperty(LocationBean locationBean, PropertyBean propertyBean, UserBean userBean)
			throws ClassNotFoundException, SQLException {
		
		locationDao.addLocationWithProperty(locationBean, propertyBean, userBean);
		
	}

	@Override
	public void removeLoactionAndProperty(LocationBean location) throws ClassNotFoundException, SQLException {
		
		locationDao.removeLoactionAndProperty(location);
	}

}
