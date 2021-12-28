package com.spring.study.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.domain.user.User;
import com.spring.study.domain.user.UserRepository;

//@Component
@Controller
//@Service
//@Repository
//@Configuration
public class PageController {
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexForm() {
		return "index/index";
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String signinForm() {
		return "auth/signin";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		return "auth/signup";
	}
	
	@RequestMapping(value = "/signup-ajax", method = RequestMethod.GET)
	public String signupAjax() {
		return "auth/signupAjax";
	}
	
	@RequestMapping(value = "/signin-ajax", method = RequestMethod.GET)
	public String signinAjax() {
		return "auth/signinAjax";
	}
}
