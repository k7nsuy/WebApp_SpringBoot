package com.example.androidconn.service;

import java.util.List;

import com.example.androidconn.domain.Board;

public interface BoardService {

	public void boardRegister (Board board);
	public Board readBoard(int bno);
	public List<Board> boardList();
}
