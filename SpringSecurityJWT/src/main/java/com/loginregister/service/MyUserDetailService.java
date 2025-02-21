package com.loginregister.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.loginregister.entities.Customer;
import com.loginregister.repo.CustomerRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	public boolean saveCustomer(Customer c) {

		// password encoding
		String encodedPwd = pwdEncoder.encode(c.getPassword());
		c.setPassword(encodedPwd);

		Customer savedCustomer = customerRepo.save(c);

		return savedCustomer.getCid() != null;
	}

	@Override // to load the user data for authentication purpose
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Customer c = customerRepo.findByEmail(email); // getting data from Repo layer

		return new User(c.getEmail(), c.getPassword(), Collections.emptyList());
	}

}
