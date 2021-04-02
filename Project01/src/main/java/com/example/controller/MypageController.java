package com.example.controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.security.MyMember;

@Controller
@RequestMapping(value = "mypage")
public class MypageController {
	

	
	@GetMapping("update")
	public String updateGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "mypage/mypage_update";
	}
	
	@GetMapping("orderlist")
	public String orderlistGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "mypage/mypage_orderlist";
	}
	
	@GetMapping("ship")
	public String shipGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "mypage/mypage_ship";
	}
	
	@GetMapping("myreview")
	public String reviewGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "mypage/mypage_review";
	}
	
	@GetMapping("myquestion")
	public String questionGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "mypage/mypage_question";
	}
	

}
