package com.bridgelabz.greetingApp.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.greetingApp.dto.GreetingDTO;
import com.bridgelabz.greetingApp.entity.GreetingEntity;

@Service
public class GreetingService {
	private static final String template = "Hello, %s %s!";
	private List<GreetingDTO> greetingList = new ArrayList<>();
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
	/**
	 * Purpose : Ability to store multiple messages in greeting object
	 			 and display the list of object to get the messages.
	 * @param greeting
	 * @return
	 */

	public GreetingDTO addGreeting(GreetingDTO greeting) {
		greetingList.add(greeting);
		return greeting;
	}

	public List<GreetingDTO> getGreeting() {
		return greetingList;
	}

	
	
}
