package com.root.service;

import java.sql.SQLException;

import com.root.bean.PasswordBean;
import com.root.bean.UserBean;
import com.root.exception.InvalidEmailORUserIdException;

public interface UserService {

	String insertUser(UserBean userBean)  throws ClassNotFoundException,SQLException;
	UserBean viewUserByUserId(int userId)  throws ClassNotFoundException,SQLException;
	UserBean updatePassword(UserBean userBean) throws ClassNotFoundException, SQLException;
	PasswordBean updatePassword(PasswordBean pass) throws ClassNotFoundException, SQLException, InvalidEmailORUserIdException;
	boolean sendEmail(String subject, String message, String to);
	public PasswordBean submitotp(PasswordBean pass) throws ClassNotFoundException, SQLException ;
}
