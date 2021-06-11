package com.root.dao;

import java.sql.SQLException; 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.root.bean.LocationBean;
import com.root.bean.QuoteBean;
import com.root.entity.LocationEntity;
import com.root.entity.QuoteEntity;
import com.root.objectConverter.ObjectConverter;

@Repository
public class QuoteDAOImpl implements QuoteDAO {
	static final Logger LOGGER = Logger.getLogger(QuoteDAOImpl.class);

	/**
	 * This is a method for add Quote
	 * Here we use database connectivity for inserting details
	 */
	public int addQuote(LocationBean locationBean, QuoteBean quoteBean)
	throws ClassNotFoundException, SQLException {
		
		EntityManager entityManager = null;
        int id=0;
		try
		{
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			/**
			 * create object of QuoteEntity
			 */
			QuoteEntity quoteEntity = new QuoteEntity();
			/**
			 * get quote details from quoteBean and set quote details into quoteEntity
			 */
			//quoteEntity.setQuote_id(quoteBean.getQuote_id());
			quoteEntity.setMonthly_premium(quoteBean.getMonthly_premium());
			quoteEntity.setDwelling_coverage(quoteBean.getDwelling_coverage());
			quoteEntity.setDetached_structures(quoteBean.getDetached_structures());
			quoteEntity.setPersonal_property(quoteBean.getPersonal_property());
			quoteEntity.setAdd_living_exp(quoteBean.getAdd_living_exp());
			quoteEntity.setMedical_expense(quoteBean.getMedical_expense());
			quoteEntity.setDeductible(quoteBean.getDeductible());
			
			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
			 * to entity to use database
			 */
			ObjectConverter converter = new ObjectConverter();
			/**
			 * convert LocationBean object to LocationEntity 
			 */
			LocationEntity entity = converter.convertLocationBeansToEntity(locationBean);
			
			/**
			 * set the locationEntity
			 */
			quoteEntity.setLocationEntity(entity);
			
			/**
			 * First we need to begin the transaction persist method is used for inserting
			 * details After persisting the details we need to commit otherwise it will not
			 * be reflect to database
			 */
			entityManager.getTransaction().begin();
			entityManager.persist(quoteEntity);
			entityManager.getTransaction().commit();
			
			LOGGER.info("Insert Quote Successfully");
		    id = quoteEntity.getQuote_id();
		
		}
		catch(Exception e)
		{
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		}
		finally
		{
			entityManager.close();
		}
		/**
		 * Returning  id after fetching from the database
		 */	
		return id;

	}
	/**
	 * This is a method for find Quote by QuoteId
	 * Here we use database connectivity for inserting details
	 */
	@Override
	public QuoteBean findQuoteById(int quoteID) throws ClassNotFoundException, SQLException {
		
		EntityManager entityManager = null;
		QuoteBean quoteBean = new QuoteBean();
		
		try
		{
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			/**
			 * find the details of QuoteEntity by find method 
			 */
			//entityManager.getTransaction().begin();
			QuoteEntity quoteEntity = entityManager.find(QuoteEntity.class, quoteID);
			//entityManager.getTransaction().commit();
			
			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
			 * to entity to use database
			 */
			ObjectConverter converter = new ObjectConverter();
			
			/**
			 * convert LocationEntity to LocationBean
			 */
			LocationBean locationBean = converter.convertLocationEntityToBean(quoteEntity.getLocationEntity());
			/**
			 * get quote details from quoteEntity and set quote details into quoteBean
			 */
			quoteBean.setQuote_id(quoteEntity.getQuote_id()); 
			quoteBean.setMonthly_premium(quoteEntity.getMonthly_premium());
			quoteBean.setDwelling_coverage(quoteEntity.getDwelling_coverage());
			quoteBean.setDetached_structures(quoteEntity.getDetached_structures());
			quoteBean.setPersonal_property(quoteEntity.getPersonal_property());
			quoteBean.setAdd_living_exp(quoteEntity.getAdd_living_exp());
			quoteBean.setMedical_expense(quoteEntity.getMedical_expense());
			quoteBean.setDeductible(quoteEntity.getDeductible());
			quoteBean.setLocation_id(locationBean);
			LOGGER.info("Retrieve Quote Successfully");
		}
		catch(Exception e)
		{
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		}
		finally
		{
			entityManager.close();
		}
		/**
		 * Returning quoteBean object after fetching from the database
		 */	
		return quoteBean;
	}
	
	
	
	/**
	 * This is a method for find Quote by LocationId
	 * Here we use database connectivity for inserting details
	 */
	public QuoteBean findQuoteByLocationId(int locationID) throws ClassNotFoundException, SQLException {
		EntityManager entityManager=null;
		QuoteBean bean=null;
		try
		{
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			/**
			 * with the help of createQuery find the data by locationId
			 */
			QuoteEntity quote = (QuoteEntity) entityManager.createQuery("from QuoteEntity q where q.locationEntity.location_id = "+locationID).getSingleResult();
			
			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
			 * to entity to use database
			 */
			ObjectConverter converter = new ObjectConverter();
			
			/**
			 * convert QuoteEntity to QuoteBean
			 */
			LocationEntity locationEntity = quote.getLocationEntity();
			bean=converter.convertQuoteEntityToBean(quote);
			
			/**
			 * set LocationId in QuoteBean 
			 */
			bean.setLocation_id(converter.convertLocationEntityToBean(locationEntity));
			//bean.setLocation_id(locationBean);
	
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			
		}
		/**
		 * Returning QuoteBean object after fetching from the database
		 */	
		return bean;
	}
	
	
}