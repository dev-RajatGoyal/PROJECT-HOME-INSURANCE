package com.root.testing;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.root.bean.PolicyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.dao.PolicyDAOImpl;
	
			public class Demo extends PolicyDAOImpl {
				public static void main(String args[]) throws ParseException, ClassNotFoundException, SQLException		{
	/*				
	LocalDate dateBefore = LocalDate.of(2017, Month.MAY, 24);
	//29-July-2017, change this to your desired End Date
	LocalDate dateAfter = LocalDate.of(2017, Month.JULY, 29);
	long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
	System.out.println(noOfDaysBetween);}
	*/	
					
	String sDate1="31/12/2017";
	Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);	
	sDate1="31/12/2020";
	Date date2 =new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);	

			    PolicyBean  p=new PolicyBean();
	    
				p.setEffectiveDate(date1);
				p.setEndDate(date2);
				p.setPolicyStatus("Active");
				p.setPolicyTerm(40);
				
				UserBean us=new UserBean();
				us.setuserid(1007);
				QuoteBean qb=new QuoteBean();
				qb.setQuote_id(15);
				
				PolicyDAOImpl ser=new PolicyDAOImpl();
				ser.buyPolicy(p,us,qb);

			}
		}
