package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.mapper.CustomerMapper;
import com.example.vo.CustomerVO;

//djfjajsTESTasdasdasd

@Controller
@RequestMapping(value="/customer") //url에서 이 코드가 합쳐진다. host를 구별하기 위해 설정
public class CustomerController {
 // test
	@Autowired // DBConnection
	CustomerMapper userMapper;
	
	@RequestMapping(value="/page403",method = RequestMethod.GET)
	public String page403GET() {
		return "/customer/page403";
	}
	
	@RequestMapping(value="/gold",method = RequestMethod.GET)
	public @ResponseBody String goldGET() {
		return "gold페이지";
	}
	
	@RequestMapping(value="/silver",method = RequestMethod.GET)
	public @ResponseBody String silverGET() {
		return "silver페이지";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updatePOST(
			@RequestParam Map<String,Object> map,
			@RequestParam(value="tmpimg") MultipartFile imgs) throws IOException {
		System.out.println("==========================");
		for(String key : map.keySet()) {
			System.out.println(String.format("K:%s,V:%s",key,map.get(key)));
		}
		map.put("userimg", null);
		if(imgs.getBytes().length > 0) {
			map.put("userimg", imgs.getBytes());
		}
		userMapper.updateCustomerOne(map);
		return "redirect:" + "/customer/list";
	}
	
	
	
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateGET(
			@RequestParam(value="userid",defaultValue="",required = false) String userid,
			Model model) {
		if(!userid.equals("")) {
			Map<String,Object> map = userMapper.selectCustomerOne(userid);
			for ( String key : map.keySet()) {
				System.out.println(String.format("K:%s,V:%s",key,map.get(key)));
			}
			model.addAttribute("map", map);
			return "customer/update"; //customer폴더의 update.jsp를 표시
		}
		return "redirect:" + "/customer/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deletePOST(
			@RequestParam(value="userid",defaultValue="",required = false) String userid) {
		//value="userid" => jsp name값
		if(!userid.equals("")) {
			userMapper.deleteCustomerOne(userid);
		}
		
		return "redirect:" + "/customer/list";
	}

	//크롬에서 127.0.0.1:9090/ROOT/customer/login
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGET() {
		return "customer/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginPOST(
			//login상태를 유지하기 위한 session 필요
			HttpSession httpSession,
			@RequestParam(value="userid") String userid,
			@RequestParam(value="userpw") String userpw) {
		CustomerVO vo = userMapper.selectCustomerLogin(userid, userpw);
		
		if(vo !=null) { //로그인이 성공했다면 세션에 필요한 정보들을 추가함.
			//세션 기본적으로 30분 동안 자료가 저장됨 => 변경 가능
			//controller에서 값을 변경하거나 가져올 수 있음
			//views에서 값을 읽을 수 있음
			httpSession.setAttribute("USERID", vo.getUserid());
			httpSession.setAttribute("USERNAME", vo.getUsername());
		}
		
		return "redirect:/customer/home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logoutGET(
			HttpSession httpSession) {
		httpSession.invalidate(); //세션 삭제
		return "redirect:/customer/home";
	}

	//join.jsp를 만들고 아이디,암호,이름,연락처,등록일
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String joinGET() {
		return "customer/join";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String joinPOST(
			@ModelAttribute CustomerVO vo,
			@RequestParam(value="tmpimg") MultipartFile imgs) throws IOException { //ModelAttribute가 모든 객체를 불러옴
		// 이미지를 제외한 값들
		System.out.println(vo.toString());
		
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String changepw = bcpe.encode(vo.getUserpw());
		vo.setUserpw(changepw);
		
		// 이미지 첨부가 되었다면 vo객체에 이미지 추가
		if(imgs.getBytes().length > 0) {
			// 이미지 파일명
			System.out.println(imgs.getOriginalFilename());
			// 이미지 파일 용량
			System.out.println(imgs.getBytes().length);
			vo.setUserimg(imgs.getBytes());
		}
		// vo에 이미지 까지 포함해서 전달
		userMapper.insertCustomerOne(vo);

		// => vo 변수값과 jsp name값이 일치해야만 값이 전달된다.
		//			@RequestParam(value="userid") String userid,
		//			@RequestParam(value="userpw") String userpw,
		//			@RequestParam(value="userpw1") String userpw1,
		//			@RequestParam(value="username") String username,
		//			@RequestParam(value="userphone") String userphone) {
		//		System.out.println(userid);
		//		System.out.println(userpw);
		//		System.out.println(userpw1);
		//		System.out.println(username);
		//		System.out.println(userphone);

		// ---- JSP방식 안씀.
		//		CustomerVO vo = new CustomerVO();
		//		vo.setUserid(userid);  
		// VO객체에 값을 추가한다음 model로 전달

		return "redirect:" + "/customer/join";
	}

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listGET(Model model) {

		List<CustomerVO> customerList = userMapper.selectCustomerList();

		//jsp로 값을 전달
		model.addAttribute("list", customerList);
		return "customer/list"; //views의 customer폴더의 list.jsp 표시
	}

	//이미지 표시하기
	// 타입의 종류들
	// String => jsp파일명
	// CustomerVO => JSONObject {'userid' : 'abc', 'username':'가나다'}
	// List<CustomerVO> => JSONArray [{},{},{}]
	// ResponseEntity<byte[]> => 이미지로 표시됨.

	//<img src="/customer/imagePreview?userid=1" />
	@RequestMapping(value="/imagePreview",method=RequestMethod.GET)
	public ResponseEntity<byte[]> imagePreviewGET(
			@RequestParam("userid") String userid,
			HttpServletRequest request) {
		try {
			//userid에는 1이 보관됨
			CustomerVO vo = userMapper.selectCustomerImgOne(userid);
			byte[] img = vo.getUserimg();
			if(img.length>0) {
				HttpHeaders header = new HttpHeaders();
				header.setContentType(MediaType.IMAGE_JPEG);
				return new ResponseEntity<byte[]>(img, header, HttpStatus.OK);
			}
			return null;
		}
		catch(Exception e) {
			try {
				InputStream in = request.getServletContext().getResourceAsStream(
						"/resources/images/default.jpg");
				byte[] img = IOUtils.toByteArray(in);
						
						if(img.length>0) {
							HttpHeaders header = new HttpHeaders();
							header.setContentType(MediaType.IMAGE_JPEG);
							return new ResponseEntity<byte[]>(img, header, HttpStatus.OK);
						}
				return null;
			}
			catch(Exception e2) {
				return null;
			}
		}
	}
}