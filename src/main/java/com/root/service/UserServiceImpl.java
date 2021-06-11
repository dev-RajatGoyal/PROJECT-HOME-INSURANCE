package com.root.service;

import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.root.bean.PasswordBean;
import com.root.bean.UserBean;
import com.root.dao.UserDAOImpl;
import com.root.exception.InvalidEmailORUserIdException;
/**
 * This class is to interact with Controller
 * 
 * UserServiceImpl will interact with UserDAOImpl internally
 * 
 * This Service class is mainly works with BEAN objects
 */
@Service
public class UserServiceImpl implements UserService
{
	static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	
	UserDAOImpl userDao = new UserDAOImpl();
	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call insertUser method from dao layer internally store object in database
	 * 
	 */
	@Override
	public String insertUser(UserBean userBean) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Insert User Method from UserServiceImpl");
		return userDao.insertUser(userBean);
	}
	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call viewUserByUserId method from dao layer it show the User according to database
	 * 
	 */
	@Override
	public UserBean viewUserByUserId(int userId) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside View User By ID Method from UserServiceImpl");
		return userDao.viewUserByUserId(userId);
	}

	/**
	 * 	This method will be invoked from Controller to bind the object fetched from MVC FORM
	 * 	
	 *  It will call updatePassword method from dao layer its update exiting password into database
	 * 
	 */
	@Override
	public UserBean updatePassword(UserBean userBean) throws ClassNotFoundException, SQLException {
		LOGGER.info("Inside Update Password Method from UserServiceImpl");
		return userDao.updatePassword(userBean);
	}
	
	
	
	
	
	
	
	
	//==============user service implementation update password methods 
	//it wil return password bean object
	//it will call update password methods in dao
		
		
		@Override
		public PasswordBean updatePassword(PasswordBean pass) throws ClassNotFoundException, SQLException, InvalidEmailORUserIdException {
			return userDao.updatePassword(pass);
		}	
		
		@Override
		public PasswordBean submitotp(PasswordBean pass) throws ClassNotFoundException, SQLException {
			return userDao.submitOTP(pass);
		}
		//send otp in email
		public boolean sendEmail(String subject, String message, String to){
			boolean f=false;
			String from="rehanans0007@gmail.com";
			String host="smtp.gmail.com";
			String recepient="";
			Properties prop=new Properties();
			System.out.println("Properties" +prop);
			prop.put("mail.smtp.host", host);
			prop.put("mail.smtp.port", "465");
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.auth", "true");
			Session session=Session.getInstance(prop, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return  new PasswordAuthentication("rehanans0007@gmail.com", "Ans@ryan007");
				}
			});
			session.setDebug(true);
			MimeMessage m=new MimeMessage(session);
			try {
				m.setFrom(from);
				m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				m.setSubject(subject);
				m.setText(message);
				Transport.send(m);
				System.out.println("sent");
				f=true;
			}
			catch(Exception ex) {
				//System.out.println(ex);
			}
			 
			return f;
		}

}