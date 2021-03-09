package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mapper.ItemMapper;
import com.example.vo.ItemVO;

@Controller
@RequestMapping(value="/item")
public class ItemController {
	
	@Autowired
	ItemMapper itemMapper;
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deletePOST(
			@RequestParam(value="code", defaultValue="",required=false) String code) {
		if(!code.equals("")) {
			itemMapper.deleteItemOne(code);	
		}
		return "redirect:" + "/item/delete";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listGET(Model model) {
		
		List<ItemVO> list = itemMapper.selectItemList(1, 30);
		
		model.addAttribute("list", list);
		return "item/list"; //item폴더의 list.jsp를 표시, 주소창의 변화가 없음
		//return "redirect:" + "/item/insert";  => item폴더의 list.jsp를 표시, 주소창의 변화가 없음
		
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertGET(Model model) {
		//1.객체생성
		ItemVO vo = new ItemVO();
		vo.setCategory("E");
		vo.setCategory2(new String[] {"A","D","E"});
		//2. select에 표시될 항목
		String[] slist = {"A","B","C","D","E"};
		//3.JSP로 전달
		model.addAttribute("vo", vo);
		model.addAttribute("slist", slist);
		//4.jsp 표시
		return "item/insert";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String insertPOST(
			@ModelAttribute ItemVO vo) {
		itemMapper.insertItemOne(vo);
		return "redirect:" + "/item/insert";
	}
	
}
