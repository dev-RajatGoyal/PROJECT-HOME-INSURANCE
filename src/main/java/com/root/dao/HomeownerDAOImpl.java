
package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.entity.HomeOwnerEntity;
import com.root.entity.UserEntity;
import com.root.objectConverter.ObjectConverter;

/**
 * @author Rajat Goyal
 *
 */
/**
 * @author Rajat Goyal
 *
 */
/**
 * @author Rajat Goyal
 *
 */
@Repository
public class HomeownerDAOImpl implements HomeownerDAO {
	static final Logger LOGGER = Logger.getLogger(HomeownerDAOImpl.class);

	/**
	 * This is a method for inserting Home Owner Details Here we use database
	 * connectivity for inserting details
	 */
	public int insertHomeOwner(HomeOwnerBean homeOwner) {

		EntityManager entityManager = null;

		/**
		 * Create Entity ManagerFactory Object for calling the unit calling unit where
		 * we define our database details for achieving JPA part
		 */

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();

			/**
			 * Calling ObjectConverter class ObjectConverter class created for convert
			 * Object Convert HomeOwnerBean object to HomeOwnerEntity
			 */

			ObjectConverter converter = new ObjectConverter();
			HomeOwnerEntity entity = converter.convertHomeBenasToEntity(homeOwner);

			UserBean user = homeOwner.getUser();
			UserEntity userEntity = new UserEntity();

			userEntity.setUser_id(user.getuserid());
			entity.setUser(userEntity);

			/**
			 * First we need to begin the transaction persist method is used for inserting
			 * details After persisting the details we need to commit otherwise it will not
			 * be reflect to database
			 */
			entityManager.getTransaction().begin();
			entityManager.persist(entity);
			entityManager.getTransaction().commit();
			LOGGER.info("Insert Home Owner Successfully");
		} catch (Exception e) {
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}

		}
		return 0;
	}
	
	/**
	 * This is a method for find HomeOwner by User Id
	 * Here we use database connectivity for inserting details
	 */
	public HomeOwnerBean findHomeownerByUserId(int userID) {
		EntityManager entityManager=null;
		HomeOwnerBean bean=null;
		
		try
		{
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("unit1");
			entityManager=entityManagerFactory.createEntityManager();
			
			
			HomeOwnerEntity homeOwner=(HomeOwnerEntity) entityManager.createQuery("from HomeOwnerEntity h where h.user.user_id = "+userID).getSingleResult();
			
			/**
			 * Calling ObjectConverter class ObjectConverter class created for convert
			 * Object Convert HomeOwnerEntity object to HomeOwnerBean
			 */
			ObjectConverter converter=new ObjectConverter();
			
			UserEntity userEntity=homeOwner.getUser();
			System.out.println("User Id"+userEntity.getUser_id());	
			
			bean=converter.convertHomeEntityToBean(homeOwner);	
			bean.setUser(converter.convertUserEntityToBean(userEntity));
			
			System.out.println("in dao home" + bean);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
			{
			if (entityManager != null) 
			{
				entityManager.close();
			}
				
			}
		/**
		 * Returning homeOwnerBean object after fetching from the database
		 */	
		return bean;
	}

}
