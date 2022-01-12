package com.springboot.instagram.config.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;
import com.springboot.instagram.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PrincipalDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // username으로 조회하고 세션에 등록하겠다
		User userEntity = userRepository.getUserByUsername(username);
		if(userEntity == null) {
			return null;
		} else {
			UserDtl userDtl = userRepository.getUserDtlById(userEntity.getId());
			return new PrincipalDetails(userEntity, userDtl); // @AuthenticationPrincipal이라는 섹션 객체에 넣어줌
		}
	}
	
}
