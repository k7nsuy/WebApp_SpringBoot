package com.example.androidconn.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.androidconn.domain.Board;

@Mapper
public interface BoardMapper {

	public void register(Board board);
	public Board readBoard(int bno);
	public List<Board> boardList();
}
