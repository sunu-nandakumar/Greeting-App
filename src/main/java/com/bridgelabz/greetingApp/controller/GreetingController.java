package com.bridgelabz.greetingApp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingApp.entity.GreetingEntity;

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
    public GreetingEntity sayHello(@RequestBody Greeting greeting) {
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
	
	

}
