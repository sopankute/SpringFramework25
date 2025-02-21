package com.example.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/welcome")
	public String getWelCome() {
		return "Good Morning Shiv-Prabhat, Welcome!!";
	}
	
	@GetMapping("/greet")
	public String getGreet() {
		return "Good Evening.....";
	}
	
	@GetMapping("/contact")
	public String getContactInfo() {
		return "Please call me : +91 4765345654";
	}
}
