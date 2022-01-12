package com.springboot.instagram.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.springboot.instagram.domain.user.User;
import com.springboot.instagram.domain.user.UserDtl;

import lombok.Data;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

	private static final long serialVersionUID = 1L;
	
	private User user;
	private UserDtl userDtl;
	private Map<String, Object> attributes;
	
	public PrincipalDetails(User user, UserDtl userDtl) {
		this.user = user;
		this.userDtl = userDtl;
	}
	
	public PrincipalDetails(User user, UserDtl userDtl, Map<String, Object> attributes) {
		this.user = user;
		this.userDtl = userDtl;
		this.attributes = attributes;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection = new ArrayList<>();
		collection.add(new GrantedAuthority() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// 계정이 만료되었는지 확인 (계정 완전 만료)
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// ex)비밀번호 5번 이상 틀리면 잠김
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// 자격 증명 만료가 되지 않았는지 확인(OTO, 2차 인증, ...)
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 휴먼 계정 (계정 임시 만료)
		return true;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public String getName() {
		return (String)attributes.get("name");
	}

}
