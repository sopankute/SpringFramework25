package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecurityApp02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApp02Application.class, args);
		System.out.println("\nSpringSecurityApp02Application.main() | Consumer Application Started Sucessfully...");

		String url = "http://localhost:8080/msg";
		
		// REST API is secured the nuse 
		HttpHeaders header = new HttpHeaders();
		header.setBasicAuth("ashok", "ashok@123");
		System.out.println("SpringSecurityApp02Application.main() | HttpHeaders:"+header);	// [Authorization:"Basic YXNob2s6YXNob2tAMTIz"]
		
		HttpEntity<String> reqEntity = new HttpEntity<>(header);
		System.out.println("SpringSecurityApp02Application.main() | HttpEntity(headers) : "+reqEntity);		// <[Authorization:"Basic YXNob2s6YXNob2tAMTIz"]>
		
		RestTemplate rt = new RestTemplate();
		System.out.println("SpringSecurityApp02Application.main() | RestTemplate : "+rt);
		
		ResponseEntity<String> resEntity = rt.exchange(url, HttpMethod.GET, reqEntity, String.class);
		System.out.println("SpringSecurityApp02Application.main() | ResponseEntity : "+resEntity);		// <200 OK OK,Good Morning Shiv-Prabhat,.......
		
		System.out.println(resEntity.getBody());	// Good Morning Shiv-Prabhat
		
		
		
		
		
		// If REST API not secured then use 
//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<String> response = rt.getForEntity(url, String.class);
//		System.out.println(response.getBody());
	}

}
