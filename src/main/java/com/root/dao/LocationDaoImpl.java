package com.root.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.entity.LocationEntity;
import com.root.entity.PropertyEntity;
import com.root.entity.UserEntity;
import com.root.objectConverter.ObjectConverter;


/**
 * @author Rehan Ansari
 *
 */
/**
 * @author Rehan Ansari
 *
 */
/**
 * @author Rehan Ansari
 *
 */
@Repository
public class LocationDaoImpl implements LocationDao {
	static final Logger LOGGER = Logger.getLogger(LocationDaoImpl.class);
	
	/**
	 * This is a method for inserting Location and property Details together
	 * Here we use database connectivity for inserting details
	 */
	public void addLocationWithProperty(LocationBean locationBean, PropertyBean propertyBean, UserBean userBean) {

		EntityManager entityManager = null;

		try {
			

			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();

			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
			 * to entity to use database
			 */

			ObjectConverter converter = new ObjectConverter();

			/**
			 * convert propertyBean object to propertyEntity because we need to give entity
			 * object to our database
			 */
			PropertyEntity propertyEntity = converter.convertPropertyBeanToEntity(propertyBean);

			/**
			 * convert LocationBean object to LocationEntity because we need to give entity
			 * object to our database
			 */

			LocationEntity locationEntity = converter.convertLocationBeansToEntity(locationBean);

			/**
			 * convert UserBean object to UserEntity because we need to give entity object
			 * to our database
			 */
			UserEntity userEntity = converter.convertUserBeansToEntity(userBean);

			/**
			 * Set PropertyEntity object to LocationEntity because it is foreign key in
			 * location table Set UserEntity object to LocationEntity because it is foreign
			 * key in location table
			 */
			locationEntity.setPropertyEntity(propertyEntity);
			locationEntity.setUserEntity(userEntity);

			/**
			 * First we need to begin the transaction persist method is used for inserting
			 * details After persisting the details we need to commit otherwise it will not
			 * be reflect to database
			 */
			entityManager.getTransaction().begin();
			entityManager.persist(locationEntity);
			entityManager.getTransaction().commit();
			LOGGER.info("Add Location With Property");
		} catch (Exception e) {
			LOGGER.info("Something went wrong");
			System.out.println(e);

		} finally {

			if (entityManager != null) {
				entityManager.close();
			}

		}

	}

	
	
	/**
	 * removeLoactionAndProperty is a method for Removing Location and property
	 */
	public void removeLoactionAndProperty(LocationBean location) {

		EntityManager entityManager = null;
		int id = 0;
		try {
			
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();

			entityManager.getTransaction().begin();

			/**
			 * getLocationId what we need to delete find details from database which we need
			 * to delete
			 * 
			 */
			id = location.getLocation_id();
			LocationEntity locationEntity = entityManager.find(LocationEntity.class, id);

			entityManager.remove(locationEntity);
			entityManager.getTransaction().commit();
			LOGGER.info("Remove Loaction And Property");

		} catch (Exception e) {
			LOGGER.info("Something went wrong");
			throw e;

		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}
	
	
	/**
	 * This is a method for finding Location details
	 */
	public LocationBean findLocationByLocationId(int LocationId)
	{
		EntityManager entityManager = null;
		LocationBean bean = null;

		try {
			
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			
			/**
			 * First we need to begin the transaction persist method is used for inserting
			 * details After persisting the details we need to commit otherwise it will not
			 * be reflect to database
			 */
			entityManager.getTransaction().begin();
			LocationEntity entity =entityManager.find(LocationEntity.class,LocationId);
			entityManager.getTransaction().commit();
			
			
			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
			 * to entity to use database
			 */

			ObjectConverter converter = new ObjectConverter();

			/**
			 * convert LocationEntity object to LocationBean
			 */
			System.out.println("*****"+entity+" entity from locationDAO");
		    UserEntity user =entity.getUserEntity();
		    PropertyEntity property = entity.getPropertyEntity();
		
		    PropertyBean propertyBean =converter.convertPropertyEntityToBean(property);
		    UserBean userBean=converter.convertUserEntityToBean(user);
		    
			bean = converter.convertLocationEntityToBean(entity);
			bean.setUser(userBean);
			bean.setProperty(propertyBean);
			LOGGER.info("Find Location By Location Id");
		}
		catch(Exception e)
		{
			LOGGER.info("Something went wrong");
			throw e;
		}finally
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
		}
		/**
		 * Returning locationBean object after fetching from the database
		 */	
		return bean;
		
	}
	
	
	
	
	
	
	
   /**
    * 	findLocationByUserId method used for find location by userId
    */

	public LocationBean findLocationByUserId(int userId) throws ClassNotFoundException, SQLException {
		
		EntityManager entityManager = null;
		LocationBean bean = null;
		try
		{

			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			
			LocationEntity location = (LocationEntity) entityManager.createQuery("from LocationEntity l where  l.userEntity.user_id = "+userId).getSingleResult();
			
			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
			 * to entity to use database
			 */
			ObjectConverter converter = new ObjectConverter();
			
			/**
			 * convert LocationEntity object to LocationBean 
			 */
			UserEntity userEntity = location.getUserEntity();
			PropertyEntity propertyEntity = location.getPropertyEntity();

			bean = converter.convertLocationEntityToBean(location);
			bean.setUser(converter.convertUserEntityToBean(userEntity));
			bean.setProperty(converter.convertPropertyEntityToBean(propertyEntity));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			entityManager.close();
		}
		/**
		 * Returning locationBean object after fetching from the database
		 */	
		return bean;
	}

}