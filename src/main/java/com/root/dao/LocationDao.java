package com.root.dao;

import java.sql.SQLException;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;

public interface LocationDao {
	
	void addLocationWithProperty(LocationBean locationBean,PropertyBean propertyBean,UserBean user) throws ClassNotFoundException, SQLException;
	public void removeLoactionAndProperty(LocationBean location) throws ClassNotFoundException, SQLException;
	public LocationBean findLocationByLocationId(int LocationId) throws ClassNotFoundException, SQLException;

}
