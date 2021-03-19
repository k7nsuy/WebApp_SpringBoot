package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.BoardMapper;
import com.example.vo.BoardVO;

@Service
@Transactional
public class BoardDAOImpl implements BoardDAO {
	
	
	@Autowired
	BoardMapper bMapper;
	// BoardMapper bMapper = new BoardMapper();
	
	@Override
	public int insertBoardOne(BoardVO vo) {
//		if(bMapper.글번호존재) { => BoardDAOImpl이 필요없다고 볼 수 있지만 다양한 조건을 만들어 실행시킬수 있다.
//			return 
//		}
		
		return bMapper.insertBoardOne(vo);
	}

	@Override
	public int deleteBoardOne(long brdno) {
		return 0;
	}

	@Override
	public int updateBoardOne(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVO> selectBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO selectBoardOne(long brdno) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
