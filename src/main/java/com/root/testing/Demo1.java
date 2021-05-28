
package com.root.testing;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import
javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.root.bean.HomeOwnerBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;

public class Demo1 {


	public static void main(String[] args) throws ClassNotFoundException,
	SQLException {
		
		

		  EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("unit1");
		  EntityManager entityManager = entityManagerFactory.createEntityManager();
		  
		  UserBean user = new UserBean();
		  
		   user.setuserid(101);
		  
		  HomeOwnerBean home = new HomeOwnerBean();
		  
		  home.setOwnerId(5);
		  home.setFname("rahanans");
		  home.setLname("ansaris");
		  home.setUser(user);
		  
		  

		HomeownerDAO dao = new HomeownerDAOImpl();
		
		dao.insertHomeOwner(home);
		
		
		
		
	}
}

