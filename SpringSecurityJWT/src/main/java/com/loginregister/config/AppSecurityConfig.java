package com.loginregister.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.loginregister.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {
	
	@Autowired
	MyUserDetailService  customerService;
	
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider  authProvider = new DaoAuthenticationProvider();
		authProvider.setPasswordEncoder(pwdEncoder());
		authProvider.setUserDetailsService(customerService);
		return authProvider;
	}
	
	@Bean
	public AuthenticationManager autheticateManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain provideSecurity(HttpSecurity httpSecurity) throws Exception  {
		
		httpSecurity.authorizeHttpRequests( (request) -> 
		request.requestMatchers("/register", "/login")		// security not required
				.permitAll()					// give permission
				.anyRequest()					// any request other than "/contact" 
				.authenticated()				// authenticate them
				);
//				 .httpBasic(Customizer.withDefaults())	// using basic authentication
//				 .formLogin(Customizer.withDefaults());	// if access through browser then use form login
													
		return httpSecurity.csrf().disable().build();
	}
	
}
