
package com.root.testing;

import java.sql.SQLException;

import com.root.bean.PolicyBean;
import com.root.service.PolicyService;
import com.root.service.PolicyServiceImpl;

public class Demo1 {

		
	public static void main(String[] args)  throws ClassNotFoundException, SQLException {
	
		PolicyService policyService = new PolicyServiceImpl();
	PolicyBean policyBean = policyService.viewPolicy(14);
		
	System.out.println(policyBean);
		
	}
}

