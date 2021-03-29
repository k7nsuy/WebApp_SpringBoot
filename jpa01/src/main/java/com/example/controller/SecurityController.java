package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

@Controller
public class SecurityController {

	@Autowired
	CustomerRepository cRespository;
	
	@RequestMapping(value = "/login")
	public String loginGET() {
		return "security_login";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinGET() {
		return "security_join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinPOST(@ModelAttribute Customer vo) {
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changePw = bcpe.encode(vo.getCstpw());
		vo.setCstpw(changePw);
		
		
		
		cRespository.save(vo);
		return "security_join";
	}
	
}
