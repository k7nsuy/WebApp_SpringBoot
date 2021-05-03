package org.fkpk.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.fkpk.domain.Event;
import org.fkpk.domain.Member;
import org.fkpk.domain.Product;
import org.fkpk.domain.RefrigeProduct;
import org.fkpk.domain.Shop;
import org.fkpk.service.EventService;
import org.fkpk.service.MemberService;
import org.fkpk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/event")
public class EventController {
	@Autowired
	private EventService eventService;
	//이벤트 결과 값 저장
		@ResponseBody
		@PostMapping("/eventRegister")
		public void eventRegister(String memberId, String randomInt) {
			System.out.println(memberId+","+ randomInt);
			Event event=new Event();
			event.setMemberId(Integer.parseInt(memberId));
			int grade = Integer.parseInt(randomInt);
			event.setGrade(grade);
			eventService.eventRegister(event);
		}
		
}
