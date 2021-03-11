package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="customer")
@Controller
public class HomeController {
	
	//127.0.0.1:9090/jsp01/home.do(은행) => GET방식
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeGET(HttpSession httpSession) {
		System.out.println(httpSession.getAttribute("AOP"));
		return "home";
		//views에 있는 home.jsp를 화면에 표시 .jsp는 application properties에서 설정하여 생략.
	} 
	@RequestMapping(value="/home", method=RequestMethod.POST)
	public String homePOST() {
		return "home";
	}
	//127.0.0.1:9090/jsp01/main => GET방식
	@RequestMapping(value="/main", method=RequestMethod.GET)
	public String mainGet() {
		return "home";
	}
	@RequestMapping(value="/main", method=RequestMethod.POST)
	public String mainPost() {
		return "home";
	}
}
