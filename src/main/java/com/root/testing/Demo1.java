
package com.root.testing;

import java.sql.SQLException;

import com.google.protobuf.Service;
import com.root.bean.HomeOwnerBean;
import com.root.bean.PolicyBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;
import com.root.dao.PolicyDAO;
import com.root.dao.PolicyDAOImpl;
import com.root.service.HomeOwnerService;
import com.root.service.HomeOwnerServiceImpl;

public class Demo1 {


	public static void main(String[] args)  throws ClassNotFoundException, SQLException {

		
		HomeOwnerService home = new HomeOwnerServiceImpl();
	
	     System.out.println(home.findHomeownerByUserId(101));
	}
}

