package org.fkpk.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.fkpk.domain.Product;
import org.fkpk.domain.RefrigeProduct;
import org.fkpk.domain.Shop;
import org.fkpk.service.MemberService;
import org.fkpk.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	private ShopService shopService;
	//체인점 등록 폼으로
	@GetMapping("/shopRegister")
	public void shopRegisterForm() throws Exception{
		
	}
	
	//체인점 등록
	@PostMapping("/shopRegister")
	public String shopRegister(Shop shop, Model model) throws Exception {
		System.out.println(shop);
		shopService.shopRegister(shop); 
		return "redirect:/shop/shopList";
	}
	
	//체인점 리스트
	@GetMapping("/shopList")
	public void shopList(Model model) throws Exception{
		List<Shop> list = shopService.shopList();
		model.addAttribute("list", list);
	}
	
	//안드로이드- 체인점리스트
	@ResponseBody
	@GetMapping("/shopListBody")
	public String shopList() {
		Gson gson = new GsonBuilder().create();
		List<Shop> shopList = shopService.shopList(); 
		String jsonString = gson.toJson(shopList);
		return jsonString;
	}
		
}
