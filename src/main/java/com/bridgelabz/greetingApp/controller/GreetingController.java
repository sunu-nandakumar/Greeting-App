package com.bridgelabz.greetingApp.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingApp.dto.GreetingDTO;
import com.bridgelabz.greetingApp.entity.GreetingEntity;
import com.bridgelabz.greetingApp.service.GreetingService;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	/**
	 * Purpose : Ability to return JSON data using GET method
	 * 
	 * @param name
	 * @return
	 */

	@GetMapping("/getGreeting")
	public GreetingEntity greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingEntity(counter.incrementAndGet(), String.format(template, name));
	}
	
	
	
	/**
	 * Purpose : Ability to return JSON data using POST method
	 * 
	 * @param greeting
	 * @return
	 */
	
	@PostMapping("/postGreeting")
    public GreetingEntity sayHello(@RequestBody GreetingEntity greeting) {
		return new GreetingEntity(counter.incrementAndGet(), String.format(template, greeting.getContent()));
    }
	
	
	 
	
	/**
	 * Purpose : Ability to return JSON data using PUT method
	 * 
	 * @param counter
	 * @param contentName
	 * @return
	 */
	
	@PutMapping("/putGreeting/{counter}")
    public GreetingEntity sayHello(@PathVariable int counter, @RequestParam(value = "content") String contentName) {
		return new GreetingEntity(counter, String.format(template, contentName));
    }
	/**
	 * Purpose : initialising and creating object for GreetingService.class
	 */
	
	@Autowired
	private GreetingService greetingService;
	
	/**
	 * Purpose : Ability to return message using GET method from the service class
	 * 
	 * @return
	 */
	
	@GetMapping(value = "/getMessage")
	public ResponseEntity<String> getMessage() {
	    return new ResponseEntity<>(greetingService.getMessage(), HttpStatus.OK);
	}
	/**
	 * Purpose : Ability to return message using GET method from the service class
	 * @param fname
	 * @param lname
	 * @return
	 */

	@GetMapping(value = "/getGreetingMessage")
	public ResponseEntity<String> greeting(@RequestParam(value = "fname", defaultValue = "World") String fname,
			@RequestParam(value = "lname", defaultValue = "") String lname) {
		return new ResponseEntity<>(greetingService.getGreeting(fname, lname), HttpStatus.OK);
	}
	/**
	
	 * Purpose : Ability to store multiple Greeting Message using POST method
	 			 and display the messages using GET method
	 * @return
	 */

	@GetMapping(value = "/getGreetingDetails")
	public ResponseEntity<List<GreetingDTO>> getGreeting() {
	    return new ResponseEntity<>(greetingService.getGreeting(), HttpStatus.OK);
	}

	@PostMapping(value = "/addGreetingDetails")
	public ResponseEntity<GreetingDTO> addGreeting(@RequestBody GreetingDTO greeting) {
	    return new ResponseEntity<>(greetingService.addGreeting(greeting), HttpStatus.OK);
	}
	@GetMapping(value = "/getGreetingByID")
	public ResponseEntity<String> getEmployeeByID(@RequestParam(name = "id") int id) {
		return new ResponseEntity<>(greetingService.getEmployeeByID(id), HttpStatus.OK);
	}
	
	

}
