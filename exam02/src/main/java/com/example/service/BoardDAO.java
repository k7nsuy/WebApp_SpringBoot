package com.example.service;

import java.util.List;

import com.example.vo.BoardVO;

public interface BoardDAO {
	
	//글쓰기 (0또는 1이상의 숫자) => 아이디 한개의 파라미터를 통해서 데이터를 관리한다. 그러므로 int
	//int => mapper(0또는 1)에 주는 타입
	//Board vo => 받아 오는 값
	public int insertBoardOne(BoardVO vo);
	//글삭제
	public int deleteBoardOne(long brdno);
	//글수정
	public int updateBoardOne(BoardVO vo);
	//글목록 => 조건이 있다면 받아 오는 값이 있어야 함 => 조건이 없다면 리스트 전체가 넘어옴
	public List<BoardVO> selectBoardList();
	//글1개 가져오기 => 글 번호(기본키)를 가져와야 함
	public BoardVO selectBoardOne(long brdno);
	//이전글
	
	//다음글
	
}
