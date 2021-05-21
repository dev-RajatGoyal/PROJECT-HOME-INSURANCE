package com.root.service;

import java.sql.SQLException;

import com.root.bean.UserBean;
import com.root.dao.UserDAO;
import com.root.dao.UserDAOImpl;

public class UserServiceImpl implements UserService
{

	UserDAO userDao = new UserDAOImpl();
	
	@Override
	public String insertUser(UserBean userBean) throws ClassNotFoundException, SQLException {
		
		return userDao.insertUser(userBean);
	}

	@Override
	public UserBean viewUserByUserId(int userId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
