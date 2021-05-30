package com.root.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Component
@ComponentScan (basePackages = {"com.root.controller"})
@EnableWebMvc
public class ObjectFactory implements WebMvcConfigurer {
	static final Logger LOGGER = Logger.getLogger(ObjectFactory.class);
	{
		LOGGER.info("Object factory initialized");
	}
	
	@Bean
	public InternalResourceViewResolver resolver()
	{
		LOGGER.info("view resolver executes");
		return new InternalResourceViewResolver("/",".jsp");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		LOGGER.info("addResourceHandlers executes");
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
}
