package com.root.dao;

import java.sql.SQLException;

import com.root.bean.PasswordBean;
import com.root.bean.UserBean;
import com.root.exception.InvalidEmailORUserIdException;

public interface UserDAO {

	String insertUser(UserBean userBean)  throws ClassNotFoundException,SQLException;
	UserBean viewUserByUserId(int userId)  throws ClassNotFoundException,SQLException;
	UserBean updatePassword(UserBean up) throws ClassNotFoundException,SQLException;
	PasswordBean updatePassword(PasswordBean pass) throws ClassNotFoundException,SQLException, InvalidEmailORUserIdException;
	PasswordBean submitOTP(PasswordBean pass);
}
