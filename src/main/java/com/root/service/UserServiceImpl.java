package com.root.service;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.root.bean.UserBean;
import com.root.dao.UserDAO;
import com.root.dao.UserDAOImpl;

public class UserServiceImpl implements UserService
{
	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	UserDAO userDao = new UserDAOImpl();

	@Override
	public String insertUser(UserBean userBean) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Insert User Method from UserServiceImpl");
		return userDao.insertUser(userBean);
	}

	@Override
	public UserBean viewUserByUserId(int userId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside View User By ID Method from UserServiceImpl");
		return userDao.viewUserByUserId(userId);
	}

	@Override
	public UserBean updatePassword(UserBean userBean) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Update Password Method from UserServiceImpl");
		return userDao.updatePassword(userBean);
	}

}
