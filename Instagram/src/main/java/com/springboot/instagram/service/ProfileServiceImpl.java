package com.springboot.instagram.service;

import org.springframework.stereotype.Service;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;
import com.springboot.instagram.web.dto.profile.ProfileRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProfileServiceImpl implements ProfileService {
	
	private final UserRepository userRepository;
	
	@Override
	public ProfileRespDto getProfile(String username) {
		User userEntity = userRepository.getUserByUsername(username);
		ProfileRespDto profileRespDto = new ProfileRespDto();
		if(userEntity != null) {
			UserDtl userDtlEntity = userRepository.getUserDtlById(userEntity.getId());
			profileRespDto.setUserId(userEntity.getId());
			profileRespDto.setUsername(username);
			profileRespDto.setProfile_img(userDtlEntity.getProfile_img());
			profileRespDto.setIntroduction(userDtlEntity.getIntroduction());
		}
		return profileRespDto;
	}
}
