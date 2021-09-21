package com.bridgelabz.greetingApp.service;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	/**
	 * Purpose : To return the String message to the Controller
	 * 
	 * @return
	 */
	public String getMessage() {
		return "Hello World";
	}
}
