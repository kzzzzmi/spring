package com.spring.study.web.dto.auth;

import com.spring.study.domain.user.User;

import lombok.Data; 

@Data
public class SignupReqDto {
	private String username;
	private String password;
	private String name;
	private String email;
	
	private int submitFlag;
	
	public SignupRespDto toResponseDto(boolean idChekFlag) {
		return SignupRespDto.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.idCheckFlag(idChekFlag)
				.build();
	}
	
	public User toEntity() {
		return User.builder()
				.username(username)
				.password(password)
				.name(name)
				.email(email)
				.build();
	}
}
