package com.root.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.TextFormat.ParseException;
import com.root.bean.HomeOwnerBean;
import com.root.bean.LocationBean;
import com.root.bean.PasswordBean;
import com.root.bean.PolicyBean;
import com.root.bean.PropertyBean;
import com.root.bean.QuoteBean;
import com.root.bean.UserBean;
import com.root.exception.InvalidEmailORUserIdException;
import com.root.service.HomeOwnerService;
import com.root.service.HomeOwnerServiceImpl;
import com.root.service.LocationServiceImpl;
import com.root.service.PolicyServiceImpl;
import com.root.service.QuoteServiceImpl;
import com.root.service.UserServiceImpl;

/**
 * This is a HomeController Class
 * 
 * it intersect all the client request by @RequestMapping
 * 
 */
@Controller
public class HomeController {
	static final Logger LOGGER = Logger.getLogger(HomeController.class);

	@Autowired
	UserServiceImpl userService;
	
	@Autowired
	HomeOwnerServiceImpl homeOwner;

	@Autowired
	QuoteServiceImpl quoteService;
	
	@Autowired
	LocationServiceImpl locationService;
	
	@Autowired
	PolicyServiceImpl policyService;
	
	/**
	 * This handler mapping used to show the Welcome page to the user
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView showHomePage()
	{	
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		LOGGER.info("Welcome Page");
		return modelAndView;
	}
	
	
	/**
	 * This handler mapping used to show the Admin Login page to the user
	 */
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public ModelAndView AdminLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("AdminLogin");
		LOGGER.info("Show update password page");
		return modelAndView;
	}
	
	
	
	/**
	 * This handler mapping used to show the Admin Dashboard to the user
	 */
	@RequestMapping(value="/adminDashboard", method=RequestMethod.POST)
	public ModelAndView AdminLoginSuccessful(@RequestParam int userId, @RequestParam String password, Model model) throws ClassNotFoundException, SQLException
	{	
		ModelAndView modelAndView = new ModelAndView();
		UserBean user = new UserBean();
		user = userService.viewUserByUserId(userId);
		
		if(user.getuserid()==userId && user.getPassword().equals(password) && user.getRole().equals("Admin"))
		{
			
			
			ArrayList<PolicyBean> viewAllPolicy = (ArrayList)policyService.viewAllPolicy();
			model.addAttribute("listPolicies",viewAllPolicy);
			
			
			modelAndView.setViewName("AdminDashboard3");	
			LOGGER.info("Admin Login Successfully and move to Admindashboard");
		}
		else
		{
			modelAndView.setViewName("Error");
			LOGGER.info("Login Failed");
		}
		return modelAndView;
	}
	
	
	
	
	
	/**
	 * This handler mapping used to show the UserDashboard to the user after successfully login
	 */

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
		
		
		PolicyBean policy= new PolicyBean();
		policy=policyService.viewPolicyByUserId(userId);
		
		model.addAttribute("policy",policy);
		
		
		if(user.getuserid()==userId && user.getPassword().equals(password) && user.getRole().equals("User"))
		{
			//response.sendRedirect("UserDashboard2");
			modelAndView.setViewName("UserDashboard3");	
			LOGGER.info("User Login Successfully and move to user dashboard");
		}
		else
		{
			model.addAttribute("msg1" ,"username or password doesn't match");
			modelAndView.setViewName("Error");
			LOGGER.info("Login Failed");
		}
		return modelAndView;
	}


	/**
	 * This handler mapping used to show the Registration Page to the user
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView UserRegistration() {
		System.out.println("HomeController.UserRegistration()");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Registration");
		LOGGER.info("Show Registration Page to User");
		return modelAndView;
	}

	
	/**
	 * This handler mapping used to if user registered successfully 
	 * 
	 * user will move to home page
	 */
	@RequestMapping(value = "/registersuccess", method = RequestMethod.POST)
	public ModelAndView RegisterSuccessful(UserBean user, Model model) throws ClassNotFoundException, SQLException {

		//model.addAttribute("username",user.getUsername());
		ModelAndView modelAndView = new ModelAndView();
		LOGGER.info("HomeController.RegisterSuccessful()");
		LOGGER.info(user.getCpassword() + "===" + user.getPassword());
		String userName = null;
		
		String userRole = "User";
		user.setRole(userRole);
		
		if (user.getPassword().equalsIgnoreCase(user.getCpassword()))
			userName = userService.insertUser(user);
		//System.out.println(userName + "user name");
		if (!userName.equals(null)) {
			modelAndView.setViewName("home");
			LOGGER.info("User registration success");

		} else {
			modelAndView.setViewName("userregistrationFailure");
			LOGGER.info("User registration Failed");
		}

		return modelAndView;
	}


	/**
	 * This handler mapping used to show the HomeOwner Page to the user
	 */
	@RequestMapping(value="/homeowner" , method = RequestMethod.POST)
	public ModelAndView HomeOwnerInsert(HttpServletRequest request,HttpServletResponse response, Model model,@Valid  @ModelAttribute("home") HomeOwnerBean bean ,BindingResult br) 
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		
		int userId = (Integer)session.getAttribute("userId");
		System.out.println("inside homeOwner handler methood "+userId+" logged in");
		
		LocationBean location = new LocationBean();
		model.addAttribute("location",location);

		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);
		
		PolicyBean policy= new PolicyBean();
		model.addAttribute("policy",policy);

		UserBean user = new UserBean();
		user.setuserid(userId);
		bean.setUser(user);

		
		if(br.hasErrors())
		{
	    	model.addAttribute("msg" ,"Oops ! something Went Wrong , Please check Your Fields");
			modelAndView.setViewName("UserDashboard3");
			LOGGER.info("User not able to fill Homeowner details");	
		}else {
			
			try
			{
			homeOwner.insertHomeOwner(bean);
			model.addAttribute("msg" ,"HomeOwner Details Add Successfully");
			modelAndView.setViewName("UserDashboard3");
			LOGGER.info("User able to fill Homeowner details");
			}
			catch(Exception e)
			{System.out.println("Error in homeowner");
				model.addAttribute("msg" ,"HomeOwner Details did not Add Successfully");
				
				}
	    	
		}
		
		return modelAndView;
	}


	/**
	 * This handler mapping used to show the Location And Property Page to the user
	 */
	@RequestMapping(value="/location" , method = RequestMethod.POST)
	public ModelAndView submitPropertyAndLocation(HttpServletRequest request,HttpServletResponse response, Model model, @Valid @ModelAttribute("location")  LocationBean location, BindingResult br) throws ClassNotFoundException, SQLException
	{
		ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		int userId = (Integer)session.getAttribute("userId");
		System.out.println("inside submitPropertyAndLocation handler methood "+userId+" logged in");

		PropertyBean property = location.getProperty();
		UserBean user = location.getUser();

		UserBean userBean = userService.viewUserByUserId(userId);
		//userBean.setuserid(userId);
		location.setUser(userBean);

		
		
		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);
		
		PolicyBean policy= new PolicyBean();
		model.addAttribute("policy",policy);

	
		model.addAttribute("user",user);
		
		if(br.hasErrors())
		{
			model.addAttribute("msg","Oops! you have entered wrong data. Please check your fields");
			modelAndView.setViewName("UserDashboard3");
			
		}else {
			locationService.addLocationWithProperty(location, property, userBean);
			int quote_Id = quoteService.addQuote(location.getLocation_id());
			QuoteBean quoteBean =quoteService.findQuoteById(quote_Id);
			
			model.addAttribute("quote",quoteBean);

			model.addAttribute("msg" ,"Location and Property Details Add Successfully");
			modelAndView.setViewName("UserDashboard3");
		}
		
		LOGGER.info("User able to fill Property and Location details");
		return modelAndView;

	}


	/**
	 * This handler mapping used to Open the form of update PAssword Page
	 */
	/*
	 * @RequestMapping(value = "/update", method = RequestMethod.GET) public
	 * ModelAndView updatePassword() { ModelAndView modelAndView = new
	 * ModelAndView(); modelAndView.setViewName("updatePassword");
	 * LOGGER.info("Show update password page"); return modelAndView; }
	 */

	
	/**
	 * by this handler mapping password update successfully its return on updateSuccess page
	 */
	/*
	 * @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	 * public ModelAndView updatePassword(UserBean user) throws
	 * ClassNotFoundException, SQLException { ModelAndView modelAndView = new
	 * ModelAndView(); System.out.println(user); UserBean bean =
	 * userService.updatePassword(user); //
	 * System.out.println(userName+"user name"); if (bean != null) {
	 * modelAndView.setViewName("updateSuccess");
	 * LOGGER.info("Update Password Successfully"); } else
	 * modelAndView.setViewName("updateFail");
	 * LOGGER.info("Update Password failed"); return modelAndView; }
	 */
	
	
	
	
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updatePassword() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("updatePassword");
		return modelAndView;
	}
