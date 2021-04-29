package com.example.androidconn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.androidconn.domain.Board;
import com.example.androidconn.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@ResponseBody
	@GetMapping("androidGet")
	public Board androidTest(String bno) {
		Board board = service.readBoard(Integer.parseInt(bno));
		return board;
	}
	
	@ResponseBody
	@PostMapping("androidPost")
	public String androidPost(String title,String content,String writer) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);
		board.setWriter(writer);
		System.out.println(board);
		service.boardRegister(board);
		return "안드로이드로 부터 데이터 DB에 저장 성공";
	}
	
	@ResponseBody
	@GetMapping("boardList")
	public List<Board> boardList() {
		List<Board> list = service.boardList();
		System.out.println(list.toString());
//		list.add(new Board(1,"title1","content1","user1","2021-04-29"));
//		list.add(new Board(2,"title2","content2","user2","2021-04-29"));
//		list.add(new Board(3,"title3","content3","user3","2021-04-29"));
//		list.add(new Board(4,"title4","content4","user4","2021-04-29"));
//		list.add(new Board(5,"title5","content5","user5","2021-04-29"));
		return list;
	}
}
