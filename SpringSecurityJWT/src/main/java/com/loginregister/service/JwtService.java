package com.loginregister.service;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class JwtService {
//	This class handles JWT token generation, validation, and extraction.
	
	private static final String SECRET_KEY = "";  // Change this to a strong key
	
	// Generate JWT Token
	public static String generateToken(String Username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Extract Username from JWT Token
	public static String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// Extract Expiration Date
	public static Date extractExpirationDate(String token) {
		// TODO Auto-generated method stub
		return new Date();
	}
	
	// Extract Claims
//	public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	public static Claims extractAllClaims() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	// Validate JWT Token
	public static boolean validateToken(String token, String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Check if Token is Expired
	private static boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
