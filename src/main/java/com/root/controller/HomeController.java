package com.root.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.root.bean.UserBean;
import com.root.service.UserService;
import com.root.service.UserServiceImpl;

@Controller
public class HomeController {
	
	UserService userService = new UserServiceImpl();
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String showView()
	{
		return "home";
	}
	
	@RequestMapping(value="/userdashboard", method = RequestMethod.POST)
	public String showUserDashboard(@RequestParam int userId, @RequestParam String password, Model model) throws ClassNotFoundException, SQLException 
	{
		UserBean user = new UserBean();
		user = userService.viewUserByUserId(userId);
		model.addAttribute("user",user);
		if(user.getuserid()==userId && user.getPassword().equals(password))
		{
			return "UserDashboard";
		}
		return "Error";
	}
	
	@RequestMapping(value="/register" , method = RequestMethod.GET)
	public String showRegister() 
	{
		return "Registration";
	}
	
	@RequestMapping(value="/registersuccess" , method = RequestMethod.POST)
	public String RegisterSuccessful(UserBean user) throws ClassNotFoundException, SQLException
	{

		System.out.println(user);
		String userName = userService.insertUser(user);
		if(!userName.equals(null))
		{
			return "RegistrationSuccess";
		}
		
		return "Error";
	}
	
}
