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
	
	//ππβ¨πμ€νλ§μΌλ‘ λ°μ΄ν° λ°κΈ° μν΄μππβ¨π
	@ResponseBody
	@PostMapping("/androidRegister")
	public String androidRegister(String userId, String userName, String userPassword, String userTel) {
		Member member=new Member();
		member.setUserId(userId);
		member.setUserName(userName);
		member.setUserPassword(userPassword);
		member.setUserTel(userTel);
		memberService.register(member);
		return "νμκ°μμ±κ³΅";
	}
	
	//ππβ¨πμ€νλ§μΌλ‘ λ°μ΄ν° λ°κΈ° μν΄μππβ¨π
	@ResponseBody
	@PostMapping("/androidLogin")
	public Member androidLogin(String userId, String userPassword, HttpSession session) throws Exception{
		System.out.println(userId + userPassword);
		Member member=memberService.loginCheck(userId);
		System.out.println(member+"dddd");
		if(member==null) {//νμμλ 
			 session.invalidate();
			return null;
		}else if(member.getUserPassword().equals(userPassword)) {//νμμ
			//μΈμμ μΆκ°--> μλΈλ¦Ώ μΈμκ°μ²΄λ₯Ό μ¨μ€HttpSession session
			session.setAttribute("login", member);
			return member;
		}else {//λΉλ²μ€λ₯
			session.invalidate();//λ‘κ·ΈμΈ μ±κ³΅μμλ§ μΈμ μμ΄λκ° μλλ‘μ΄λλ‘ λμ΄κ°.
			return null;
		}
		
	}
	
	
}