//----------------------------getting access password form data -----------------------
	//its try to store bean object
	@RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
	public ModelAndView updatePassword(PasswordBean pass , HttpSession session) throws ClassNotFoundException, SQLException, InvalidEmailORUserIdException {
		ModelAndView modelAndView = new ModelAndView();
		//calling userservice updatepassword methods by passing bean id  
		PasswordBean bean = userService.updatePassword(pass);
		if (bean != null) {
			modelAndView.setViewName("sendOTP");
			//generating otp for user
			Random rand=new Random();		
			int otp=rand.nextInt(10000);
			// writing email code here
	         String subject="Otp From RealCoderz";
			 String message="your otp is "+otp+". Don't share any one its valid 5 minutes ";
	         String to=pass.getEmail();
			
			boolean flag=userService.sendEmail(subject, message, to);
				session.setAttribute("myotp", otp);
				session.setAttribute("email", pass.getEmail());
				session.setAttribute("userid",pass.getUserid());
		}
		else {
			modelAndView.setViewName("updateFail");
			
		}
		return modelAndView;
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------	@RequestMapping(value = "/submitotp", method = RequestMethod.POST)
	@RequestMapping(value = "/submitotp", method = RequestMethod.POST)
	public ModelAndView submitotp(PasswordBean pass , HttpSession session) throws ClassNotFoundException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		PasswordBean bean=null;
		pass.setUserid((int)session.getAttribute("userid"));
		pass.setEmail((String)session.getAttribute("email"));
		int otp=(int)session.getAttribute("myotp");
		if(otp==pass.getOtp())
			bean = userService.submitotp(pass);
		if (bean != null) 
			modelAndView.setViewName("home");
		else
			modelAndView.setViewName("updateFail");
		return modelAndView;
	}
