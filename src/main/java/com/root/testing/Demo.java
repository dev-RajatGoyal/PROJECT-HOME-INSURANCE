package com.root.testing;

import java.sql.SQLException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.entity.HomeOwnerEntity;
import com.root.entity.UserEntity;

public class Demo {

	  public static void main(String[] args) throws ClassNotFoundException, SQLException {
		  
		/*
		 * UserEntity user = new UserEntity();
		 * 
		 * user.setUser_id(456); user.setUser_name("mrry12"); user.setRole("admin");
		 * user.setPassword("rehan@123"); user.setConfirmPassword("rehan@123");
		 * 
		 * LocationBean l = new LocationBean(); PropertyBean p = new PropertyBean();
		 * 
		 * l.setAddress_line_1("atttt"); l.setLocation_id(12);
		 * 
		 * p.setProperty_id(13); p.setHalf_baths(12);
		 * 
		 * 
		 * 
		 * LocationServiceImpl service = new LocationServiceImpl(); service.
		 * addLocationWithProperty(l,p,user);
		 */
		  
		  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		
		 
			
			HomeOwnerEntity homeOwnerBean = new HomeOwnerEntity();
			
			UserEntity userBean = new UserEntity();
			
			userBean.setUser_id(10012);
			userBean.setUser_name("rehnse");
			userBean.setPassword("reha@121");
			userBean.setRole("admin1");
			
			
			homeOwnerBean.setOwnerId(101);
			homeOwnerBean.setFname("rajat");
			homeOwnerBean.setLname("Goyal");
			homeOwnerBean.setDob(new Date());
			homeOwnerBean.setRetired("Yes");
			homeOwnerBean.setSocialSocietyNumber(1001);
			homeOwnerBean.setEmail("rajat2001@gmail.com");
			
			homeOwnerBean.setUserEntity(userBean);
			
			
			
			entityManager.getTransaction().begin();

			entityManager.persist(userBean);
			
			System.out.println(userBean);
			System.out.println(homeOwnerBean);
			
			entityManager.persist(homeOwnerBean);
			entityManager.getTransaction().commit();
			
		/*
		 * userBean.setUsername("rohini"); userBean.setRole("user");
		 * userBean.setPassword("rohini123"); userBean.setCpassword("rohini123");
		 */
		/*
		 * HomeOwnerService homeOwnerService = new HomeOwnerServiceImpl();
		 * 
		 * homeOwnerService.insertHomeOwner(homeOwnerBean, userBean);
		 */
			
	}
}
