package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/nav")
public class NavController {

	@RequestMapping(value = "/items")
	String itemsGET() {
		return "nav/nav_items";
	}
}
