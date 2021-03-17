package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//Service 객체 불러오기
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	//암호화 적용
	@Autowired
	public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(BCryptPasswordEncoder());
	}
	
	//암호화를 위한 객체 생성
	//환경설정에서는 @Bean을 이용하여 생성
	// BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	@Bean
	public BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**","/images/**","/fonts/**","/rest/**");
		// 이 설정값들의 보안을 무시한다.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//			.antMatchers("/member", "/member/**") // 
//			.hasAnyAuthority("ADMIN","MANAGER","USER") //
			.anyRequest().permitAll() // 나머지는 모두 접근 가능
			.and()
		
			//로그인 설정
		.formLogin()
			.loginPage("/member/login")
			.loginProcessingUrl("/member/loginProcess") //action
			.usernameParameter("userid")
			.passwordParameter("userpw")
			.permitAll()
			.defaultSuccessUrl("/member/main")
			.and()
			
			//로그아웃 설정
		.logout()
			.logoutUrl("/member/logout") //POST방식 CSRF가 정보포함
			.logoutSuccessUrl("/member/main") //완료시 이동페이지
			.invalidateHttpSession(true) //세션 삭제
			.clearAuthentication(true) //인증내용 지우기
			.permitAll() //로그인 하지 않아도 접근 페이지
			.and();
		
	}
	
}
