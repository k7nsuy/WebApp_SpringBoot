package com.example.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Item1;
import com.example.repository.ItemRepository;

@Controller
@RequestMapping(value = "/item")
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String itemGET() {
		return "item_insert";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String itemPOST(@ModelAttribute Item1 vo) {
		System.out.println(vo.toString());
		itemRepository.save(vo);
		return "redirect:/item/insert";
	}
	
	@RequestMapping(value = "/list")
	public String listGET(Model model,
			@RequestParam(value = "txt", defaultValue="", required= false) String txt,
			@RequestParam(value = "page",defaultValue = "0") int page) throws UnsupportedEncodingException {
		//페이지 url에 기본 param값을 추가함.
		
		if(page==0) {
			return "redirect:/item/list?txt="+URLEncoder.encode(txt,"UTF-8")+"&page=1";
		}
		
		System.out.println(txt);
		System.out.println(page);
		
		PageRequest pageable = PageRequest.of(page-1, 10);
		
		List<Item1> list = itemRepository.findByNameIgnoreCaseContainingOrderByNoAsc(txt,pageable);
				//selectQueryOrderByNoDesc();
		model.addAttribute("list", list);
		
		long totPages = itemRepository.countByNameIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "item_list";
	}
	
//	@RequestMapping(value = "/list")
//	public String selectGET(Model model) {
//		List<ItemProjection> list = itemRepository.selectQueryOrderByNoDesc1();
//		for(ItemProjection vo : list) {
//			System.out.println(vo.getItmNo()+","+vo.getItmName());
//			//jsp에서 출력할 경우 => ${vo.getItmNo()}
//		}
//		model.addAttribute("list", list);
//		return "item_list";
//	}
	
	@RequestMapping(value="/content")
	public String contentGET(@RequestParam(value="no", defaultValue = "0") Long no,
			Model model) {
		
		//한개꺼내기
		//Optional의 value는 값이 있을 수도 있고 null일 수도 있다.
		Optional<Item1> vo1 = itemRepository.findById(no);
		Item1 vo2 = vo1.get();
		
		model.addAttribute("vo", vo2);
		return "item_content"; 
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.GET)
	public String updateGET(Model model, @RequestParam(value="no", defaultValue = "0") Long no) {
		
		Optional<Item1> vo1 = itemRepository.findById(no);
		Item1 vo2 = vo1.get();
		
		model.addAttribute("vo", vo2);
		
		return "item_update";
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public String updatePOST(Model model,
			@ModelAttribute Item1 vo) {
		System.out.println(vo.toString());
		itemRepository.save(vo);
		
		return "redirect:/item/list";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public String deletePOST(@RequestParam(value="no", defaultValue = "0") Long no) {
		
		itemRepository.deleteById(no);
		
		return "redirect:/item/list";
	}
}
