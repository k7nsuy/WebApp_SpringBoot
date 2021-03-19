package com.example.service;

import java.util.List;

import com.example.vo.BoardVO;

public interface BoardDAOXML {

	public int insertBoardOne2(BoardVO vo);
	
	public int deleteBoardOne2(long brdno);
	
	public int updateBoardOne2(BoardVO vo);
	
	public List<BoardVO> selectBoardList2();
	
	public BoardVO selectBoardOne2(long brdno);
	
}
