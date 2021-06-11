package com.root.frontcontroller;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.root.config.ObjectFactory;

public class FrontControllerInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	static final Logger LOGGER = Logger.getLogger(FrontControllerInitializer.class);

	@Override
	protected Class<?>[] getRootConfigClasses() {
		LOGGER.info("getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		LOGGER.info("getServletConfigClasses");
		return new Class[] {ObjectFactory.class};
	}

	@Override
	protected String[] getServletMappings() {
		LOGGER.info("getServletMappings");
		return new String[] {"/"};
	}

}
