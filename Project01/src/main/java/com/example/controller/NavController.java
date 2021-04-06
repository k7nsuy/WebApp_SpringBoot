package com.example.controller;

import java.util.Base64;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.ItemList;
import com.example.entity.Member;
import com.example.repository.ItemRepository;
import com.example.repository.MemberRepository;
import com.example.security.MyMember;

@Controller
@RequestMapping(value = "/nav")
public class NavController {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@RequestMapping(value = "/items")
	String itemsGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
			long memberNum = vo.getMembernumber();
			
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				
				model.addAttribute("Authority", tmp);
				model.addAttribute("mNum", memberNum);
			}
		}
		
		List<ItemList> list = itemRepository.findAll();
		
		for(ItemList vo : list) {
			System.out.println(vo.toString());
			// byte[] => String(base64)
			// import java.util.Base64;

			if(vo.getItemImage() !=null) {

				String tmp = Base64.getEncoder().encodeToString(vo.getItemImage());
				vo.setBase64( tmp );
				vo.setItemImage(null);
			}
		}
		
		model.addAttribute("list", list);
		
		
		return "nav/nav_items";
	}
	
	@RequestMapping(value = "/best")
	String bestGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		List<ItemList> list = itemRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "nav/nav_best";
	}
	
	@RequestMapping(value = "/noti")
	String notiGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "nav/nav_noti";
	}
	
	@RequestMapping(value = "/question")
	String questionGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "nav/nav_question";
	}
	
	@RequestMapping(value = "/review")
	String reviewGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		
		return "nav/nav_review";
	}
}
