package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.ItemList;
import com.example.repository.ItemRepository;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	@RequestMapping(value = "/manage" )
	public String itemGET() {
		return "item/item_manage";
	}
	
	@RequestMapping(value = "/insert")
	public String insertGET() {
		return "item/item_insert";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String insertPOST(@ModelAttribute ItemList vo) {
		
		System.out.println(vo.toString());
		itemRepository.save(vo);
		
		return "redirect:/item/insert";
	}
	
	@RequestMapping(value = "/list")
	public String listGET(Model model,
			@RequestParam(value = "txt", defaultValue="", required= false) String txt,
			@RequestParam(value = "page",defaultValue = "0") int page) throws UnsupportedEncodingException {
		
		if(page==0) {
			return "redirect:/item/list?txt="+URLEncoder.encode(txt,"UTF-8")+"&page=1";
		}
		
		PageRequest pageable = PageRequest.of(page-1, 10);
		
		List<ItemList> list = itemRepository.findByItemNameIgnoreCaseContainingOrderByItemNumberAsc(txt,pageable);
		
		model.addAttribute("list", list);
		
		long totPages = itemRepository.countByItemNameIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "item/item_list";
	}
	
}
