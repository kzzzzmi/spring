package com.spring.study.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.study.service.auth.AuthService;
import com.spring.study.web.dto.SignupReqDto;
import com.spring.study.web.dto.SignupRespDto;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, SignupReqDto signupReqDto) {
		if(signupReqDto.getSubmitFlag() == 1) {
			// 아이디 중복 확인(select)
			SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
			
			model.addAttribute("signupRespDto", signupRespDto);
			return "auth/signup";
		} else {
			// 회원 가입 진행(insert)
			boolean signupSuccessFlag = authService.signup(signupReqDto);
			if(signupSuccessFlag == true) {
				return "redirect:/signin";
			} else {
				return "auth/signup";
			}
		}
		
		
	}
	
}