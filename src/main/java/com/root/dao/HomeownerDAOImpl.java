
package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.entity.HomeOwnerEntity;
import com.root.entity.UserEntity;
import com.root.objectConverter.ObjectConverter;
import com.root.service.UserServiceImpl;

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

}
