package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.UserBean;
import com.root.entity.UserEntity;
import com.root.objectConverter.*;

public class UserDAOImpl implements UserDAO {

	public String insertUser(UserBean userBean) {
		
		EntityManager entityManager = null;

		String userName = null;
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			UserEntity userEntity = new UserEntity();
			userEntity.setUser_id(userBean.getUserid());
			userEntity.setUser_name(userBean.getUsername());
			userEntity.setRole(userBean.getRole());
			userEntity.setPassword(userBean.getPassword());
			userEntity.setConfirmPassword(userBean.getCpassword());
			userEntity.setEmail(userBean.getEmail());
			
			entityManager.persist(userEntity);
			entityManager.getTransaction().commit();

			System.out.println("insertUser success");
			userName = userEntity.getUser_name();
		} catch (Exception e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
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
			userBean.setEmail(userEntity.getEmail());
			
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
	
	
	public UserBean updatePassword(UserBean up) {
		EntityManager entityManager = null;
		UserBean bean = null;

		ObjectConverter converter = new ObjectConverter();

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			UserEntity entity = (UserEntity) entityManager.find(UserEntity.class, up.getUserid());
		
			if(entity!=null) {
				
				entity.setUser_id(up.getUserid());
				entity.setEmail(up.getEmail());
				entity.setPassword(up.getRole());
				entity.setConfirmPassword(up.getRole());
				
				bean = converter.convertUserEntityToBean(entity);
				entityManager.persist(entity);
				entityManager.getTransaction().commit();

			}else {
				System.out.println("No recored ");
			}
			
		} catch (Exception e) {
			System.out.println("something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		return bean;
	}

}
