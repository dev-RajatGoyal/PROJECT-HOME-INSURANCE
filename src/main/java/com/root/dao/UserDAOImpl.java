package com.root.dao;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.UserBean;
import com.root.entity.UserEntity;

public class UserDAOImpl implements UserDAO {

	public String insertUser(UserBean userBean) {
		
		EntityManager entityManager = null;
		
		String userName = null;
		try
		{	
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");		
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			UserEntity userEntity = new UserEntity();
			userEntity.setUser_name(userBean.getUsername());
			userEntity.setRole(userBean.getRole());
			userEntity.setPassword(userBean.getPassword());
			userEntity.setConfirmPassword(userBean.getCpassword());
			
			entityManager.persist(userEntity);
			entityManager.getTransaction().commit();
			
			System.out.println("insertUser success");
			userName = userEntity.getUser_name();
		}
		catch(Exception e)
		{
			System.out.println("something went wrong");
			e.printStackTrace();
		}
		finally
		{
			entityManager.close();
		}
		return userName;
	}
	
	public UserBean viewUserByUserId(int userId)
	{
		UserBean userBean=new UserBean();
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");	
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		UserEntity userEntity=entityManager.find(UserEntity.class, userId);
		
		userBean.setUser_id(userEntity.getUser_id());
		userBean.setUsername(userEntity.getUser_name());
		userBean.setRole(userEntity.getRole());
		userBean.setPassword(userEntity.getPassword());
		userBean.setCpassword(userEntity.getConfirmPassword());
		
		entityManager.getTransaction().commit();
		return userBean;
	}
}
