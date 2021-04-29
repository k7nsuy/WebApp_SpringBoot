package com.example.androidconn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.androidconn.domain.Board;
import com.example.androidconn.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper mapper;
	
	@Override
	public void boardRegister(Board board) {
		// TODO Auto-generated method stub
		mapper.register(board);
	}

	@Override
	public Board readBoard(int bno) {
		// TODO Auto-generated method stub
		return mapper.readBoard(bno);
	}

	@Override
	public List<Board> boardList() {
		// TODO Auto-generated method stub
		return mapper.boardList();
	}
	
	

}
