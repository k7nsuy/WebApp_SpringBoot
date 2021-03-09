package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.vo.ItemVO;


@Mapper
public interface ItemMapper {

	@Insert({"INSERT INTO ITEM2(CODE, NAME, PRICE, QUANTITY, REGDATE, CATEGORY) "
			+ "VALUES(#{vo.code},#{vo.name},#{vo.price},#{vo.quantity},"
			+ "CURRENT_DATE,#{vo.category})"})
	public int insertItemOne(@Param("vo") ItemVO vo);

	//CODE별 오름차순 정렬 후 START 부터 END까지 가져오기(PAGENATION)
	@Select({"SELECT * FROM (",
		" SELECT CODE, NAME, PRICE, QUANTITY, REGDATE, CATEGORY, ",
		" ROW_NUMBER() OVER(ORDER BY CODE ASC) ROWN",
		" FROM ITEM2",
	") WHERE ROWN BETWEEN #{start} AND #{end}"})
	public List<ItemVO> selectItemList(@Param("start") int start,
			@Param("end") int end);

	@Delete({ "DELETE FROM ITEM2 WHERE CODE=#{code}"})
	public int deleteItemOne(@Param("code") String code);

}
