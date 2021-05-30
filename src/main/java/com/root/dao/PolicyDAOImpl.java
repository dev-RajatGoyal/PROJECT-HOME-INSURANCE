
package com.root.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.entity.PolicyEntity;
import com.root.entity.QuoteEntity;
import com.root.entity.UserEntity;
import com.root.objectConverter.ObjectConverter;

public class PolicyDAOImpl implements PolicyDAO {
	static final Logger LOGGER = Logger.getLogger(PolicyDAOImpl.class);

	@Override
	public void buyPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean)
			throws ClassNotFoundException, SQLException {
		
		EntityManager entityManager = null;

		String userName = null;
		try {
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			
			UserEntity u = new UserEntity();
			QuoteEntity q = new QuoteEntity();
			
			u.setUser_id(userBean.getuserid());
			q.setQuote_id(quoteBean.getQuote_id());

			PolicyEntity policyEntity = new PolicyEntity();
			
			//policyEntity.setPolicy_id(policyBean.getPolicyId());
			policyEntity.setEffective_date(policyBean.getEffectiveDate());
			policyEntity.setEnd_date(policyBean.getEndDate());
			policyEntity.setPolicy_status(policyBean.getPolicyStatus());
			policyEntity.setTerm(policyBean.getPolicyTerm());
			policyEntity.setQuoteEntity(q);
			policyEntity.setUserEntity(u);

			entityManager.getTransaction().begin();
			entityManager.persist(policyEntity);

			entityManager.getTransaction().commit();
			
			LOGGER.info("Policy Bought Successfully");
			LOGGER.info("policy id is"+policyEntity.getPolicy_id());

		} catch (Exception e) {
			LOGGER.info("Something went wrong PolicyDAOImpl");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

	
	@Override
	public PolicyBean viewPolicy(int policyId)
			throws ClassNotFoundException, SQLException {
		EntityManager entityManager = null;

		PolicyBean policyBean = new PolicyBean();
		
		try {

			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			/**
			 * creating policyEntity object to fetch the policy object from the database
			 */
			PolicyEntity policyEntity = new PolicyEntity();
			
			policyEntity = entityManager.find(PolicyEntity.class, policyId);
			
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
			 * setting policyEntity deta members into policyBean
			 */
			policyBean.setPolicyId(policyEntity.getPolicy_id());
			policyBean.setEffectiveDate(policyEntity.getEffective_date());
			policyBean.setEndDate(policyEntity.getEnd_date());
			policyBean.setPolicyStatus(policyEntity.getPolicy_status());
			policyBean.setPolicyTerm(policyEntity.getTerm());
			policyBean.setQuote(quoteBean);
			policyBean.setUser(userBean);
			LOGGER.info("Policy View Enabled");


		} catch (Exception e) {
			LOGGER.info("Something went wrong");
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
		
		return policyBean;
	}

	@Override
	public void renewPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean)
			throws ClassNotFoundException, SQLException {
		EntityManager entityManager = null;

		String userName = null;
		try {

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			PolicyEntity policyEntity = new PolicyEntity();
			policyEntity.setPolicy_id(policyBean.getPolicyId());
			policyEntity.setEffective_date(policyBean.getEffectiveDate());
			policyEntity.setEnd_date(policyBean.getEffectiveDate());
			policyEntity.setPolicy_status(policyBean.getPolicyStatus());
			policyEntity.setTerm(policyBean.getPolicyTerm());
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

}