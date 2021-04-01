package com.example.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.ItemList;
import com.example.repository.ItemRepository;
import com.example.security.MyMember;

@Controller
@RequestMapping(value = "/nav")
public class NavController {

	@Autowired
	ItemRepository itemRepository;
	
	@RequestMapping(value = "/items")
	String itemsGET(Model model, Authentication auth) {
		
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
		
		
		return "nav/nav_items";
	}
}
