package com.bridgelabz.greetingApp.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	private static final String template = "Hello, %s %s!";
	/**
	 * Purpose : To return the String message to the Controller
	 * 
	 * @return
	 */
	public String getMessage() {
		return "Hello World";
	}

	/**
	 * Purpose : To return the String message to the Controller
	 * @param fname
	 * @param lname
	 * @return
	 */
	
	public String getGreeting(String fname, String lname) {
		return String.format(template, fname, lname);
	}
}
