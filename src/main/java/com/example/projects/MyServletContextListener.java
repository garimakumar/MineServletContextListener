package com.example.projects;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContext context=sce.getServletContext();
		String driver=context.getInitParameter("driver");
		String url=context.getInitParameter("url");
		String username=context.getInitParameter("username");
		String password=context.getInitParameter("password");
		Driverdetails details=new Driverdetails(driver, url, username, password);
		context.setAttribute("driverInfo", details);
		System.out.println("Context Object Initialized");
		
	}

}
