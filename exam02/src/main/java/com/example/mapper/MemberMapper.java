package com.example.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.vo.MemberVO;

@Mapper
public interface MemberMapper {

	@Insert({"INSERT INTO MEMBERTBL ",
			"(USERID, USERPW, USERNAME, USERBIRTH,USERGRADE,REGDATE) ",
			"VALUES(#{obj.userid}, #{obj.userpw},#{obj.username}, #{obj.userbirth},", 
			"#{obj.usergrade},CURRENT_DATE)"})
	public int insertMemberOne(@Param("obj") MemberVO obj);

	@Select({"SELECT USERID, USERPW, USERNAME, USERBIRTH,USERGRADE FROM MEMBERTBL WHERE ",
		" USERID=#{username}"})
	public MemberVO selectMemberLogin(@Param("username") String username);

	
	@Select({"SELECT USERID, USERNAME, USERBIRTH,REGDATE FROM ",
		" MEMBERTBL WHERE USERID=#{userid}"})
	public MemberVO selectMemberOne(@Param("userid") String userid);

	@Update({
		"UPDATE CUSTOMER SET USERNAME=#{vo.username}, ", 
		" USERBIRTH=#{vo.userbirth} WHERE USERID=#{vo.userid}"})
	public int updateMember(@Param("vo") MemberVO vo );

	@Delete({"DELETE FROM MEMBERTBL WHERE USERID=#{vo.userid}"})
	public int deleteMemberOne(@Param("vo") MemberVO vo);

	
}
