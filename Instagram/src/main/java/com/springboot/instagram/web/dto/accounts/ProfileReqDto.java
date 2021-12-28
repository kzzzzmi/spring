package com.springboot.instagram.web.dto.accounts;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;

import lombok.Data;

@Data
public class ProfileReqDto {
	private String name;
	private String username;
	private String website;
	private String introduction;
	private String email;
	private String phone;
	private String gender;
	
	private MultipartFile file;
	
	public User toUserEntity() {
		return User.builder()
				.email(email)
				.name(name)
				.username(username)
				.build();
	}
	
	public UserDtl toUserDtlEntity() {
		return UserDtl.builder()
				.website(website)
				.introduction(introduction)
				.phone(phone)
				.gender(gender)
				.build();
	}
}
