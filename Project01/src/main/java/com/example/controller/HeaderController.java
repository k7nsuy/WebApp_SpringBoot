package com.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Authority;
import com.example.entity.ItemList;
import com.example.entity.Member;
import com.example.entity.OrderList;
import com.example.repository.AuthorityRepository;
import com.example.repository.ItemRepository;
import com.example.repository.MemberRepository;
import com.example.repository.OrderlistRepository;
import com.example.security.MyMember;
import com.example.security.MyMemberDetailService;

@Controller
@RequestMapping(value = "/header")
public class HeaderController {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	AuthorityRepository authRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	OrderlistRepository orderRepository;
	
	@GetMapping("join")
	public String joinGET(Model model) {
		
		List<Authority> list = authRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "header/header_join";
	}
	
	@PostMapping("join")
	public String joinPOST(@ModelAttribute Member vo) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changePw = bcpe.encode(vo.getUserPass());
		vo.setUserPass(changePw);
		
		vo.setAuth( new Authority() ); 
		
		memberRepository.save(vo);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/login")
	public String loginGET() {
		return "header/header_login";
	}
	
	@GetMapping("mypage")
	public String mypageGET() {
		return "header/header_mypage";
		
	
		
	}
	
	@GetMapping("orderlist")
	public String orderlistGET() {
		return "header/header_orderlist";
	}
	
	@PostMapping("orderlist")
	public String orderlistPOST(@ModelAttribute ItemList list,
			@RequestParam(value = "mNum") long memno,
			Model model) {
		
		
		return "redirect:/header/orderlist";
	}
}
