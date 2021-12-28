package com.spring.study.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.study.domain.user.User;
import com.spring.study.service.auth.AuthService;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;

@Controller
public class AuthController {

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Model model, SignupReqDto signupReqDto) {
		if (signupReqDto.getSubmitFlag() == 1) {
			// 아이디 중복 확인(select)
			SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);

			model.addAttribute("signupRespDto", signupRespDto);
			return "auth/signup";
		} else {
			// 회원 가입 진행(insert)
			boolean signupSuccessFlag = authService.signup(signupReqDto);
			if (signupSuccessFlag == true) {
				return "redirect:/signin";
			} else {
				return "auth/signup";
			}
		}
	}

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signin(Model model, HttpServletRequest request, SigninReqDto signinReqDto) {
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		
		if(signinRespDto.getSigninFlag() == 2) {
			// 로그인 성공
			HttpSession session = request.getSession();
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("principal", loginUser);
			return "redirect:/index";
		} 
		
		model.addAttribute("signinRespDto", signinRespDto);
		
		return "auth/signin";
	}
	
	@ResponseBody // 이 어노테이션을 사용하면 view resolver가 아닌 진짜 string 값을 리턴하게 됨
	@RequestMapping(value = "/signup/username-check", method = RequestMethod.GET)
	public Object signupAjax(SignupReqDto signupReqDto) {
		SignupRespDto signupRespDto = authService.usernameCheck(signupReqDto);
		return signupRespDto;
	}
	// jackson이 Object 리턴 시 JSON으로 리턴됨
	
	@ResponseBody // Object -> JSON    spring boot에는 자동적으로 라이브러리가 추가되어 있음 jackson
	@RequestMapping(value = "/signin/ajax", method = RequestMethod.POST)
	public Object signinAjax(@RequestBody SigninReqDto signinReqDto, HttpServletRequest request) { // Jackson 라이브러리에서 JSON 데이터를 객체로 변환시켜서 넣음
		SigninRespDto signinRespDto = authService.signin(signinReqDto);
		if(signinRespDto.getSigninFlag() == 2) {
			HttpSession session = request.getSession();
			User loginUser = authService.getUserByUsername(signinRespDto.getUsername());
			session.setAttribute("pricipal", loginUser);
		}
		return signinRespDto;
	}

}
