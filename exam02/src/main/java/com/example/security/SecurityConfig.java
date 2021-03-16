package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //이 파일은 환경설정용 파일이다.라고 정의
@EnableWebSecurity //Security를 사용하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**","/image/**","/font/**");
		// 이 설정값들의 보안을 무시한다.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/member", "/member/**") //URL이 /member 또는 /member/~~인 것의 권한이
		.hasAnyAuthority("ADMIN","MANAGER","USER") //ADMIN,MANAGER,USER인 사용자만 가능
		.anyRequest().permitAll() // 나머지는 모두 접근 가능
		.and();
	}
	
}
