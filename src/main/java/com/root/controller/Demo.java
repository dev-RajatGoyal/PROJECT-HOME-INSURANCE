package com.root.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.root.entity.User;

public class Demo {
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unit1");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		User user = new User();
		user.setUser_id(1);
		user.setUser_name("abc");
		user.setPassword("abc");
		user.setRole("user");
		
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
		System.out.println("success");
		entityManager.close();
		entityManagerFactory.close();
	}
}
