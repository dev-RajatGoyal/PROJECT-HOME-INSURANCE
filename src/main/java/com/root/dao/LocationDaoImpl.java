package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.entity.LocationEntity;
import com.root.entity.PropertyEntity;
import com.root.entity.UserEntity;
import com.root.objectConverter.ObjectConverter;

public class LocationDaoImpl implements LocationDao {

	
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

		} catch (Exception e) {
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

		} catch (Exception e) {
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
		    UserEntity user = entity.getUserEntity();
		    PropertyEntity property = entity.getPropertyEntity();
		
		    PropertyBean propertyBean =converter.convertPropertyEntityToBean(property);
		    UserBean userBean=converter.convertUserEntityToBean(user);
		    
			bean = converter.convertLocationEntityToBean(entity);
			bean.setUser(userBean);
			bean.setProperty(propertyBean);
		}
		catch(Exception e)
		{
			throw e;
		}finally
		{
			if (entityManager != null)
			{
				entityManager.close();
			}
		}
		return bean;
		
	}

}
