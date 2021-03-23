package com.example.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.User1;
import com.example.repository.UserRepository;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/join")
	public String joinGET() {
		
		return "user_join";
	}
	
	@RequestMapping(value = "/join" , method = RequestMethod.POST)
	public String joinPOST(@ModelAttribute User1 vo,
			@RequestParam(value = "tmpimg",defaultValue = "",
			required = false) MultipartFile imgs) throws IOException {
		if(imgs.getBytes().length > 0) {
			vo.setUserImg(imgs.getBytes());
		}
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changepw = bcpe.encode(vo.getUserpw());
		vo.setUserpw(changepw);
			
		userRepository.save(vo);
		
		return "redirect:/user/join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() {
		return "user_login";
	}
	
//	@RequestMapping(value="/login", method=RequestMethod.POST)
//	public String loginPOST(
//			//login상태를 유지하기 위한 session 필요
//			HttpSession httpSession,
//			@RequestParam(value="userid") String userid,
//			@RequestParam(value="userpw") String userpw) {
//		User1 vo = userRepository.(userid, userpw);
//		
//		if(vo !=null) { //로그인이 성공했다면 세션에 필요한 정보들을 추가함.
//			//세션 기본적으로 30분 동안 자료가 저장됨 => 변경 가능
//			//controller에서 값을 변경하거나 가져올 수 있음
//			//views에서 값을 읽을 수 있음
//			httpSession.setAttribute("USERID", vo.getUserid());
//			httpSession.setAttribute("USERNAME", vo.getUsername());
//		}
//		
//		return "redirect:/user/home";
//	}
	
	@RequestMapping(value = "/list")
	public String listGET(Model model) {
		List<User1> list = userRepository.findAll();
		
		for(User1 vo : list) {
			System.out.println(vo.toString());
			// byte[] => String(base64)
			// import java.util.Base64;
			
			if(vo.getUserImg() !=null) {
				
				String tmp = Base64.getEncoder().encodeToString(vo.getUserImg());
				vo.setBase64( tmp );
				vo.setUserImg(null);
			}
		}
		
		model.addAttribute("list", list);
		//byte[] => string
		
		return "user_list"; //jsp만들기
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deletePOST(
			@RequestParam(value = "userid",defaultValue="",required = false) String userid) {
			
		userRepository.deleteByUserid(userid);
		
		return "redirect:/user/list";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateGET(
			@RequestParam(value="userid",defaultValue="",required = false) String userid,
			Model model) {
			Map<String,Object> map = userRepository.sqlUpdateByUserid(userid);
			model.addAttribute("map", map);
			return "user_update"; //customer폴더의 update.jsp를 표시
		}
		return "redirect:/user/list";
	}

}
