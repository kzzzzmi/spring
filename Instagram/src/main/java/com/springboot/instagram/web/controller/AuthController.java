package com.springboot.instagram.web.controller;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.instagram.service.AuthService;
import com.springboot.instagram.web.dto.auth.SignupReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final로 인터페이스가 선언되어 있으면 자동으로 Autowired해줌(DI)
@RestController
public class AuthController {
	
	private final AuthService authService;
	
	@PostMapping("/auth/signup")
	public Object signup(@Valid SignupReqDto signupReqDto, BindingResult bindingResult) {
		return authService.validCheck(signupReqDto, bindingResult);
	}
}
