package com.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import com.example.vo.BoardVO;

@Transactional(rollbackFor = Exception.class)
@Mapper
public interface BoardMapper {

	@Insert({"INSERT INTO BOARDTBL(BRDNO, BRDTITLE, BRDCONTENT, BRDHIT, BRDWRITER, BRDDATE) ",
		" VALUES(SEQ_BOARD_NO.NEXTVAL,#{vo.brdtitle},#{vo.brdcontent},#{vo.brdhit},#{vo.brdwriter},CURRENT_DATE)"})
	public int insertBoardOne(@Param("vo") BoardVO vo);
	
	@Delete({"DELETE FROM BOARDTBL WHERE BRDNO=#{brdno}"})
	public int deleteBoardOne(@Param("brdno") int brdno);
	
	@Update({"UPDATE BOARDTBL SET  "})
	public int updateBoardOne(@Param("vo") BoardVO vo);
	
}
