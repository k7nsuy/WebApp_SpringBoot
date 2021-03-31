package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Authority;
import com.example.entity.Member;
import com.example.repository.AuthorityRepository;
import com.example.repository.MemberRepository;
import com.example.security.MyMember;

@Controller
public class HomeController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	AuthorityRepository authRepository;
	
	@RequestMapping(value = "/home")
	public String homeGET(Model model, Authentication auth) {

		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		return "home";
	}

}
