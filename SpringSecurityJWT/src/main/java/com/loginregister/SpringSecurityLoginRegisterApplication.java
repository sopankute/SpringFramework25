package com.loginregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.loginregister.repo.CustomerRepository;

@SpringBootApplication
public class SpringSecurityLoginRegisterApplication {

	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringSecurityLoginRegisterApplication.class, args);
		
		
		CustomerRepository repos = ctx.getBean(CustomerRepository.class);
		System.out.println(repos.getClass().getName());
		
		System.out.println("\nSpringSecurityLoginRegisterApplication.main() | Application Started Successfully...");
		
		ctx.close();
	}

}
