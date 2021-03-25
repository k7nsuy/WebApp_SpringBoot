package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.ExBoard;
import com.example.entity.ExBoardReply;
import com.example.repository.BoardRepository;
import com.example.repository.ReplyRepository;


@Controller
@RequestMapping(value = "/board")
public class BoardController {

	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	ReplyRepository replyRepository;
	
	@RequestMapping("/insert")
	public String insertGET() {
		return "board_insert";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insertPOST(
			@ModelAttribute ExBoard vo) {
		
		boardRepository.save(vo);
		
		
		return "redirect:/board/list";
	}
	
	@RequestMapping("/list")
	public String listGET(Model model,
			@RequestParam(value = "txt", defaultValue="", required= false) String txt,
			@RequestParam(value = "page",defaultValue = "0") int page) throws UnsupportedEncodingException {
		
		if(page==0) {
			return "redirect:/board/list?txt="+URLEncoder.encode(txt,"UTF-8")+"&page=1";
		}
		
		PageRequest pageable = PageRequest.of(page-1, 10);
		
		List<ExBoard> list = boardRepository.findByTitleIgnoreCaseContainingOrderByNoAsc(txt,pageable);
				//selectQueryOrderByNoDesc();
		model.addAttribute("list", list);
		
		long totPages = boardRepository.countByTitleIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "board_list";
	}
	
	@RequestMapping(value = "/content")
	public String contentGET(@RequestParam(value="no", defaultValue = "0") Long no,
			Model model
			) {
		Optional<ExBoard> vo1 = boardRepository.findById(no); 
		ExBoard vo = vo1.get();
		model.addAttribute("vo", vo);
		
		
		List<ExBoardReply> list = vo.getReplyList();
		model.addAttribute("list", list);
		
		return "board_content";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String deletePOST(@RequestParam(value = "no") Long no) {
		
		boardRepository.deleteById(no);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "/reply")
	public String replyGET(@RequestParam(value="no", defaultValue = "0") Long no,
			Model model) {
		
		Optional<ExBoard> vo1 = boardRepository.findById(no); 
		ExBoard vo = vo1.get();
		model.addAttribute("vo", vo);
		
		return "board_reply";
	}
	
	@RequestMapping(value = "/reply",method = RequestMethod.POST)
	public String replyPOST(@ModelAttribute ExBoardReply vo,
			@RequestParam(value = "no" ) Long no) {
		
		// 외래키 값을 받아오는 객체를 만들어서 저장
		Optional<ExBoard> vo1 = boardRepository.findById(no); 
		ExBoard vo2 = vo1.get();
		vo.setBoard(vo2);
		
		replyRepository.save(vo);
		
		return "redirect:/board/content?no="+no;
	}
}
