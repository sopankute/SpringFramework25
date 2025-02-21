package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import lombok.SneakyThrows;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	
	@SuppressWarnings("removal")
	@Bean
	@SneakyThrows
	public SecurityFilterChain appSecurity(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests( (request) -> 
			request.requestMatchers("/contact")		// security not required
					.permitAll()					// give permission
					.anyRequest()					// any request other than "/contact" 
					.authenticated()				// authenticate them
					).httpBasic(Customizer.withDefaults())	// using basic authentication
					 .formLogin(Customizer.withDefaults());	// if access through browser then use form login
				
		return httpSecurity.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager inMemmoryUsers() {
		// this will override credentials of application.properties file
		UserDetails u1 = User.withDefaultPasswordEncoder().username("ashokit").password("ashokit@123").build();
		UserDetails u2 = User.withDefaultPasswordEncoder().username("raju").password("raju@123").build();
		UserDetails u3 = User.withDefaultPasswordEncoder().username("john").password("john@123").build();
		
		return new InMemoryUserDetailsManager(u1, u2, u3);
	}
	
}
