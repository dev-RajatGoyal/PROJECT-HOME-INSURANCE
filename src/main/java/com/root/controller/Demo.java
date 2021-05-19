package com.root.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.root.entity.User;
import com.root.utility.JPAUtility;

public class Demo {
	public static void main(String[] args) {
		
		EntityManagerFactory efm = JPAUtility.getEntityManagerFactory();
		EntityManager em = efm.createEntityManager();
		
		User user = new User();
		user.setUser_id(1);
		user.setUser_name("abc");
		user.setPassword("abc");
		user.setRole("user");
		
		em.getTransaction().begin();
		System.out.println("USer stored successfully");
		em.persist(user);
		
		em.getTransaction().commit();
		
	}
}
