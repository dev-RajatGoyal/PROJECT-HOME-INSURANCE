package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.entity.HomeOwnerEntity;
import com.root.entity.UserEntity;
import com.root.service.UserServiceImpl;

public class HomeownerDAOImpl implements HomeownerDAO {

	
	public void insertHomeOwner(HomeOwnerBean homeOwnerBean, UserBean userBean) {
		EntityManager entityManager=null;
		try
		{
		HomeOwnerEntity homeOwnerEntity=new HomeOwnerEntity();
		UserEntity userEntity = new UserEntity();
			
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		entityManager = entityManagerFactory.createEntityManager();
		
		userEntity.setUser_id(userBean.getuserid());
		userEntity.setUser_name(userBean.getUsername());
		userEntity.setRole(userBean.getRole());
		userEntity.setPassword(userBean.getPassword());
		userEntity.setConfirmPassword(userBean.getCpassword());
		
		
		UserServiceImpl impl = new UserServiceImpl();
		impl.insertUser(userBean);
		
		homeOwnerEntity.setOwnerId(homeOwnerBean.getOwnerId());
		homeOwnerEntity.setFname(homeOwnerBean.getFname());
		homeOwnerEntity.setLname(homeOwnerBean.getLname());
		homeOwnerEntity.setDob(homeOwnerBean.getDob());
		homeOwnerEntity.setRetired(homeOwnerBean.getRetired());
		homeOwnerEntity.setSocialSocietyNumber(homeOwnerBean.getSocialSocietyNumber());
		homeOwnerEntity.setEmail(homeOwnerBean.getEmail());
		
	
		homeOwnerEntity.setUserEntity(userEntity);
		
		System.out.println(userBean);
		System.out.println(homeOwnerBean);
		
		entityManager.getTransaction().begin();
		entityManager.persist(homeOwnerEntity);
		entityManager.getTransaction().commit();
		
		
		System.out.println("Home Owner Insert Successfully");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (entityManager != null) {
				entityManager.close();
			}
		}
	
		
		
	}

}
