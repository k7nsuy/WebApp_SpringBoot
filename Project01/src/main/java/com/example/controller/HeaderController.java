package com.example.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Authority;
import com.example.entity.Member;
import com.example.repository.AuthorityRepository;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping(value = "/header")
public class HeaderController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	AuthorityRepository authRepository;
	

	@RequestMapping(value = "/join")
	public String joinGET(Model model) {
		
		List<Authority> list = authRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "header/header_join";
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String joinPOST(@ModelAttribute Member vo) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changePw = bcpe.encode(vo.getUserPass());
		vo.setUserPass(changePw);
		
		vo.setAuthority( new Authority() ); 
		
		memberRepository.save(vo);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/login")
	public String loginGET() {
		return "header/header_login";
	}
}
