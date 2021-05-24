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
			userEntity.setUser_id(userBean.getuserid());
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
			if(entityManager!=null)
			{
				entityManager.close();
			}
		}
		return userName;
	}
	
	public UserBean viewUserByUserId(int userId)
	{
		UserBean userBean=new UserBean();
		EntityManager entityManager = null;
		try
		{
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");	
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			UserEntity userEntity=entityManager.find(UserEntity.class, userId);
			
			userBean.setuserid(userEntity.getUser_id());
			userBean.setUsername(userEntity.getUser_name());
			userBean.setRole(userEntity.getRole());
			userBean.setPassword(userEntity.getPassword());
			userBean.setCpassword(userEntity.getConfirmPassword());
			
			entityManager.getTransaction().commit();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(entityManager!=null)
			{
				entityManager.close();
			}
		}
			return userBean;
	}

}
