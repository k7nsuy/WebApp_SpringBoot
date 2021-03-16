package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapper.MemberMapper;
import com.example.vo.MemberVO;



@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Autowired
	MemberMapper memberMapper;
	
	
	//POST를 만들지 않음. 대신 RestController(화면 깜박임을 없애고 바로 실행하는 기능)를 이용.
	@RequestMapping(value="/ajax")
	public String ajaxGET() {
		return "member_ajax";
	}

	@RequestMapping(value="/main",method=RequestMethod.GET)
	public String memberGET() {
		return "member_main";
	}

	@RequestMapping(value="/join",method = RequestMethod.GET)
	public String joinGET() {
		return "member_join";
	}

	@RequestMapping(value="/join",method = RequestMethod.POST)
	public String joinPOST(
			@ModelAttribute MemberVO vo) {
		//MemberVO에서 toString을 이용해서 전달받는 vo값을 콘솔에 출력 
		System.out.println(vo.toString());

		//암호 변경해서 다시 넣음 (security)
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changepw = bcpe.encode(vo.getUserpw());
		vo.setUserpw(changepw);

		memberMapper.insertMemberOne(vo);

		return "redirect:/member/main";
	}

	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String loginGET() {
		return "member_login";
	}

	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String loginPOST(
			HttpSession httpSession,
			@RequestParam(value="userid") String userid,
			@RequestParam(value="userpw") String userpw
			) {

		MemberVO vo = memberMapper.selectMemberLogin(userid,userpw);

		if(vo!=null) {
			httpSession.setAttribute(userid, vo.getUserid());
			httpSession.setAttribute(userpw, vo.getUserpw());
		}

		return "redirect:/member/main";
	}

	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logoutGET(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/member/main";
	}

	@RequestMapping(value="/update",method = RequestMethod.GET)
	public String updateGET(
			@RequestParam(value="userid",defaultValue="",required = false) String userid,
	Model model) {
		if(!userid.equals("")) {
			Map<String,Object> map = memberMapper.selectMemberOne(userid);
//			for ( String key : map.keySet()) {
//				System.out.println(String.format("K:%s,V:%s",key,map.get(key)));
//			}
			model.addAttribute("map", map);
		}
		return "redirect:/member/list";
	}

//	@RequestMapping(value="/update",method = RequestMethod.POST)
//	public String updatePOST(Model model) {
//		Map<String,Object> map = memberMapper.updateMember
//				//			for ( String key : map.keySet()) {
//				//				System.out.println(String.format("K:%s,V:%s",key,map.get(key)));
//				//			}
//				model.addAttribute("map", map);
//		return "redirect:/member/list";
//	}
}
