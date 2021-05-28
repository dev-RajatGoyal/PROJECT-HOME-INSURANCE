package com.root.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.LocationBean;
import com.root.bean.QuoteBean;
import com.root.entity.LocationEntity;
import com.root.entity.QuoteEntity;
import com.root.objectConverter.ObjectConverter;

public class QuoteDAOImpl implements QuoteDAO {


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
			
			quoteEntity.setQuote_id(quoteBean.getQuote_id());
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
			
			
		    id= quoteEntity.getQuote_id();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			entityManager.close();
		}
		return id;

	}
	
	
	
	
	
	
	/*
	 * public static QuoteEntity convertBeanToEntity(QuoteBean bean) { QuoteEntity
	 * entity = new QuoteEntity(); entity.setQuote_id(bean.getQuote_id()); return
	 * entity; }
	 * 
	 * public static QuoteBean convertEntityToBean(QuoteEntity entity) { QuoteBean
	 * bean = new QuoteBean(); bean.setLocation_id(entity.getQuote_id()); return
	 * bean; }
	 */
}
