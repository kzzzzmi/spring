package com.springboot.instagram.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.instagram.config.auth.PrincipalDetails;

@Controller
public class PageController {

	@GetMapping({"/", "index",})
	public String indexForm(@AuthenticationPrincipal PrincipalDetails principalDetails) { // 로그인만 되어 있으면 세션처럼 쓸 수 있음
		return "index";
	}
	
	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin";
	}
	
	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup";
	}
	
	@GetMapping("/accounts/edit") // 1. model 이용 el 표션식 데이터 전달, 2. 자바스크립트에서 ajax 이용해서 각 객체의 value 값에 넣어줌
	public String accountEditForm(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
		return "accounts/accounts_edit";
	}
	
	@GetMapping("/accoutns/password/change") // 1. model 이용 el 표션식 데이터 전달, 2. 자바스크립트에서 ajax 이용해서 각 객체의 value 값에 넣어줌
	public String accountPasswordForm() {
		return "accounts/accounts_password";
	}
	
	@GetMapping("/upload")
	public String uploadForm() {
		return "upload/upload";
	}
}
