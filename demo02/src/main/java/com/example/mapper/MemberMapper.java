package com.example.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.vo.MemberVO;

@Mapper
public interface MemberMapper {

	@Insert({"INSERT INTO MEMBERTBL ",
			"(USERID, USERPW, USERNAME, USERBIRTH, USERPHONE,USERGRADE,REGDATE) ",
			"VALUES(#{obj.userid}, #{obj.userpw},#{obj.username}, #{obj.userbirth}, #{obj.userphone},", 
			"#{obj.usergrade},CURRENT_DATE)"})
	public int insertMemberOne(@Param("obj") MemberVO obj);

	
	@Select({"SELECT USERID, USERPW, USERNAME, USERBIRTH, USERPHONE,USERGRADE,REGDATE FROM MEMBERTBL WHERE ",
		"USERID=#{userid} AND USERPW=#{userpw}"})
	public MemberVO selectMemberLogin(@Param("userid") String userid, 
			@Param("userpw") String userpw);

	
	@Select({"SELECT USERID, USERNAME, USERBIRTH, USERPHONE,REGDATE FROM ",
		" MEMBERTBL WHERE USERID=#{userid}"})
	public Map<String, Object> selectMemberOne(@Param("userid") String userid);

	@Delete({"DELETE FROM MEMBERTBL WHERE "})
	public Map<String, Object> deleteMemberOne(@Param("vo") MemberVO vo);
	
}
