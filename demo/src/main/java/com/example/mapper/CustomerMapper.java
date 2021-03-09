package com.example.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import com.example.vo.CustomerVO;

@Mapper
public interface CustomerMapper {
	
	@Update({
		"<script>",
		"UPDATE CUSTOMER SET USERNAME=#{map.username},USERPHONE=#{map.userphone}",
			"<if test='map.userimg !=null'>"
				+ ",USERIMG=#{map.userimg,jdbcType=BLOB} ",
			"</if>" //null이 아니면 수행되고 , null이면 수행되지 않는다.
				+ "WHERE USERID=#{map.userid}",
		"</script>"
	})
	public int updateCustomerOne(@Param("map") Map<String,Object> map);
	
	@Select({"SELECT USERID, USERPW, USERNAME, USERPHONE, USERDATE FROM CUSTOMER "
			+ "WHERE USERID=#{userid}"})
	public Map<String,Object> selectCustomerOne(@Param("userid") String userid);
	// public CustomerVO selectCustomerOne(@Param("userid") String userid)
	// => Value Object 사용
	
	@Delete({"DELETE FROM CUSTOMER WHERE USERID=#{userid}"})
	public int deleteCustomerOne(@Param("userid") String userid);
	//넘어오는 변수명(@Param("userid")은 임의로 정하지만 헷갈리지 않게 controller에서 보내준 값과 맞추어서 입력.
	
	//return 값은 int (INSERT,DELETE,UPDATE)
	//mybatis => ? => #{}
	@Insert({"INSERT INTO CUSTOMER ",
			"(USERID, USERPW, USERNAME, USERPHONE, USERDATE,USERIMG) ",
			"VALUES(#{obj.userid}, #{obj.userpw}, #{obj.username}, #{obj.userphone},", 
			"CURRENT_DATE,#{obj.userimg,jdbcType=BLOB})"})
	public int insertCustomerOne(@Param("obj") CustomerVO obj);
	
	@Select({"SELECT USERID,USERPW,USERNAME,USERPHONE,USERDATE ",
		"FROM CUSTOMER ORDER BY USERID ASC"})
	public List<CustomerVO> selectCustomerList();
	
	@Results({ // image 불러오기
		//props와 column이 같으면 생략가능 이미지는 타입이 다르기 때문에 알맞게 고쳐야 한다. 생략x
		@Result(property = "userimg",column="USERIMG",
				jdbcType = JdbcType.BLOB,javaType = byte[].class)
	})
	@Select({"SELECT USERIMG FROM CUSTOMER WHERE USERID=#{userid}"})
	public CustomerVO selectCustomerImgOne(@Param("userid") String userid);
	
	
	
	
	
}
