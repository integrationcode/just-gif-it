package com.demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Component;

@Component("passwordDemo")
public class PasswordDemo {
	
	public String getMD5Hash(String plainText) {
		
		//Md4PasswordEncoder encoder = new Md4PasswordEncoder();
		@SuppressWarnings("deprecation")
		MessageDigestPasswordEncoder md5 = new MessageDigestPasswordEncoder("MD5");
		
		
		
		String encrypted = md5.encode(plainText);
		System.out.println("Password Encoded: "+encrypted);
		
		return encrypted;
	}
	
	public String getBCryptHash(String plainText) {
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		String encrypted = bCryptEncoder.encode(plainText);
		System.out.println("Encrypted BCrypt Password: "+encrypted);
		return encrypted;
	}
}
