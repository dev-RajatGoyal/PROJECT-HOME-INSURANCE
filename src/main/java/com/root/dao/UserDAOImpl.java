package com.root.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.root.bean.PasswordBean;
import com.root.bean.UserBean;
import com.root.entity.UserEntity;
import com.root.exception.InvalidEmailORUserIdException;
import com.root.objectConverter.ObjectConverter;

/**
 * UserDAOImpl class to perform all the 
 * CRUD operations
 *
 */
@Repository
public class UserDAOImpl implements UserDAO {
	static final Logger LOGGER = Logger.getLogger(UserDAOImpl.class);

	
	/**
	 * This method is to insert user details in the database
	 */
	
	public String insertUser(UserBean userBean) {
		
		EntityManager entityManager = null;

		String userName = null;
		try {
			
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */	
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			/**
			 * Creating UserEntity object and 
			 * 
			 * Converting userBean object into UserEntity object
			 * 
			 * Setting userBean data members in userEntity
			 */
						
			UserEntity userEntity = new UserEntity();
			userEntity.setUser_id(userBean.getUserid());
			userEntity.setUser_name(userBean.getUsername());
			userEntity.setRole(userBean.getRole());
			userEntity.setPassword(userBean.getPassword());
			userEntity.setConfirmPassword(userBean.getCpassword());
			userEntity.setEmail(userBean.getEmail());
			
			/**
			 * persisting the userEntity in database and committing the transaction
			 */
			entityManager.persist(userEntity);
			entityManager.getTransaction().commit();
			LOGGER.info("insertUser success");
			
			userName = userEntity.getUser_name();
		} catch (Exception e) {
			LOGGER.info("something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		/**
		 * Returning the userBean object after persisting in the database
		 */	
		return userName;
	}
	
	
	
	/**
	 * This method is to fetching the user details from the database with the help of UserID
	 */	
	public UserBean viewUserByUserId(int userId)
	{
		/**
		 * Creating UserBean Object
		 */	
		UserBean userBean=null;
		EntityManager entityManager = null;
		try
		{
			
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */	
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");	
			entityManager = entityManagerFactory.createEntityManager();
			
			/**
			 * Creating UserEntity object 
			 * 
			 * using find method to retrieve data from database
			 * 
			 * after retrieving userEntity object converting it into UserBean
			 */	
			UserEntity userEntity=entityManager.find(UserEntity.class, userId);
			
			System.out.println("test"+userEntity);
			
			
			ObjectConverter converter = new ObjectConverter();
			
			userBean = converter.convertUserEntityToBean(userEntity);
			
			LOGGER.info("View User Successfully");
		}
		catch(Exception e)
		{
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		}
		finally
		{
			/**
			 * closing entityManager after retrieving the data
			 */	
			if(entityManager!=null)
			{
				entityManager.close();
			}
		}
		/**
		 * Returning userBean object after fetching from the database
		 */	
			return userBean;
	}
	
	
	/**
	 * This method is to update user password
	 */	
	public UserBean updatePassword(UserBean up) {
		
		/**
		 * Creating entityManager object to establish connection
		 * 
		 * creating userBean object 
		 */	
		EntityManager entityManager = null;
		UserBean bean = null;

		ObjectConverter converter = new ObjectConverter();

		try {
			
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */	
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			
			/**
			 * Creating UserEntity object 
			 * 
			 * using find method to check whether user is stored in the database or not
			 */	
			UserEntity entity = (UserEntity) entityManager.find(UserEntity.class, up.getUserid());
		
			if(entity!=null) {
				
				/**
				 * if user exist, the updating the user details with new password
				 */	
				entity.setUser_id(up.getUserid());
				entity.setEmail(up.getEmail());
				entity.setPassword(up.getRole());
				entity.setConfirmPassword(up.getRole());
				
				/**
				 * Converting user entity into UserBEan
				 */	
				bean = converter.convertUserEntityToBean(entity);
				entityManager.persist(entity);
				entityManager.getTransaction().commit();

			}else {
				LOGGER.info("No recored ");
			}
			
		} catch (Exception e) {
			LOGGER.info("something went wrong");
			e.printStackTrace();
		} finally {
			/**
			 * closing the connection after executing the operation
			 */	
			if (entityManager != null) {
				entityManager.close();
			}
		}
		/**
		 * returning user BEan object with updated data members
		 */	
		return bean;
	}
	
	
	
	
	
	
	
	
	//----------------------update password ------------------------------------------------------	
		public PasswordBean updatePassword(PasswordBean pass) throws InvalidEmailORUserIdException{
			//create entity manager object
			EntityManager entityManager = null;
			UserBean bean = null;
			//create ObjectConverter object
			ObjectConverter converter = new ObjectConverter();
			try {
				//create entity manager factory object
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
				entityManager = entityManagerFactory.createEntityManager();
				//open Transaction
				entityManager.getTransaction().begin();
				UserEntity entity = (UserEntity) entityManager.find(UserEntity.class, pass.getUserid());
				if(entity.getEmail().equalsIgnoreCase(pass.getEmail()))
					if(entity!=null) {
						entity.setUser_id(pass.getUserid());
						bean = converter.convertUserEntityToBean(entity);
						entityManager.persist(entity);
						entityManager.getTransaction().commit();

					}else 
						System.out.println("No recored ");
				else {
					System.out.println("email are not vallidat");
					pass=null;
					throw new InvalidEmailORUserIdException("Email or password or wrong");
				}
			} catch (Exception e) {
				System.out.println("something went wrong");
				e.printStackTrace();
			} finally {
				if (entityManager != null) {
					entityManager.close();
				}
			}
			return pass;
		}
		//------------------------otp submitted---------------------	
		
		public PasswordBean submitOTP(PasswordBean pass) {
			EntityManager entityManager = null;
			UserBean bean = null;

			ObjectConverter converter = new ObjectConverter();
			try {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
				entityManager = entityManagerFactory.createEntityManager();
				entityManager.getTransaction().begin();
				UserEntity entity = (UserEntity) entityManager.find(UserEntity.class, pass.getUserid());
				if(entity!=null) {
						entity.setUser_id(pass.getUserid());
						entity.setPassword(pass.getPassword());
						entity.setConfirmPassword(pass.getPassword());
						
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
			return pass;
		}
		//------------------------------------------------------------------------------

}