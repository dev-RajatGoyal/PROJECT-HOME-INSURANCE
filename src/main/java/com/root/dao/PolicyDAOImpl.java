
package com.root.dao;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.entity.PolicyEntity;
import com.root.entity.QuoteEntity;
import com.root.entity.UserEntity;

public class PolicyDAOImpl implements PolicyDAO {

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
			
			policyEntity.setPolicy_id(policyBean.getPolicyId());
			policyEntity.setEffective_date(policyBean.getEffectiveDate());
			policyEntity.setEnd_date(policyBean.getEndDate());
			policyEntity.setPolicy_status(policyBean.getPolicyStatus());
			policyEntity.setTerm(policyBean.getPolicyTerm());
			policyEntity.setQuoteEntity(q);
			policyEntity.setUserEntity(u);

			entityManager.getTransaction().begin();
			entityManager.persist(policyEntity);
			System.out.println("Policy Bought Successfully");
			entityManager.getTransaction().commit();
			
			System.out.println("policy id is"+policyEntity.getPolicy_id());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

	@Override
	public void viewPolicy(PolicyBean policyBean, UserBean userBean, QuoteBean quoteBean)
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

			System.out.println("Policy View Enabled");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
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
			System.out.println("Policy Renewed Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}

	}

}