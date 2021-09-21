package com.bridgelabz.greetingApp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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

	/**
	 * Purpose : Ability to get greeting message by id
	 * @param id
	 * @return
	 */

   public String getEmployeeByID(int id) {
		AtomicReference<String> greetings = new AtomicReference<>("");
		greetingList.stream()
				.filter(greetingElement -> greetingElement.getId() == id)
				.forEach(greetingElement -> {
					greetings.set(greetingElement.getMessage());
			});
		return String.valueOf(greetings);
   }

   /**
	 * Purpose : To Edit a Greeting Messages in the Repository.
	 * @param id
	 * @param message
	 * @return
	 */

	public GreetingDTO updateGreeting(int id, String message) {
		GreetingDTO greeting = findEmployeeById(id);
		greeting.setMessage(message);
		return greeting;
	}

	/**
	 * Purpose : To find the ID in the Greeting Repository.
	 * @param id
	 * @return
	 */

	private GreetingDTO findEmployeeById(int id) {
		return greetingList.stream()
				.filter(greetingElement -> greetingElement.getId() == id).findFirst()
				.orElseThrow(() -> new RuntimeException("Unable to find any greeting"));
	}
	/**
	 * Purpose : To Delete a Greeting Messages in the Repository.
	 * @param id
	 * @return
	 */

	public String deleteGreeting(int id) {
		GreetingDTO greeting = findEmployeeById(id);
		greetingList.remove(greeting);
		return "Greeting deleted successfully";
	}
}
