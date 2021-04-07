package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Notification;
import com.example.entity.NotificationReply;
import com.example.repository.NotiRepository;

@Controller
@RequestMapping(value = "noti")
public class NotiController {
	
	@Autowired
	NotiRepository notiRepo;
	
	@GetMapping("manage")
	public String manageGET() {
		return "noti/noti_manage";
	}
	
	@GetMapping("insert")
	public String insertGET() {
		return "noti/noti_insert";
	}
	
	@PostMapping("insert")
	public String insertPOST(@ModelAttribute Notification vo) {
		
		notiRepo.save(vo);
		
		return "redirect:/noti/list";
	}
	
	@GetMapping("/list")
	public String listGET(Model model,
			@RequestParam(value = "txt", defaultValue="", required= false) String txt,
			@RequestParam(value = "page",defaultValue = "0") int page) throws UnsupportedEncodingException {
		
		if(page==0) {
			return "redirect:/noti/list?txt="+URLEncoder.encode(txt,"UTF-8")+"&page=1";
		}
		
		PageRequest pageable = PageRequest.of(page-1, 10);
		
		List<Notification> list = notiRepo.findByTitleIgnoreCaseContainingOrderByNoAsc(txt,pageable);
				//selectQueryOrderByNoDesc();
		model.addAttribute("list", list);
		
		long totPages = notiRepo.countByTitleIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "noti/noti_list";
	}
	
	@RequestMapping(value = "/content")
	public String contentGET(@RequestParam(value="no", defaultValue = "0") Long no,
			Model model
			) {
		Optional<Notification> vo1 = notiRepo.findById(no); 
		Notification vo = vo1.get();
		model.addAttribute("vo", vo);
		
		List<NotificationReply> list = vo.getReplyList();
		model.addAttribute("list", list);
		
		return "noti/noti_content";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String deletePOST(@RequestParam(value = "no") Long no) {
		
		notiRepo.sqlDeleteByNo(no);
		
		return "redirect:/noti/list";
	}

}
