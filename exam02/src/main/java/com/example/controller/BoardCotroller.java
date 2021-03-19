package com.example.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.service.BoardDAOXML;
import com.example.vo.BoardVO;

@Controller
@RequestMapping(value="/board")
public class BoardCotroller {
	
	@Autowired
	BoardDAOXML bDAOXML;
	
	@RequestMapping(value="/insert" , method = RequestMethod.GET)
	public String insertGET() {
		return "board_insert";
	}
	
	@RequestMapping(value = "/insert" , method = RequestMethod.POST)
	public String insertPOST(@ModelAttribute BoardVO vo) {
		
		System.out.println(vo.toString());
		bDAOXML.insertBoardOne2(vo);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String selectBoardListGET(Model model,
			HttpSession httpSession) {
		httpSession.setAttribute("HIT", 1);
		
		List<BoardVO> brdlist = bDAOXML.selectBoardList2();
		model.addAttribute("brdlist", brdlist);
		return "board_list";
	}
	
	@RequestMapping(value="/content")
	public String contentGET(Model model, @RequestParam(value="brdno", defaultValue = "0") long brdno) {
		//service -> mapper에서 값 가져오기
		BoardVO vo = bDAOXML.selectBoardOne2(brdno);
		//jsp로 전달하기
		model.addAttribute("vo", vo);
		return "board_content"; 
	}
	
	@RequestMapping(value = "/update")
	public String updateGET(Model model, @RequestParam(value="brdno", defaultValue = "0") long brdno) {
		BoardVO vo = bDAOXML.selectBoardOne2(brdno);
		model.addAttribute("vo", vo);
		
		return "board_update";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updatePOST(Model model,
			@ModelAttribute BoardVO vo) {
		System.out.println(vo.toString());
		int no = bDAOXML.updateBoardOne2(vo);
		model.addAttribute("vo", vo);
		
		return "redirect:/board/content?brdno="+no;
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String deletePOST(
		 @RequestParam(value="brdno", defaultValue = "0") long brdno) {
		
		bDAOXML.deleteBoardOne2(brdno);
		return "redirect:/board/list";
	}
}
