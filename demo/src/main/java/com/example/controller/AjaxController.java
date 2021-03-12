package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/ajax")
public class AjaxController {
	
	//127.0.0.1:9092/ROOT/ajax/itemlist
	@RequestMapping(value="/itemlist") //method명시 안하면 get
	public String itemlistGET() {
		//views의 ajax폴더의 iteminsert.jsp를 표시
		return "ajax/itemlist";
	}
	
	@RequestMapping(value="/iteminsert") //method명시 안하면 get
	public String itemInsertGET() {
		//views의 ajax폴더의 iteminsert.jsp를 표시
		return "ajax/iteminsert";
	}
	
	@RequestMapping(value="/chart") //method명시 안하면 get
	public String ChartGET() {
		//views의 ajax폴더의 iteminsert.jsp를 표시
		return "ajax/chart";
	}
}
