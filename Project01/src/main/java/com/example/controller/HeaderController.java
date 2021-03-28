package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Member;
import com.example.repository.HeaderRepository;

@Controller
@RequestMapping(value = "/header")
public class HeaderController {
	
	@Autowired
	HeaderRepository hRepository;

	@RequestMapping(value = "/join")
	public String joinGET() {
		return "header_join";
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String joinPOST(@ModelAttribute Member vo) {
		hRepository.save(vo);
		return "redirect:/home";
	}
}
