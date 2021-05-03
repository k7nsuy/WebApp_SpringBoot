package org.fkpk.controller;

import javax.servlet.http.HttpSession;

import org.fkpk.domain.Member;
import org.fkpk.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//🎇🎉✨🎆스프링으로 데이터 받기 위해서🎇🎉✨🎆
	@ResponseBody
	@PostMapping("/androidRegister")
	public String androidRegister(String userId, String userName, String userPassword, String userTel) {
		Member member=new Member();
		member.setUserId(userId);
		member.setUserName(userName);
		member.setUserPassword(userPassword);
		member.setUserTel(userTel);
		memberService.register(member);
		return "회원가입성공";
	}
	
	//🎇🎉✨🎆스프링으로 데이터 받기 위해서🎇🎉✨🎆
	@ResponseBody
	@PostMapping("/androidLogin")
	public Member androidLogin(String userId, String userPassword, HttpSession session) throws Exception{
		System.out.println(userId + userPassword);
		Member member=memberService.loginCheck(userId);
		System.out.println(member+"dddd");
		if(member==null) {//회원아님 
			 session.invalidate();
			return null;
		}else if(member.getUserPassword().equals(userPassword)) {//회원임
			//세션에 추가--> 서블릿 세션객체를 써줌HttpSession session
			session.setAttribute("login", member);
			return member;
		}else {//비번오류
			session.invalidate();//로그인 성공시에만 세션 아이디가 안드로이드로 넘어감.
			return null;
		}
		
	}
	
	
}
