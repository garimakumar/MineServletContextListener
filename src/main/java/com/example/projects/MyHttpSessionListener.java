package com.example.projects;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyHttpSessionListener implements HttpSessionListener{

	static int count;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		
		System.out.println("Session created");
		HttpSession session=se.getSession();
		System.out.println(session.getAttribute("username")+"\t"+(++count));
		}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("Session Destroyed");
	}

}
