package com.bezkoder.spring.datajpa.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.SecureRandom; 

@CrossOrigin(origins = "http://localhost:8080") 
@RestController
public class SecureMessegeController {
	@GetMapping("/api/v1/password")
	public String GenerateRandomPassword() {
		String generatedPassword = generatePassword(8);
		return generatedPassword;
	}

	private String generatePassword(int len) {
		// ASCII range - alphanumeric (0-9, a-z, A-Z)
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		// each iteration of loop choose a character randomly from the given ASCII range
		// and append it to StringBuilder instance
		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}
		return sb.toString();
	}
}