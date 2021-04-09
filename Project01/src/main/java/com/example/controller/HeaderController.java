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
import org.springframework.security.core.Authentication;
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
		
		
		return "header/header_join";
	}
	
	@PostMapping("join")
	public String joinPOST(@ModelAttribute Member vo) {
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changePw = bcpe.encode(vo.getUserPass());
		vo.setUserPass(changePw);
		
		
		vo.setAuth( new Authority() ); 
		
		System.out.println(vo);
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
	public String orderlistGET(Authentication auth,
			Model model) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
			long memberNum = vo.getMembernumber();
		
		List<OrderList> list = orderRepository.findByMember_MemberNumber(memberNum);
		
		model.addAttribute("list", list);
		
		}
		
		return "header/header_orderlist";
	}
	
	@PostMapping("orderlist")
	public String orderlistPOST(@RequestParam(value = "no") long no,
			@RequestParam(value = "mNum") long memno,
			Model model) {
		
		Optional<ItemList> iList = itemRepository.findById(no);
		ItemList ivo = iList.get();
		System.out.println(ivo);
		
		Optional<Member> mList = memberRepository.findById(memno);
		Member mvo = mList.get();
		System.out.println(mvo);
		
		OrderList o1 = new OrderList();
		o1.setMember(mvo);
		o1.setItem(ivo);
		
		System.out.println(o1);
		orderRepository.save(o1);
		
		return "redirect:/header/orderlist";
	}
}
