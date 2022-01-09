package com.springboot.instagram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springboot.instagram.config.oauth2.PrincipalOauth2UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // Security 관련 설정은 이 클레스에서 한다는 어노테이션
@Configuration     // IoC 등록 -> 설정 관련 객체들을 등록할 때 사용하는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // csrf 비활성화
		
		http.authorizeRequests() // 서버에 요청이 들어오면
			.antMatchers("/", "/index", "/accounts/**", "/upload/**", "/follow/**") // 해당 요청들은 
			.authenticated() // 모두 인증을 거쳐야한다
			.anyRequest() // 그 외의 모든 요청은
			.permitAll() // 승인해준다(모두 권한을 허가)
			.and()
			.formLogin() // 로그인 화면은
			.loginPage("/auth/signin") // 해당 페이지로 GET 요청으로 응답해주고
			.loginProcessingUrl("/auth/signin") // 로그인 submit 요청시 POST 방식으로 /auth/signin 요청을 하라(principalDetailsService를 실행시킴)
			.defaultSuccessUrl("/") // 로그인에 성공했으면 해당 URL로 이동하라(GET)
			.and()
			.oauth2Login()
			.loginPage("/auth/signin")
			.userInfoEndpoint()
			/*
			 * 1. 코드받기(인증)
			 * 2. 엑세스 토큰 발급(권한)
			 * 3. 사용자 프로필 정보 가져옴
			 * 4. 사용자 프로필 정보를 가지고 우리 사이트에 자동으로 회원가입을 진행(서비스에서 진행)  
			 */
			.userService(principalOauth2UserService)
			.and()
			.defaultSuccessUrl("/");
	}
}
