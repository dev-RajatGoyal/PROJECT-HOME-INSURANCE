package com.root.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
/**
 * This is ObjectFactory it is used for configuration 
 * 
 */
@Component
@ComponentScan (basePackages = {"com.root.controller","com.root.dao","com.root.service"})
@EnableWebMvc

public class ObjectFactory implements WebMvcConfigurer {
	static final Logger LOGGER = Logger.getLogger(ObjectFactory.class);
	{
		LOGGER.info("Object factory initialized");
	}
	
	/**
	 * this is a InternalResourceViewResolver method it return the view 
	 * 
	 * in this method we pass the parameter prefix,suffix
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver resolver()
	{
		LOGGER.info("view resolver executes");
		return new InternalResourceViewResolver("/",".jsp");
	}
	
	/**
	 * this is a addResourceHandlers method it is used for static resource like :- CSS, html 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOGGER.info("addResourceHandlers executes");
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
}