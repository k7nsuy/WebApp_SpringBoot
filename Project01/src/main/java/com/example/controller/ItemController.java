package com.example.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String insertPOST(@ModelAttribute ItemList vo,
			@RequestParam(value = "image" ,defaultValue = "",
					required = false) MultipartFile imgs) throws IOException {
		if(imgs.getBytes().length > 0) {
			vo.setItemImage(imgs.getBytes());
		}
		
		System.out.println(vo.toString());
		itemRepository.save(vo);
		
		return "redirect:/item/list";
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
		
		for(ItemList vo : list) {
			System.out.println(vo.toString());
			// byte[] => String(base64)
			// import java.util.Base64;

			if(vo.getItemImage() !=null) {

				String tmp = Base64.getEncoder().encodeToString(vo.getItemImage());
				vo.setBase64( tmp );
				vo.setItemImage(null);
			}
		}
		
		model.addAttribute("list", list);
		
		long totPages = itemRepository.countByItemNameIgnoreCaseContaining(txt);
		model.addAttribute("totPages", (totPages-1)/10+1);
		
		return "item/item_list";
	}
	
	@GetMapping("content")
	public String contentGET(Model model) {
		
		
		return "item/item_content";
	}
	
}
