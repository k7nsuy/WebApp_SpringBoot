package com.example.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vo.BoardVO;

@Service
@Transactional
public class BoardDAOXMLImpl implements BoardDAOXML {
	
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Override
	public int insertBoardOne2(BoardVO vo) {
		return sqlFactory.openSession().insert("BoardXMLMapper.insertBoardOne2", vo);
	}

	@Override
	public int deleteBoardOne2(long brdno) {
		return sqlFactory.openSession().delete("BoardXMLMapper.deleteBoardOne2",brdno);
	}

	@Override
	public int updateBoardOne2(BoardVO vo) {
		return sqlFactory.openSession().update("BoardXMLMapper.updateBoardOne2", vo);
	}

	@Override
	public List<BoardVO> selectBoardList2() {
		return sqlFactory.openSession().selectList("BoardXMLMapper.selectBoardList2");
	}

	@Override
	public BoardVO selectBoardOne2(long brdno) {
		return sqlFactory.openSession().selectOne("BoardXMLMapper.selectBoardOne2", brdno);
	}
	
	
	
	

}
