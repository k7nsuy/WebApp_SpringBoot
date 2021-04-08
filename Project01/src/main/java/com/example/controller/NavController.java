package com.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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
import com.example.entity.Notification;
import com.example.entity.NotificationReply;
import com.example.entity.Review;
import com.example.repository.ItemRepository;
import com.example.repository.MemberRepository;
import com.example.repository.NotiReplyRepository;
import com.example.repository.NotiRepository;
import com.example.repository.ReviewRepository;
import com.example.security.MyMember;

@Controller
@RequestMapping(value = "/nav")
public class NavController {

	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	NotiRepository notiRepo;
	
	@Autowired
	NotiReplyRepository notireplyRepo;
	
	@Autowired
	ReviewRepository reviewRepo;
	
	@RequestMapping(value = "/items")
	String itemsGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
			long memberNum = vo.getMembernumber();
			
			System.out.println(memberNum);
			
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				
				model.addAttribute("Authority", tmp);
				model.addAttribute("mNum", memberNum);
			}
		}
		
		List<ItemList> list = itemRepository.findAll();
		
		for(ItemList vo : list) {
			System.out.println(vo.toString());
			// byte[] => String(base64)
			// import java.util.Base64;

			if(vo.getItemImage() !=null) {

				String tmp = Base64.getEncoder().encodeToString(vo.getItemImage());
				vo.setBase64( tmp );
				vo.setItemImage(null);
			}
		}
		
		model.addAttribute("list", list);
		
		
		return "nav/nav_items";
	}
	
	@RequestMapping(value = "/best")
	String bestGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		List<ItemList> list = itemRepository.findAll();
		
		model.addAttribute("list", list);
		
		return "nav/nav_best";
	}
	
	@RequestMapping(value = "/noti")
	String notiGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		List<Notification> list = notiRepo.findAll();
		//selectQueryOrderByNoDesc();
		model.addAttribute("list", list);
		
		
		return "nav/nav_noti";
	}
	
	@RequestMapping(value = "/noticontent")
	public String contentGET(@RequestParam(value="no", defaultValue = "0") Long no,
			Model model
			) {
		Optional<Notification> vo1 = notiRepo.findById(no); 
		Notification vo = vo1.get();
		model.addAttribute("vo", vo);
		
		List<NotificationReply> list = vo.getReplyList();
		model.addAttribute("list", list);
		
		return "nav/nav_noti_content";
	}
	
	@RequestMapping(value = "/navreply")
	public String replyGET(@RequestParam(value="no", defaultValue = "0") Long no,
			Model model) {
		
		Optional<Notification> vo1 = notiRepo.findById(no); 
		Notification vo = vo1.get();
		model.addAttribute("vo", vo);
		
		return "nav/nav_reply";
	}
	
	@RequestMapping(value = "/navreply",method = RequestMethod.POST)
	public String replyPOST(@ModelAttribute NotificationReply vo,
			@RequestParam(value = "no" ) Long no) {
		
		// 외래키 값을 받아오는 객체를 만들어서 저장
		Optional<Notification> vo1 = notiRepo.findById(no); 
		Notification vo2 = vo1.get();
		vo.setNoti(vo2);
		
		notireplyRepo.save(vo);
		
		return "redirect:/nav/noticontent?no="+no;
	}
	
	@RequestMapping(value = "/question")
	public String questionGET(Model model, Authentication auth) {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		return "nav/nav_question";
	}
	
	@RequestMapping(value = "/review")
	public String reviewGET(Model model, Authentication auth,
			@RequestParam(value = "txt", defaultValue="", required= false) String txt,
			@RequestParam(value = "page",defaultValue = "0") int page) throws UnsupportedEncodingException {
		
		if(auth != null) {
			MyMember vo = (MyMember)auth.getPrincipal();
		
			Collection<GrantedAuthority> roles = vo.getAuthorities(); 
			for(GrantedAuthority tmp : roles) {
				System.out.println(tmp);
				model.addAttribute("Authority", tmp);
			}
		}
		
		if(page==0) {
			return "redirect:/nav/review?txt="+URLEncoder.encode(txt,"UTF-8")+"&page=1";
		}
		
		PageRequest pageable = PageRequest.of(page-1, 10);
		List<Review> list = reviewRepo.findByReviewTitleIgnoreCaseContainingOrderByReviewNumberAsc(txt,pageable);
		
		for(Review vo : list) {
			System.out.println(vo.toString());
			// byte[] => String(base64)
			// import java.util.Base64;

			if(vo.getReviewImage() !=null) {

				String tmp = Base64.getEncoder().encodeToString(vo.getReviewImage());
				vo.setBase64( tmp );
				vo.setReviewImage(null);
			}
		}
		
		model.addAttribute("review", list);
		
		long totPages = reviewRepo.countByReviewTitleIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "nav/nav_review";
	}
	
	@GetMapping("reviewinsert")
	public String reviewInsertGET() {
		
		
		return "nav/nav_review_insert";
	}
	
	@PostMapping("reviewinsert")
	public String reviewInsertPOST(@ModelAttribute Review vo,
			@RequestParam(value = "img" ,defaultValue = "",
			required = false) MultipartFile imgs) throws IOException {
		
		if(imgs.getBytes().length > 0) {
			vo.setReviewImage(imgs.getBytes());
		}
		
		reviewRepo.save(vo);
		
		return "redirect:/nav/review";
	}
}
