package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	//127.0.0.1:9090/ROOT/home
	//127.0.0.1:9090/ROOT/main
	//127.0.0.1:9090/ROOT/
	@RequestMapping(value = {"/home","/main","/"})
	public String homeGET() {
		return "home";
	}
}
