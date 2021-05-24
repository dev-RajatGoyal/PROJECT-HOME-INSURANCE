package com.root.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.root.bean.LocationBean;
import com.root.bean.PropertyBean;
import com.root.bean.UserBean;
import com.root.entity.UserEntity;
import com.root.service.LocationServiceImpl;
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
		

		ModelAndView modelAndView = new ModelAndView();
     	UserBean user = new UserBean();
		user = userService.viewUserByUserId(userId);
		model.addAttribute("user",user);
		if(user.getuserid()==userId && user.getPassword().equals(password))
		{
			modelAndView.setViewName("UserDashboard");
		}
		return modelAndView;
	}

	@RequestMapping(value="/register" , method = RequestMethod.GET)
	public ModelAndView UserRegistration() 
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Registration");
		return modelAndView;
	}

	@RequestMapping(value="/registersuccess" , method = RequestMethod.POST)
	public ModelAndView RegisterSuccessful(UserBean user) throws ClassNotFoundException, SQLException
	{
		ModelAndView modelAndView = new ModelAndView();
		
		
		System.out.println(user);
		String userName = userService.insertUser(user);
		if(!userName.equals(null))
		{
			modelAndView.setViewName("RegistrationSuccess");
			
		}

		return modelAndView;
	}




	// temp ------------

	@RequestMapping(value="/location" , method = RequestMethod.GET)
	public ModelAndView addLocation(HttpServletRequest request) throws ClassNotFoundException, SQLException 
	{
		
		ModelAndView modelAndView = new ModelAndView();

		int id = Integer.parseInt(request.getParameter("id"));
		String rt = request.getParameter("r_type");
		String a1 = request.getParameter("a1");
		String a2 = request.getParameter("a2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String r_user =request.getParameter("r_user");
		String zip = request.getParameter("zip");

		LocationBean l = new LocationBean();
		l.setLocation_id(id);
		l.setResidence_type(rt);
		l.setAddress_line_1(a1);
		l.setAddress_line_2(a2);
		l.setCity(city);
		l.setLocation_state(state);
		l.setZip_code(zip);
		l.setResidence_use(r_user);
		
		
		int p_id   = Integer.parseInt(request.getParameter("p_Id"));
		int mv    = Integer.parseInt(request.getParameter("mv"));
		int by    =  Integer.parseInt(request.getParameter("by"));
		String ds = request.getParameter("ds");
		String rm = request.getParameter("rm");
		String tg = request.getParameter("tg");
		int fb = Integer.parseInt(request.getParameter("fb"));
		int hb = Integer.parseInt(request.getParameter("hb"));
		
		
		PropertyBean p = new PropertyBean();

	    	p.setProperty_id(p_id);
			p.setMarket_value(mv);
			p.setYear_built(by);
			p.setDwelling_type(ds);
			p.setRoof_material(rm);
			p.setGarage_type(tg);
			p.setFull_baths(fb);
			p.setHalf_baths(hb);
			
			
	    UserEntity user = new UserEntity();
	   
	   
	   
		UserBean userBean = new UserBean();
		userBean = userService.viewUserByUserId(100);
		
		
		  user.setUser_id(userBean.getuserid()); user.setUser_name(userBean.getUsername()); user.setRole(userBean.getRole());
		 user.setPassword(userBean.getPassword()); user.setConfirmPassword(userBean.getCpassword());
		 
	   
	   System.out.println(user);
	   System.out.println(l);
	   System.out.println(p);
	   
		LocationServiceImpl service = new LocationServiceImpl();

		service. addLocationWithProperty(l,p,user);

		modelAndView.setViewName("UserDashboard");

		return modelAndView;
	}

	
	
	@RequestMapping(value="/userDashboard1" , method = RequestMethod.GET)
	public ModelAndView LocationPage() 
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UserDashboard1");
		return modelAndView;
	}
}
