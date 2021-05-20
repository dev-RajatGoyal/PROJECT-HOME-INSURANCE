package com.root.dao;

import com.root.bean.UserBean;
import com.root.entity.UserEntity;

public interface UserDAO {

	int insertUser(UserEntity userEntity);
	UserBean viewUserByUserId(int userId);
}
