package com.root.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	{
		System.out.println("object of controller created by container");
	}
	
	@GetMapping(value="/")
	public String showView()
	{
		return "home";
	}
}
