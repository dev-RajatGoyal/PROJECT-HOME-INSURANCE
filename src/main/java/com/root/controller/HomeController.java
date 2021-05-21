package com.root.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.root.bean.UserBean;
import com.root.service.UserService;
import com.root.service.UserServiceImpl;

@Controller
public class HomeController {
	
	UserService userService = new UserServiceImpl();
	
	@GetMapping(value="/")
	public String showView()
	{
		return "home";
	}
	
	@GetMapping(value="/register")
	public String showRegister() 
	{
		return "Registration";
	}
	
	@PostMapping(value="/registersuccess")
	public String RegisterSuccessful(@RequestParam String username, @RequestParam String role, @RequestParam String password, @RequestParam String cpassword) 
	{
		UserBean user = new UserBean();
		user.setUsername(username);
		user.setRole(role);
		user.setPassword(password);
		user.setCpassword(cpassword);
		
		try {
			userService.insertUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "RegistrationSuccess";
	}
	
	@GetMapping(value="/userdashboard")
	public String showUserDashboard() 
	{
		return "UserDashboard";
	}
}
