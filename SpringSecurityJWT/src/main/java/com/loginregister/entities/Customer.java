package com.loginregister.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Data;


@Data
@Entity
public class Customer {
	
//	id, name, email, pwd, phone, 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cid;
	private String name;
	private String email;
	private String password;
	private Long phone;
	
}
