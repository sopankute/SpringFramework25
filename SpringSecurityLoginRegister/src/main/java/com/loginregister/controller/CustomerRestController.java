package com.loginregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginregister.entities.Customer;
import com.loginregister.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	AuthenticationManager authManager;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(@RequestBody Customer cust) {
		
		boolean status = customerService.saveCustomer(cust);
		
		if(status) {
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody Customer cust) {
		
		UsernamePasswordAuthenticationToken token 	// contain username and Password
							= new UsernamePasswordAuthenticationToken(cust.getEmail(), cust.getPassword());
		
		// authenticate login credentials ie. username and password
		Authentication authenticate = authManager.authenticate(token);	
		
		boolean status = authenticate.isAuthenticated();		// confirm authentication
		
		if(status) {
			return new ResponseEntity<String>("Successfull login", HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Login Failed", HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
