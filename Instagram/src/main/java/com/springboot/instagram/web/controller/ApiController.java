package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.config.auth.PrincipalDetails;

@RestController
@RequestMapping("/api")
public class ApiController {

	@PostMapping("/follow/{userId}")
	public int follow(@AuthenticationPrincipal PrincipalDetails principalDetails, @PathVariable int userId) {
		
		return 0;
	}
	
}
