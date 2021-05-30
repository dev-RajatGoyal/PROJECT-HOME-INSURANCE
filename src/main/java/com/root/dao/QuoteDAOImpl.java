package com.root.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.root.bean.LocationBean;
import com.root.bean.QuoteBean;
import com.root.entity.LocationEntity;
import com.root.entity.QuoteEntity;
import com.root.objectConverter.ObjectConverter;

public class QuoteDAOImpl implements QuoteDAO {
	static final Logger LOGGER = Logger.getLogger(QuoteDAOImpl.class);


	public int addQuote(LocationBean locationBean, QuoteBean quoteBean)
			throws ClassNotFoundException, SQLException {

		//------------------------- business logic for monthly premium------------------------------------
		
		EntityManager entityManager = null;
        int id=0;
		try
		{
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			QuoteEntity quoteEntity = new QuoteEntity();
			
			//quoteEntity.setQuote_id(quoteBean.getQuote_id());
			quoteEntity.setMonthly_premium(quoteBean.getMonthly_premium());
			quoteEntity.setDwelling_coverage(quoteBean.getDwelling_coverage());
			quoteEntity.setDetached_structures(quoteBean.getDetached_structures());
			quoteEntity.setPersonal_property(quoteBean.getPersonal_property());
			quoteEntity.setAdd_living_exp(quoteBean.getAdd_living_exp());
			quoteEntity.setMedical_expense(quoteBean.getMedical_expense());
			quoteEntity.setDeductible(quoteBean.getDeductible());
			
			ObjectConverter converter = new ObjectConverter();
			LocationEntity entity = converter.convertLocationBeansToEntity(locationBean);
			quoteEntity.setLocationEntity(entity);
			
			
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
		return id;

	}

	@Override
	public QuoteBean findQuoteById(int quoteID) throws ClassNotFoundException, SQLException {
		
		EntityManager entityManager = null;
		QuoteBean quoteBean = new QuoteBean();
		
		try
		{
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			entityManager.getTransaction().begin();
			QuoteEntity quoteEntity = entityManager.find(QuoteEntity.class, quoteID);
			entityManager.getTransaction().commit();
			ObjectConverter converter = new ObjectConverter();
			
			quoteBean.setQuote_id(quoteEntity.getQuote_id()); 
			quoteBean.setMonthly_premium(quoteEntity.getMonthly_premium());
			quoteBean.setDwelling_coverage(quoteEntity.getDwelling_coverage());
			quoteBean.setDetached_structures(quoteEntity.getDetached_structures());
			quoteBean.setPersonal_property(quoteEntity.getPersonal_property());
			quoteBean.setAdd_living_exp(quoteEntity.getAdd_living_exp());
			quoteBean.setMedical_expense(quoteEntity.getMedical_expense());
			quoteBean.setDeductible(quoteEntity.getDeductible());
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
		return quoteBean;
	}
	
	
	
	
}
