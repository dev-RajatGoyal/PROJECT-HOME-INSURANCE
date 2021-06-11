
package com.root.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.entity.PolicyEntity;
import com.root.entity.QuoteEntity;
import com.root.entity.UserEntity;
import com.root.objectConverter.ObjectConverter;

@Repository
public class PolicyDAOImpl implements PolicyDAO {
	static final Logger LOGGER = Logger.getLogger(PolicyDAOImpl.class);
	/**
	 * This is a method for Buy policy
	 * Here we use database connectivity for inserting details
	 */
	@Override
	public int buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean)
			throws ClassNotFoundException, SQLException {

		EntityManager entityManager = null;
		int policy_id = 0 ;
		String userName = null;
		try {
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			UserEntity u = new UserEntity();
			QuoteEntity q = new QuoteEntity();
			
			u.setUser_id(userBean.getuserid());
			q.setQuote_id(quoteBean.getQuote_id());

			/**
			 * create PolicyEntity object
			 */
			PolicyEntity policyEntity = new PolicyEntity();
			
			/**
			 * get details from policyBean and set the details of policy into policyEntity
			 */
			//policyEntity.setPolicy_id(policyBean.getPolicyId());
			policyEntity.setEffective_date(policyBean.getEffectiveDate());
			policyEntity.setEnd_date(policyBean.getEndDate());
			policyEntity.setPolicy_status(policyBean.getPolicyStatus());
			policyEntity.setTerm(policyBean.getPolicyTerm());
			policyEntity.setQuoteEntity(q);
			policyEntity.setUserEntity(u);
			
			/**
			 * First we need to begin the transaction persist method is used for inserting
			 * details After persisting the details we need to commit otherwise it will not
			 * be reflect to database
			 */
			entityManager.getTransaction().begin();
			entityManager.persist(policyEntity);
			entityManager.getTransaction().commit();

			policy_id = policyEntity.getPolicy_id();
			LOGGER.info("Policy Bought Successfully");
			LOGGER.info("policy id is" + policyEntity.getPolicy_id());

		} catch (Exception e) {
			LOGGER.info("Something went wrong PolicyDAOImpl");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
				
		}
		/**
		 * Returning policy_id after fetching from the database
		 */	
		return policy_id;
	}
	
	/**
	 * This is a method for View Policy
	 * Here we use database connectivity for inserting details
	 */
	@Override
	public PolicyBean viewPolicy(int policyId) throws ClassNotFoundException, SQLException {
		EntityManager entityManager = null;

		PolicyBean policyBean =null;

		try {
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			

			/**
			 * creating policyEntity object to fetch the policy object from the database
			 */
			PolicyEntity policyEntity = entityManager.find(PolicyEntity.class, policyId);

			/**
			 * converting quoteEntity to bean
			 */
			ObjectConverter converter = new ObjectConverter();
			
			QuoteBean quoteBean = converter.convertQuoteEntityToBean(policyEntity.getQuoteEntity());

			/**
			 * converting userEntity to bean
			 */
			UserBean userBean = converter.convertUserEntityToBean(policyEntity.getUserEntity());

			/**
			 * setting policyEntity data members into policyBean
			 */
			
			policyBean = converter.convertPolicyEntityToBean(policyEntity);
			
			policyBean.setUser(userBean);
			policyBean.setQuote(quoteBean);
			
			
			LOGGER.info("Policy View Enabled");

		} catch (Exception e) {
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		/**
		 * Returning policyBean object after fetching from the database
		 */	
		return policyBean;
	}

	/*
	 * @Override public PolicyBean renewPolicy(int policyId, PolicyBean
	 * policyBeanNew) throws ClassNotFoundException, SQLException {
	 * 
	 * EntityManager entityManager = null; PolicyBean policyBean = null;
	 * 
	 * try {
	 * 
	 * EntityManagerFactory entityManagerFactory =
	 * Persistence.createEntityManagerFactory("unit1"); entityManager =
	 * entityManagerFactory.createEntityManager(); ObjectConverter converter = new
	 * ObjectConverter();
	 * 
	 * PolicyEntity policyEntity = entityManager.find(PolicyEntity.class,policyId);
	 * UserEntity userEntity = policyEntity.getUserEntity(); QuoteEntity quoteEntity
	 * = policyEntity.getQuoteEntity();
	 * 
	 * policyEntity.setEffective_date(policyBeanNew.getEffectiveDate());
	 * policyEntity.setEnd_date(policyBeanNew.getEndDate());
	 * policyEntity.setTerm(policyBeanNew.getPolicyTerm());
	 * policyEntity.setPolicy_status(policyBeanNew.getPolicyStatus());
	 * 
	 * entityManager.getTransaction().begin(); entityManager.merge(policyEntity);
	 * entityManager.getTransaction().commit();
	 * 
	 * 
	 * 
	 * policyBean = converter.convertPolicyEntityToBean(policyEntity);
	 * policyBean.setUser(converter.convertUserEntityToBean(userEntity));
	 * policyBean.setQuote(converter.convertQuoteEntityToBean(quoteEntity));
	 * System.out.println("updated successfully");
	 * 
	 * LOGGER.info("Policy Renewed Successfully");
	 * 
	 * } catch (Exception e) { LOGGER.info("Something went wrong");
	 * e.printStackTrace(); } finally { if (entityManager != null) {
	 * entityManager.close(); } }
	 * 
	 * return policyBean;
	 * 
	 * }
	 */
	/**
	 * This is a method for Cancel Policy
	 * Here we use database connectivity for inserting details
	 */
	@Override
	public void canclePoicy(int policyId) throws ClassNotFoundException, SQLException {

		EntityManager entityManager = null;

		try {
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();

			/**
			 * fetching existing policyEntity fromt the database
			 */
			PolicyEntity policyEntity = new PolicyEntity();
			policyEntity = entityManager.find(PolicyEntity.class, policyId);
			
			/**
			 * First we need to begin the transaction remove method is used for remove
			 * details After remove the details we need to commit otherwise it will not
			 * be reflect to database
			 */
			entityManager.getTransaction().begin();
			entityManager.remove(policyEntity);
			entityManager.getTransaction().commit();
			LOGGER.info("Policy Canceled Successfully");
			System.out.println("Policy cancled successfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
		}
	}
	
	
	/**
	 * This is a method for View All Policy
	 * Here we use database connectivity for inserting details
	 */
	@Override 
	public List<PolicyBean> viewAllPolicy() throws ClassNotFoundException, SQLException {

		EntityManager entityManager = null; 
		List<PolicyBean> listofPolicyBean = null; 
		
		try {

		/**
	     * array list of PolicyBean 
	     */
		listofPolicyBean = new ArrayList<PolicyBean>();
		
		/**
		 * Create Entity ManagerFactory Object for calling the unit calling unit where
		 * we define our database details for achieving JPA part
		 */
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1"); 
		entityManager =	entityManagerFactory.createEntityManager();
		
		
		List<PolicyEntity> listofPolicyEntity=  (List<PolicyEntity>) entityManager.createQuery("FROM PolicyEntity ",PolicyEntity.class).getResultList();
		
		/**
		 * converting quoteEntity to bean
		 */
		ObjectConverter converter = new ObjectConverter();
	
	
		for(PolicyEntity policyEntity : listofPolicyEntity)
		{
			QuoteBean quoteBean = converter.convertQuoteEntityToBean(policyEntity.getQuoteEntity());

			/**
			 * converting userEntity to bean
			 */
			UserBean userBean = converter.convertUserEntityToBean(policyEntity.getUserEntity());
			
			/**
			 * convert policyEntity to PolicyBean
			 */
			PolicyBean policyBean = converter.convertPolicyEntityToBean(policyEntity);
			policyBean.setUser( userBean);
			policyBean.setQuote(quoteBean);
			
			listofPolicyBean.add(policyBean);
		}
		
		} 
		catch(Exception e) { 
			
			e.printStackTrace(); 
		}
		finally { 
			if (entityManager != null) {
				entityManager.close();
			}
		} 
		/**
		 * Returning listofPolicyBean after fetching from the database
		 */	
		return listofPolicyBean; 
	}
	
	
	
	/**
	 * This is a method for Renew Policy
	 */
	public void renewPolicy(PolicyBean policy)
	{
		EntityManager entityManager = null;
		PolicyBean policyBean = null;
		
		try {
		
		/**
		 * ObjectConverter is a class for object convert we need to convert bean object
	     * to entity to use database
		 */
	    ObjectConverter converter = new ObjectConverter();
	    
	    /**
		 * Create Entity ManagerFactory Object for calling the unit calling unit where
		 * we define our database details for achieving JPA part
		 */	
	    
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		entityManager = entityManagerFactory.createEntityManager();
		/**
		 * set Policy Status
		 */
	    policy.setPolicyStatus("Active");
	    
	    /**
	     * convert PolicyBean to PolicyEntity
	     */
	    PolicyEntity entity = converter.convertPolicyBeanToEntity(policy);
	    entity.setQuoteEntity(converter.convertQuoteBeanToEntity(policy.getQuote()));
	    entity.setUserEntity(converter.convertUserBeansToEntity(policy.getUser()));
	    /**
		 * Update the policy data into database
		 */
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		LOGGER.info("Policy Renewed Successfully");

		} catch (Exception e) {
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		
		
	}
	/**
	 * This is a method for view Policy by UserID
	 */
	@Override
	public PolicyBean viewPolicyByUserId(int userId) throws ClassNotFoundException, SQLException {
		
		EntityManager entityManager = null;
		PolicyBean policyBean = null;
		
		try
		{
			/**
			 * Create Entity ManagerFactory Object for calling the unit calling unit where
			 * we define our database details for achieving JPA part
			 */	
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			/**
			 * find policy data by userId
			 */
			PolicyEntity policyEntity = (PolicyEntity) entityManager.createQuery("from PolicyEntity p where p.userEntity.user_id = "+userId).getSingleResult();
			
			/**
			 * ObjectConverter is a class for object convert we need to convert bean object
		     * to entity to use database
			 */
			ObjectConverter converter = new ObjectConverter();
			
			
			UserEntity userEntity = policyEntity.getUserEntity();
			QuoteEntity quoteEntity = policyEntity.getQuoteEntity();
			
			/**
			 * convert policyEntity to policyBean
			 */
			policyBean = converter.convertPolicyEntityToBean(policyEntity);
			policyBean.setUser(converter.convertUserEntityToBean(userEntity));
			policyBean.setQuote(converter.convertQuoteEntityToBean(quoteEntity));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(entityManager!=null) {
				entityManager.close();
			}
		}
		/**
		 * Returning policyBean object after fetching from the database
		 */	
		return policyBean;
	}


}