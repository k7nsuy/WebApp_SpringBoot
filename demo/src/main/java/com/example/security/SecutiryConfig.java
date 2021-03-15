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

@Configuration
@EnableWebSecurity
public class SecutiryConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bcpe() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bcpe());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		web.ignoring().antMatchers("/css/**", "/js/**","/images/**","/font/**","/lib/**");
		//resources의 url은 무시한다.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//접근 할 수 있는 페이지 설정
		
		
		//127.0.0.1:9090/ROOT/vvip/aaa
		http.authorizeRequests()
		.antMatchers("/Gold", "/Gold/*").hasAnyAuthority("Gold") // url , * => 접근 할 수있는 모든 페이지
		.antMatchers("/Silver", "/Silver/*").hasAnyAuthority("Silver")
		.antMatchers("/Bronze", "/Bronze/*").hasAnyAuthority("Bronze")
		.anyRequest().permitAll()
		.and()
		
		//로그인 설정
		.formLogin()
		.loginPage("/customer/login") //127.0.0.1:9090/ROOT/login
		.loginProcessingUrl("/customer/loginProcess") //<form action="loginProcess" />
		.usernameParameter("userid") //<input type="text" name="userid" />
		.passwordParameter("userpw") //<input type"password" name="userpw />
		.permitAll()
		.defaultSuccessUrl("/customer/home") // 로그인 성공시 127.0.0.1:9090/ROOT/customer/home 으로 이동
		.and()
		
		// 로그아웃
		.logout()
		.logoutUrl("/customer/logout")
		.logoutSuccessUrl("/customer/home")
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.permitAll()
		.and()
		
		//접근불가 페이지 설정
		.exceptionHandling()
		.accessDeniedPage("/page403");
		
		//비권장!! CSRF공격에 취약!! => 일일이 jsp에서 csrfname과 token을 넣지 않아도 되게 해준다. 
		//하지만 보안에 취약하므로 practice할 때만 사용
		http.csrf().disable();
	}
	
}
