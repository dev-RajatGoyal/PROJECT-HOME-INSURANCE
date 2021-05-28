package com.root.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;
import com.root.service.LocationService;
import com.root.service.LocationServiceImpl;
import com.root.service.QuoteService;
import com.root.service.QuoteServiceImpl;
import com.root.service.UserService;
import com.root.service.UserServiceImpl;

@Controller
public class HomeController {

	UserService userService = new UserServiceImpl();

	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showHomePage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	/*
	 * @RequestMapping(value="/", method = RequestMethod.GET) public String
	 * showView() { return "home"; }
	 */

	@RequestMapping(value="/userdashboard", method = RequestMethod.POST)
	public ModelAndView showUserDashboard(@RequestParam int userId, @RequestParam String password, Model model) throws ClassNotFoundException, SQLException 
	{
		
		LocationBean location = new LocationBean();
		model.addAttribute("location",location);
		
		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);

		ModelAndView modelAndView = new ModelAndView();
     	UserBean user = new UserBean();
		user = userService.viewUserByUserId(userId);
		model.addAttribute("user",user);
		if(user.getuserid()==userId && user.getPassword().equals(password))
		{
			modelAndView.setViewName("UserDashboard2");
		}
		return modelAndView;
	}

	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView UserRegistration() {
		System.out.println("HomeController.UserRegistration()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Registration");
		return modelAndView;
	}

	@RequestMapping(value = "/registersuccess", method = RequestMethod.POST)
	public ModelAndView RegisterSuccessful(UserBean user) throws ClassNotFoundException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("HomeController.RegisterSuccessful()");
		System.out.println(user.getCpassword() + "===" + user.getPassword());
		String userName = null;
		if (user.getPassword().equalsIgnoreCase(user.getCpassword()))
			userName = userService.insertUser(user);
		System.out.println(userName + "user name");
		if (!userName.equals(null)) {
			modelAndView.setViewName("home");

		} else {
			modelAndView.setViewName("userregistrationFailure");
		}

		return modelAndView;
	}
	
	
	
	/*
	 * @RequestMapping(value="/register" , method = RequestMethod.GET) public
	 * ModelAndView UserRegistration() { ModelAndView modelAndView = new
	 * ModelAndView(); modelAndView.setViewName("Registration"); return
	 * modelAndView; }
	 * 
	 * 
	 * @RequestMapping(value="/registersuccess" , method = RequestMethod.POST)
	 * public ModelAndView RegisterSuccessful(UserBean user) throws
	 * ClassNotFoundException, SQLException { ModelAndView modelAndView = new
	 * ModelAndView(); System.out.println("HomeController.RegisterSuccessful()");
	 * System.out.println(user.getCpassword() + "===" + user.getPassword()); String
	 * userName = null; if
	 * (user.getPassword().equalsIgnoreCase(user.getCpassword())) userName =
	 * userService.insertUser(user); System.out.println(userName + "user name"); if
	 * (!userName.equals(null)) { modelAndView.setViewName("RegistrationSuccess");
	 * 
	 * } else { modelAndView.setViewName("userregistrationFailure"); }
	 * 
	 * return modelAndView; }
	 */
	
	@RequestMapping(value="/homeowner" , method = RequestMethod.POST)
	public ModelAndView LocationPage(@ModelAttribute("home") HomeOwnerBean bean , Model model) 
	{

		HomeownerDAO dao = new HomeownerDAOImpl();
		
		LocationBean location = new LocationBean();
		model.addAttribute("location",location);
		
		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);
		
		UserBean user = new UserBean();
	    user.setuserid(1001);
		bean.setUser(user);
		
		dao.insertHomeOwner(bean);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserDashboard2");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/location" , method = RequestMethod.POST)
	public ModelAndView submitPropertyAndLocation(@ModelAttribute("location") LocationBean location, Model model) throws ClassNotFoundException, SQLException
	{
		
		PropertyBean property = location.getProperty();
		UserBean user = location.getUser();
		
		UserBean userBean = new UserBean();
		userBean.setuserid(1002);
		
		
		LocationService service = new LocationServiceImpl();
		service.addLocationWithProperty(location, property, userBean);
		
		
		QuoteService quoteService = new QuoteServiceImpl();
		int quote_Id = quoteService.addQuote(location.getLocation_id());
		
		
		model.addAttribute("user",user);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserDashboard");
		modelAndView.addObject("message","Location and property add successfully");
		return modelAndView;
		
				
	}
	
	@RequestMapping(value="/")
	public ModelAndView addLocation()
	{
		return null;
		
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updatePassword() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updatePassword");
		return modelAndView;
	}

	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(UserBean user) throws ClassNotFoundException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(user);
		UserBean bean = userService.updatePassword(user);
		// System.out.println(userName+"user name");
		if (bean != null)
			modelAndView.setViewName("updateSuccess");
		else
			modelAndView.setViewName("updateFail");
		return modelAndView;
	}
}
