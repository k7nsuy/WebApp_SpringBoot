package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping(value = "")
	public String adminGET() {
		return "admin";
	}
	
	@GetMapping("noti")
	public String notiGET() {
		return "admin/admin_noti";
	}
	
}