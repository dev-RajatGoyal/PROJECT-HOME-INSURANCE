package com.root.service;

import java.sql.SQLException;

import com.root.bean.UserBean;

public interface UserService {

	String insertUser(UserBean userBean)  throws ClassNotFoundException,SQLException;
	UserBean viewUserByUserId(int userId)  throws ClassNotFoundException,SQLException;
}
