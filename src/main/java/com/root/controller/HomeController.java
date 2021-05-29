package com.root.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PolicyBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.dao.HomeownerDAO;
import com.root.dao.HomeownerDAOImpl;
import com.root.dao.PolicyDAOImpl;
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



	@RequestMapping(value="/userdashboard", method = RequestMethod.POST)
	public ModelAndView showUserDashboard(HttpServletRequest request,HttpServletResponse response ,@RequestParam int userId, @RequestParam String password, Model model) throws ClassNotFoundException, SQLException, IOException 
	{

		HttpSession session = request.getSession();

		LocationBean location = new LocationBean();
		model.addAttribute("location",location);

		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);

		ModelAndView modelAndView = new ModelAndView();
		UserBean user = new UserBean();
		user = userService.viewUserByUserId(userId);
		model.addAttribute("user",user);

		session.setAttribute("userId", user.getuserid());

		if(user.getuserid()==userId && user.getPassword().equals(password))
		{
			//response.sendRedirect("UserDashboard2");
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
	public ModelAndView RegisterSuccessful(UserBean user, Model model) throws ClassNotFoundException, SQLException {

		model.addAttribute("username",user.getUsername());
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
	public ModelAndView LocationPage(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("home") HomeOwnerBean bean , Model model) 
	{
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		System.out.println("inside homeOwner handler methood "+userId+" logged in");

		HomeownerDAO dao = new HomeownerDAOImpl();

		LocationBean location = new LocationBean();
		model.addAttribute("location",location);

		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);

		UserBean user = new UserBean();
		user.setuserid(userId);
		bean.setUser(user);

		dao.insertHomeOwner(bean);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserDashboard2");
		return modelAndView;
	}


	@RequestMapping(value="/location" , method = RequestMethod.POST)
	public ModelAndView submitPropertyAndLocation(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("location") LocationBean location, Model model) throws ClassNotFoundException, SQLException
	{
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		System.out.println("inside submitPropertyAndLocation handler methood "+userId+" logged in");

		PropertyBean property = location.getProperty();
		UserBean user = location.getUser();

		UserBean userBean = userService.viewUserByUserId(userId);
		//userBean.setuserid(userId);
		location.setUser(userBean);

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

	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response ) throws IOException
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();

		session.removeAttribute("userId");
		modelAndView.setViewName("home");
		//response.sendRedirect("home");

		return modelAndView;
	}
	
}
