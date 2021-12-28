package com.spring.study.service.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.domain.user.User;
import com.spring.study.domain.user.UserRepository;
import com.spring.study.web.dto.auth.SigninReqDto;
import com.spring.study.web.dto.auth.SigninRespDto;
import com.spring.study.web.dto.auth.SignupReqDto;
import com.spring.study.web.dto.auth.SignupRespDto;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public SignupRespDto usernameCheck(SignupReqDto signupReqDto) {
		int idCheckCount = userRepository.idCheck(signupReqDto.getUsername());
		if(idCheckCount == 0) {
			return signupReqDto.toResponseDto(true);
		} else {
			return signupReqDto.toResponseDto(false);
		}
	}

	@Override
	public boolean signup(SignupReqDto signupReqDto) {
		User userEntity = signupReqDto.toEntity();
		int insertCount = userRepository.insertUser(userEntity);
		if(insertCount > 0) {
			System.out.println("insert 성공");
			return true;
		} else {
			System.out.println("insert 실패");
			return false;
		}
	}
	
	@Override
	public SigninRespDto signin(SigninReqDto signinReqDto) {
		User userEntity = signinReqDto.toEntity();
		int signinFlag = userRepository.signin(userEntity);
		
		SigninRespDto signinRespDto = signinReqDto.toResponseDto(signinFlag);
		return signinRespDto;
	}
	
	@Override
	public User getUserByUsername(String username) {	
		return userRepository.getUserByUsername(username);
	}

}
