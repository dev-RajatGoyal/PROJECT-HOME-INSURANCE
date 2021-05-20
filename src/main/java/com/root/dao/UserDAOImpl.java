package com.root.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.UserBean;
import com.root.entity.UserEntity;

public class UserDAOImpl implements UserDAO {

	public int insertUser(UserEntity userEntity) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(userEntity);
		entityManager.getTransaction().commit();
		
		return 0;

	}
	public UserBean viewUserByUserId(int userId)
	{
		UserBean userBean=new UserBean();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");	
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		userBean.setUser_id(userEntity.getUser_id());
		userBean.setUser_name(userEntity.getUser_name());
		userBean.setRole(userEntity.getRole());
		userBean.setPassword(userEntity.getPassword());
		userBean.setConfirmPassword(userEntity.getConfirmPassword());
		
		
		entityManager.getTransaction().commit();
		return userBean;
	}
}
