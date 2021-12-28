package com.springboot.instagram.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // Security 관련 설정은 이 클레스에서 한다는 어노테이션
@Configuration     // IoC 등록 -> 설정 관련 객체들을 등록할 때 사용하는 어노테이션
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(); // csrf 비활성화
		
		http.authorizeRequests() // 서버에 요청이 들어오면
			.antMatchers("/", "/index", "/accounts/**") // 해당 요청들은 
			.authenticated() // 모두 인증을 거쳐야한다
			.anyRequest() // 그 외의 모든 요청은
			.permitAll() // 승인해준다(모두 권한을 허가)
			.and() // 그리고
			.formLogin() // 로그인 화면은
			.loginPage("/auth/signin") // 해당 페이지로 GET 요청으로 응답해주고
			.loginProcessingUrl("/auth/signin") // 로그인 submit 요청시 POST 방식으로 /auth/signin 요청을 하라(principalDetailsService를 실행시킴)
			.defaultSuccessUrl("/"); // 로그인에 성공했으면 해당 URL로 이동하라(GET)
	}
}
