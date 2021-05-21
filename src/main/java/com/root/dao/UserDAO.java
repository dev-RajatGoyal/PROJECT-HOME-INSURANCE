package com.root.dao;

import java.sql.SQLException;

import com.root.bean.UserBean;
import com.root.entity.UserEntity;

public interface UserDAO {

	String insertUser(UserBean userBean)  throws ClassNotFoundException,SQLException;
	UserBean viewUserByUserId(int userId)  throws ClassNotFoundException,SQLException;
}
