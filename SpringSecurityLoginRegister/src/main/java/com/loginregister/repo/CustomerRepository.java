package com.loginregister.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.loginregister.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	public Customer findByEmail(String email);
}
