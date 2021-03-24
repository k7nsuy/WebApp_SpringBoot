package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	//127.0.0.1:9090/ROOT/home
	//127.0.0.1:9090/ROOT/main
	//127.0.0.1:9090/ROOT/
	@RequestMapping(value = "/admin")
	public String adminGET() {
		return "admin";
	}
}
