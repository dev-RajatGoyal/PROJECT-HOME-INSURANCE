package com.root.config;

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
	
	{
		System.out.println("Object factory initialized");
	}
	
	@Bean
	public InternalResourceViewResolver resolver()
	{
		System.out.println("view resolver executes");
		return new InternalResourceViewResolver("/",".jsp");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("addResourceHandlers executes");
		registry.addResourceHandler("/**").addResourceLocations("/");
	}
}