//--------------------------------------------------------------------------------------------------------------------------------------------------------
	
	
	
	
	
	

	

	
	/**
	 * This handler mapping used to logout
	 */
	@RequestMapping(value="/logout")
	public ModelAndView logout(HttpServletRequest request,HttpServletResponse response ) throws IOException
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);

		session.invalidate();  
		modelAndView.setViewName("redirect:/");
		LOGGER.info("Back to Home after logout");

		return modelAndView;
	}
	
	/**
	 * This handler mapping used to show the buypolicy 
	 */
	@RequestMapping(value="/buypolicy", method = RequestMethod.POST)
	public ModelAndView buyPolicy(Model model,HttpServletRequest request,HttpServletResponse response,@ModelAttribute("policy") PolicyBean policyBean ) throws IOException, ClassNotFoundException, SQLException, 
	
	ParseException, java.text.ParseException
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		LocationBean location = new LocationBean();
		model.addAttribute("location",location);

		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);
		
		PolicyBean policy = new PolicyBean();
		model.addAttribute("policy",policy);
		
		String sDate1=policyBean.getEffectiveDate();
		Date d1=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		
		String sDate2=policyBean.getEndDate();
		Date d2=(Date) new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);
		
		
		long difference_In_Time= d2.getTime() - d1.getTime();
		System.out.println(difference_In_Time);

		long diff= (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
		int term=(int)diff;
	    policyBean.setPolicyTerm(term);
		policyBean.setPolicyStatus("InActive");
		
		int userId = (Integer)session.getAttribute("userId");
		
	    LocationBean locationBean = locationService.findLocationByUserId(userId);
	    QuoteBean quoteBean = quoteService.findQuoteByLocationId(locationBean.getLocation_id());
	    
	    UserBean user = new UserBean();
	    user.setUserid(userId);

		PolicyServiceImpl service = new PolicyServiceImpl();
		
		service.buyPolicy(policyBean,user,quoteBean);
		
		model.addAttribute("msg" ,"policy Added Successfully");
		
		modelAndView.setViewName("UserDashboard3");
		LOGGER.info("Back to Home after logout");

		return modelAndView;
	}
	
	/**
	 * This handler mapping used to show the buypolicy 
	 */
	@RequestMapping(value="/viewAllPolicy", method = RequestMethod.GET)
	public ModelAndView viewAllPolicy(Model model,HttpServletRequest request,HttpServletResponse response) throws ClassNotFoundException, SQLException
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}	
		ArrayList<PolicyBean> viewAllPolicy = (ArrayList)policyService.viewAllPolicy();
		
		
		model.addAttribute("listPolicies",viewAllPolicy);
		modelAndView.setViewName("policyView");
		return modelAndView;
	}
	
	
	
	/**
	 * This handler mapping used for active Policy
	 */
	@RequestMapping(value="/activePolicy")
	public ModelAndView activePolicy(HttpServletRequest request,HttpServletResponse response ) throws IOException, ClassNotFoundException, SQLException
	{
		int id= Integer.parseInt(request.getParameter("policyId"));
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		policyService.renewPolicy(id);
		modelAndView.setViewName("AdminDashboard3");
		return modelAndView;
	}
	
	/**
	 * This handler mapping used for Cancel Policy
	 */
	@RequestMapping(value="/cancelPolicy")
	public ModelAndView cancelPolicy(HttpServletRequest request,HttpServletResponse response ) throws IOException, ClassNotFoundException, SQLException
	{
		int id= Integer.parseInt(request.getParameter("policyId"));
		
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		policyService.canclePoicy(id);

		modelAndView.setViewName("AdminDashboard3");
		return modelAndView;
	}
	
	
	/**
	 * This handler mapping used for renew Policy
	 */
	@RequestMapping(value="/renewPolicy")
	public ModelAndView renewPolicy(HttpServletRequest request,HttpServletResponse response ) throws IOException, ClassNotFoundException, SQLException
	{
		int id= Integer.parseInt(request.getParameter("policyId"));
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		policyService.renewPolicy(id);

		modelAndView.setViewName("AdminDashboard3");
		return modelAndView;
	}
	
	
	/**
	 * This handler mapping used for viewing Summary page
	 */
	@RequestMapping(value="/ViewSummary")
	public ModelAndView ViewSummary(HttpServletRequest request,HttpServletResponse response, Model model ) throws IOException, ClassNotFoundException, SQLException
	{
		
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		  int userId = (Integer)session.getAttribute("userId");
		
		HomeOwnerService homeownerService = new HomeOwnerServiceImpl();
		HomeOwnerBean homeownerBean = homeownerService.findHomeownerByUserId(userId);
		
		if(homeownerBean !=null)
		{
		model.addAttribute("ownerPage", homeownerBean);

		LocationBean locationBean = locationService.findLocationByUserId(userId);
		model.addAttribute("summary2", locationBean);

		QuoteBean quoteBean1 = quoteService.findQuoteByLocationId(locationBean.getLocation_id());
		model.addAttribute("quotes", quoteBean1);
		
		modelAndView.setViewName("ViewSummary");
		
		}else {
         	model.addAttribute("msg" ,"please provide the homeOwner,Location and property Details first");
	    	
	    	LocationBean location = new LocationBean();
			model.addAttribute("location",location);

			HomeOwnerBean home = new HomeOwnerBean();
			model.addAttribute("home",home);
			
			PolicyBean policy= new PolicyBean();
			model.addAttribute("policy",policy);
	    	modelAndView.setViewName("UserDashboard3");
		}

		
		return modelAndView;
	}
	
	
	/**
	 * This handler mapping used for retrive Quote
	 */
	@RequestMapping(value="/retriveQuote")
	public ModelAndView retriveQuote(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ClassNotFoundException, SQLException
	{

		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
	    int userId = (Integer)session.getAttribute("userId");
	
	    PolicyBean policy= new PolicyBean();
		model.addAttribute("policy",policy);
	    LocationBean locationBean = locationService.findLocationByUserId(userId);
	    
	    if(locationBean != null)
	    {
		QuoteBean quoteBean1 = quoteService.findQuoteByLocationId(locationBean.getLocation_id());
		model.addAttribute("quote", quoteBean1);
		modelAndView.setViewName("RetriveQuote");
	    }else
	    {
	    	model.addAttribute("msg" ,"please provide the homeOwner,Location and property Details first");
	    	
	    	LocationBean location = new LocationBean();
			model.addAttribute("location",location);

			HomeOwnerBean home = new HomeOwnerBean();
			model.addAttribute("home",home);
			
	
	    	modelAndView.setViewName("UserDashboard3");
	    }
		
		return modelAndView;
	}
	
	
	
	/**
	 * This handler mapping used for cancel Policy By UserId Policy
	 */
	@RequestMapping(value="/cancelPolicyByUser")
	public ModelAndView cancelPolicyByUser(HttpServletRequest request,HttpServletResponse response,Model model ) throws IOException, ClassNotFoundException, SQLException
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
	    int userId = (Integer)session.getAttribute("userId");
	    
	    LocationBean location = new LocationBean();
		model.addAttribute("location",location);

		HomeOwnerBean home = new HomeOwnerBean();
		model.addAttribute("home",home);
		
		PolicyBean policy= new PolicyBean();
		model.addAttribute("policy",policy);
				
		PolicyBean policy1 =policyService.viewPolicyByUserId(userId);
		
		policyService.canclePoicy(policy1.getPolicyId());
		
		model.addAttribute("msg" ,"policy Cancel Successfully");

		modelAndView.setViewName("UserDashboard3");
		return modelAndView;
	}
	
	@RequestMapping(value="/premiumDetails")
	public ModelAndView premiumDetails(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			modelAndView.setViewName("redirect:/");
		}
		modelAndView.setViewName("PremiumDetails");
		return modelAndView;
		
	}
	
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exception()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Error");
		return modelAndView;
		
	}

}