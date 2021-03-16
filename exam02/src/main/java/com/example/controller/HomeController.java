package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//127.0.0.1:9092/ROOT/member
@RequestMapping(value="/member")
public class HomeController {
	
	//127.0.0.1:9092/ROOT/member/main
	@RequestMapping(value="/main",method = RequestMethod.GET)
	public String mainGET() {
		//WEB-INF/views/member/member_main.jsp파일 return
		return "member_main";
	}
}
