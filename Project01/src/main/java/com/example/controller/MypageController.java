package com.example.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Authority;
import com.example.entity.Member;
import com.example.repository.MemberRepository;
import com.example.repository.OrderlistRepository;
import com.example.security.MyMember;

@Controller
@RequestMapping(value = "mypage")
public class MypageController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("update")
	public String updateGET(Model model, Authentication auth) {
		
		MyMember vo = (MyMember)auth.getPrincipal();

		if(auth != null) {
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		if(vo !=null) {
			String userid = vo.getUserid();
			
			Member mm = memberRepository.findByUserId(userid);
			
			model.addAttribute("vo", mm);
		}
		
		return "mypage/mypage_update";
	}

	@PostMapping("update")
	public String updatePOST(@ModelAttribute Member vo) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changePw = bcpe.encode(vo.getUserPass());
		vo.setUserPass(changePw);
		
		vo.setAuth( new Authority() ); 
		
		memberRepository.save(vo);
		
		return "redirect:/header/mypage";
		
	}
	
	@GetMapping("orderlist")
	public String orderlistGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
			long memno = vo.getMembernumber();
			
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
				model.addAttribute("memno", memno);
				
			
				
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
