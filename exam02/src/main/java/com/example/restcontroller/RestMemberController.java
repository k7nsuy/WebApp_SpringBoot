package com.example.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.MemberMapper;
import com.example.vo.MemberVO;

@RestController
@CrossOrigin("*") //CORS(cross origin resources sharing)를 처리하기 위해 같은 서버(도메인)이 
//아닌 경우에서 접근가능 =>json , script 등 과 같은 문서를 공유하기 위함


@RequestMapping(value="/rest")
public class RestMemberController {

	@Autowired
	MemberMapper memberMapper;
	
//	//127.0.0.1:9092/ROOT/rest/join.json
//	@RequestMapping(value="/join.json",
//			consumes = MediaType.ALL_VALUE,
//			produces = MediaType.APPLICATION_JSON_VALUE,
//			method= {RequestMethod.GET, RequestMethod.POST})
//	@ResponseStatus(value = HttpStatus.OK)
//	public Map<String, Object> joinGETPOST(	@RequestBody MemberVO vo ){
//		Map<String, Object> map = new HashMap<String, Object>();
//		//암호 변경해서 vo에 다시 넣음
//		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//		String changePw = bcpe.encode(vo.getUserpw());
//		vo.setUserpw(changePw);
//		
//		memberMapper.insertMemberOne(vo);
//		map.put("ret", 1);
//		return map;
//	}
	
	//127.0.0.1:9092/ROOT/rest/delete.json
	@RequestMapping(value="/delete.json",
		consumes = MediaType.ALL_VALUE,
		produces = MediaType.APPLICATION_JSON_VALUE,
		method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseStatus(value = HttpStatus.OK)
	public Map<String, Object> deleteGETPOST( @RequestBody MemberVO vo,
			HttpSession httpSession){
		Map<String, Object> map = new HashMap<String, Object>();

		int ret = memberMapper.deleteMemberOne(vo);
		
		// delete가 성공했을 때 세션을 만료시키겠다. => 삭제했을 때 로그인으로 계속 남아있지 않고 세션을 만료해 
		// 로그아웃을 해준다.
		if(ret >= 1) {
			httpSession.invalidate();
		}
		
		map.put("ret", ret);
		
		return map;
	}
}
