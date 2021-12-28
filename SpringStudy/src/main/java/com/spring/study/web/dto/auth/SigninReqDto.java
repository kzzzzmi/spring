package com.spring.study.web.dto.auth;

import java.util.Map;

import com.spring.study.domain.user.User;

import lombok.Data;

@Data
public class SigninReqDto {
	private String username;
	private String password;
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.build();
	}
	
	public SigninRespDto toResponseDto(int signinFlag) {
		return SigninRespDto.builder()
				.username(username)
				.password(password)
				.signinFlag(signinFlag)
				.build();
	}
}
