package com.example.resthateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	private static final String TEMPLATE = "Hello, %s!";
	
	@RequestMapping("/greeting")
	public HttpEntity<Greeting> greeting(
			@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greeting = new Greeting(String.format(TEMPLATE, name));
		greeting.add(
				linkTo(
						methodOn(GreetingController.class)
						.greeting(name)
				)
				.withSelfRel()
		);
		greeting.add(
				linkTo(
						methodOn(GreetingController.class)
						.otherGreeting(name)
				)
				.withRel("other")
		);
		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}
	
	@GetMapping("/otherGreeting")
	public HttpEntity<Greeting> otherGreeting(
			@RequestParam(value = "name", defaultValue = "Duniya") String name) {
		Greeting dusraGreeting = new Greeting("Hi, " + name);
		return new ResponseEntity<>(dusraGreeting, HttpStatus.OK);
	}
}
