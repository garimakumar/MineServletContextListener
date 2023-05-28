package com.example.projects;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MySessionAttributeListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session=event.getSession();
		System.out.println(event.getName()+"\t" +event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
