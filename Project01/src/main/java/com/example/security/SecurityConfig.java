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
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyMemberDetailService userDetailsService;
	
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
		web.ignoring().antMatchers("/css/**", "/js/**","/images/**","/fonts/**","/lib/**");
		//resources의 url은 무시한다.
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//접근 할 수 있는 페이지 설정
		
		
		//127.0.0.1:9090/ROOT/vvip/aaa
		//권한에 따른 페이지 설정 ex) 127.0.0.1:9090/ROOT/admin은 adminAutority권한만 접근가능
		http.authorizeRequests()
		.antMatchers("/admin", "/admin/*").hasAnyAuthority("ADMIN") // url , * => 접근 할 수있는 모든 페이지
		.anyRequest().permitAll()
		.and()
		
		//로그인 설정
		//화면은 만들디만 실제 처리는 security에서 설정
		.formLogin()
		.loginPage("/login") //127.0.0.1:9090/ROOT/login
		.loginProcessingUrl("/loginProcess") //<form action="loginProcess" />
		.usernameParameter("userId") //<input type="text" name="username" />
		.passwordParameter("userPass") //<input type"password" name="password />
		.permitAll()
		.defaultSuccessUrl("/home") // 로그인 성공시 127.0.0.1:9090/ROOT/home 으로 이동
//		.successHandler(new MyLoginHandler()) //권한 별 페이지 전환 구현
		.and()
		
		// 로그아웃
		.logout()
		.logoutUrl("/header/logout") //로그아웃 수행할 페이지 url 단, post로 전송되어야 함
		.logoutSuccessUrl("/home") //로그아웃 성공시 이동할 페이지
		.invalidateHttpSession(true) //세션삭제
		.clearAuthentication(true) //인증정보 지우기
		.permitAll() //모든 사용자 접근가능
		.and()
		
		//접근불가 페이지 설정
		.exceptionHandling()
		.accessDeniedPage("/page403") //접근 불가 페이지면 /ROOT/page403으로 이동
		.and();
		
		//비권장!! CSRF공격에 취약!! => 일일이 jsp에서 csrfname과 token을 넣지 않아도 되게 해준다. 
		//하지만 보안에 취약하므로 practice할 때만 사용
	}
}
