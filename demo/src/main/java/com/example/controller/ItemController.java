package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.mapper.ItemMapper;
import com.example.vo.ItemVO;

@Controller
@RequestMapping(value="/item")
public class ItemController {
	
	@Autowired
	ItemMapper itemMapper;
	
	@RequestMapping(value="/batchinsert", method=RequestMethod.GET)
	public String batchinsertGET() {
		return "item/batchinsert";
	}
	
	@RequestMapping(value="batchupdate",method=RequestMethod.GET)
	public String batchUpdateGET(HttpServletRequest request,
			Model model) {
		//post에서 HttpServletRequest로 전달되는 값을 받는다.(단 1회만)
		//map
		Map<String,?> map = RequestContextUtils.getInputFlashMap(request);
		if(map == null) {
			return "redirect:list";
		}
		long[] code = (long[])map.get("code");
		List<ItemVO> list = itemMapper.selectItemListWhere(code);
		model.addAttribute("list", list);
		
		return "item/batchupdate"; //views의 item폴더의 batchupdate.jsp
	}
	
	@RequestMapping(value="batchupdate",method=RequestMethod.POST)
	public String batchUpdatePOST(@RequestParam(value="chk[]") long[] code,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("code", code);
		//post방식에서 get방식으로 보내기 위해 RedirectAttributes를 사용하여 addFlashAttribute
		//를 사용하여 code를 code로 보낸다.
		
		//127.0.0.1:9092/ROOT/item/batchupdate GET방식으로 전환
		return "redirect:batchupdate"; 
	}
	
	@RequestMapping(value="batchupdate2",method=RequestMethod.POST)
	public String batchUpdatePOST(
			@RequestParam(value="code[]") long[] code,
			@RequestParam(value="name[]") String[] name,
			@RequestParam(value="price[]") long[] price,
			@RequestParam(value="quantity[]") long[] quantity,
			@RequestParam(value="category[]") String[] category
			) {
		List<ItemVO> list = new ArrayList<ItemVO>();
		
		for(int i=0; i<code.length; i++) {
			ItemVO vo = new ItemVO();
			vo.setCode(code[i]);
			vo.setName(name[i]);
			vo.setPrice(price[i]);
			vo.setQuantity(quantity[i]);
			vo.setCategory(category[i]);
			list.add(vo);
		}
		itemMapper.updateItemBatch(list);
		//post방식에서 get방식으로 보내기 위해 RedirectAttributes를 사용하여 addFlashAttribute
		//를 사용하여 code를 code로 보낸다.
		
		//127.0.0.1:9092/ROOT/item/batchupdate GET방식으로 전환
		return "redirect:list"; 
	}
	
	@RequestMapping(value="/batchdelete",method=RequestMethod.POST)
	public String batchDeletePOST(@RequestParam(value="chk[]",required=false) long[] code) {
		if(code!=null) {
		itemMapper.deleteItemBatch(code);
		}
		return "redirect:list";
	}
	
	@RequestMapping(value="/batchinsert", method=RequestMethod.POST)
	public String batchinsertPOST(
			@RequestParam(value="code[]") long[] code,
			@RequestParam(value="name[]") String[] name,
			@RequestParam(value="price[]") long[] price,
			@RequestParam(value="quantity[]") long[] quantity,
			@RequestParam(value="category[]") String[] category) {
		
		List<ItemVO> list  = new ArrayList<ItemVO>();
		for(int i=0;i<code.length;i++) {
			ItemVO vo = new ItemVO();
			vo.setCode(code[i]);
			vo.setName(name[i]);
			vo.setPrice(price[i]);
			vo.setQuantity(quantity[i]);
			vo.setCategory(category[i]);
			list.add(vo);
		}
		
		itemMapper.insertItemBatch(list);
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String deletePOST(
			@RequestParam(value="code", defaultValue="",required=false) String code) {
		if(!code.equals("")) {
			itemMapper.deleteItemOne(code);	
		}
		return "redirect:delete";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listGET(Model model,
			@RequestParam(value="page",defaultValue="0")int page,
			@RequestParam(value="type",defaultValue="code")String type,
			@RequestParam(value="text",defaultValue="")String text) {
		
		// 127.0.0.1:9092//ROOT/item/list를 입력하면 ?page1을 추가함. 위에 페이지 파마미터 추가
		if(page==0) {
			return "redirect:list?page=1";
		}
		
		//1부터 10까지 가져오기
		List<ItemVO> list = itemMapper.selectItemList(page*10-9,page*10, type, text);
		//page=1 => start는 1 end는 10
		//page=2 => start는 11 end는 20
		//page=3 => start는 21 end는 30

		int cnt = itemMapper.selectItemCount(type,text);
		
		//jsp로 전달
		model.addAttribute("list", list);
		model.addAttribute("cnt", (cnt-1)/10+1);
		//1 => 1page , 12 => 2page ,21 => 3page 
		
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
		//post에서 a태그를 쓴다. => 주소를 바꾸기 위해
		return "redirect:insert";
	}
	
}
