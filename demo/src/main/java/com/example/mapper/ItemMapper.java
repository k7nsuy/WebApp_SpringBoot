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
	
	//ITem 테이블의 데이터 개수 리턴
	@Select({"SELECT COUNT(*) CNT FROM ITEM2 WHERE ${type} LIKE '%' || #{text} || '%' "})
	public int selectItemCount(@Param("type") String type,
			@Param("text") String text);
	
	//CODE별 오름차순 정렬 후 START 부터 END까지 가져오기(PAGENATION)
	@Select({"SELECT * FROM (",
		" SELECT CODE, NAME, PRICE, QUANTITY, REGDATE, CATEGORY, ",
		" ROW_NUMBER() OVER(ORDER BY CODE ASC) ROWN",
		" FROM ITEM2 WHERE ${type} LIKE '%' || #{text} || '%' ",
	") WHERE ROWN BETWEEN #{start} AND #{end}"})
	// #{text} => code => code로 변환 =''가 없음 => 문자열 형태(변환)로 들어와야 해서 ''가 붙여지는 #이 와야한다. 
	// ${type} => abc => 'abc'로 변환 = ''가 추가 => column(고정)으로 들어와야 해서 
	public List<ItemVO> selectItemList(@Param("start") int start,
			@Param("end") int end,
			@Param("type") String type,
			@Param("text") String text);

	@Delete({ "DELETE FROM ITEM2 WHERE CODE=#{code}"})
	public int deleteItemOne(@Param("code") String code);

	@Insert({
		"<script>",
			 "INSERT ALL ",
			 	"<foreach collection='list' item='vo' separator=' '>",
			 		" INTO ITEM2(CODE, NAME, PRICE, QUANTITY, REGDATE, CATEGORY) VALUES(#{vo.code}, #{vo.name}, #{vo.price}, #{vo.quantity}, CURRENT_DATE, #{vo.category}) ",
				"</foreach>",
			"SELECT * FROM DUAL",
		"</script>"	})
	public int insertItemBatch(@Param("list") List<ItemVO> list);

	@Delete({"<script>",
		"DELETE FROM ITEM2 WHERE CODE IN (",
		"<foreach collection='array' item='vo' separator=','>",
			"#{vo}",
		"</foreach>",
		")",
		"</script>"})
	public int deleteItemBatch(@Param("array") long[] code);

}
