package com.example.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.entity.User1;

public class MyLoginHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// 권한별 페이지 전환 구현
		
		//User또는 MyUser
//		User1 user = (User1) authentication.getPrincipal();
//		
//		//로그인 도었으면
//		if(user != null) {
//			//System.out.println("아이디 : " + user.getUsername());
//			//System.out.println("이름 : " + user.getName());
//			Collection<GrantedAuthority> roles= user.getAuthorities();
//			for(GrantedAuthority tmp : roles) { //1번만 수행됨.
//				System.out.println("권한 : " + tmp.getAuthority());
//				
//				String url = request.getContextPath() + "/security/home";
//				if (tmp.getAuthority().equals("ADMIN")) {
//					// request.getContextPath() =>  ROOT
//					url = request.getContextPath() + "/security/admin";
//				}
//				else if (tmp.getAuthority().equals("MANAGER")) {
//					url = request.getContextPath() + "/security/manager";
//				}
//				else if (tmp.getAuthority().equals("USER")) {
//					url = request.getContextPath() + "/security/user";
//				}
//				
//				//페이지 이동하기
//				response.sendRedirect(url);
//			}
//		}
		
	}

}
