package com.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
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
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.ItemList;
import com.example.entity.Member;
import com.example.repository.MemberRepository;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("manage")
	public String memberGET() {
		return "member/member_manage";
	}
	
	@RequestMapping(value = "/join")
	public String insertGET() {
		return "member/member_join";
	}
	
	@RequestMapping(value = "/join",method = RequestMethod.POST)
	public String insertPOST(@ModelAttribute Member vo) {
		memberRepository.save(vo);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping(value = "/list")
	public String listGET(Model model,
			@RequestParam(value = "txt", defaultValue="", required= false) String txt,
			@RequestParam(value = "page",defaultValue = "0") int page) throws UnsupportedEncodingException {
		
		if(page==0) {
			return "redirect:/member/list?txt="+URLEncoder.encode(txt,"UTF-8")+"&page=1";
		}
		
		PageRequest pageable = PageRequest.of(page-1, 10);
		List<Member> list = memberRepository.findByUserNameIgnoreCaseContainingOrderByMemberNumAsc(txt,pageable);
		
		model.addAttribute("list", list);
		
		long totPages = memberRepository.countByuserNameIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "member/member_list";
	}
	
	@GetMapping("update")
	public String updateGET(@RequestParam(value = "no") Long no,
			Model model) {
		
		Optional<Member> vo = memberRepository.findById(no);
		Member vo2 = vo.get();
		
		model.addAttribute("vo2", vo2);
		
		return "member/member_update";
	}
	
	@PostMapping("update")
	public String updatePOST(@ModelAttribute Member vo
	) {
		
		 memberRepository.save(vo);
		
		return "redirect:/member/list";
		
	}
	
	@PostMapping("delete")
	public String deletePOST(@RequestParam(value = "no") long no) {
		
		memberRepository.deleteById(no);
		
		return "redirect:/member/list";
	}
	
	@GetMapping("changepass")
	public String changePassGET(@RequestParam(value = "no") long no,
			Model model) {
		
		Member vo = memberRepository.getOne(no);
		vo.getUserPass();
		
		model.addAttribute("vo", vo);
		
		return "member/member_changepass";
	}
	
	@PostMapping("changepass")
	public String changePassPOST(@RequestParam(value = "userPass") Long pass) {
		
		
		return "redirect:/member/list";
	}
	
}
