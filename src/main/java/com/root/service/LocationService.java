package com.root.service;

import java.sql.SQLException;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.entity.UserEntity;

public interface LocationService {

	void addLocationWithProperty(LocationBean locationBean,PropertyBean propertyBean,UserBean userBean) throws ClassNotFoundException, SQLException;
	public void removeLoactionAndProperty(LocationBean location) throws ClassNotFoundException, SQLException;
	public LocationBean findLocationByUserId(int userId) throws ClassNotFoundException, SQLException;

}
