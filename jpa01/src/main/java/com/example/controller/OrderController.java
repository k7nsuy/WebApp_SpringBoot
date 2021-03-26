package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Item5;
import com.example.entity.Order5;
import com.example.entity.User5;
import com.example.repository.Item5Repository;
import com.example.repository.Order5Repository;
import com.example.repository.User5Repository;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	
	@Autowired
	Item5Repository iRepository; 
	
	@Autowired
	User5Repository uRepository;
	
	@Autowired
	Order5Repository oRepository;
	
	@RequestMapping(value = "/itemlist")
	public String itemListGET(Model model) {
		
		List<Item5> list = iRepository.findAll();
		model.addAttribute("itemlist", list);
		
	return "order_itemlist";	
	}
	
	@RequestMapping(value = "/insert")
	public String itemInsertGET(Model model,
			@RequestParam(value = "itemno") Long no) {
		
		//해당 물품에 대한 상세한 정보를 가져옴
		Item5 vo = iRepository.getOne(no);
		model.addAttribute("vo", vo);
		
		return "order_iteminsert";
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)
	public String itemInsertPOST(@RequestParam(value = "qnt") Long qnt,
			@RequestParam(value = "itemno") Long no) {
		System.out.println("물품수량 = " + qnt);
		System.out.println("물품번호 = " + no);
		//
		Order5 vo = new Order5();
		vo.setQnt(qnt); //주문번호 채우기
		
		Item5 vo1 = iRepository.getOne(no); //물품저장소의 아이템번호를 가져와서
		vo.setItem(vo1);; //order5에 아이템번호를 채우기
		
		String userid = "A";
		Optional<User5> vo2 = uRepository.findByUserid(userid);
		vo.setUser(vo2.get());
		
		oRepository.save(vo); // 채운 아이템번호와
		
		return "redirect:/order/itemlist";
	}
	
	@RequestMapping(value = "/orderlist")
	public String orderListGET(@RequestParam(value = "itemno") long no,
			Model model) {
		
		Optional<Item5> vo = iRepository.findById(no);
		model.addAttribute("vo", vo.get());
		
		return "order_orderlist";
	}
	

}
