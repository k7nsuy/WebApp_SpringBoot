package org.fkpk.mapper;

import org.apache.ibatis.annotations.Param;
import org.fkpk.domain.Member;

public interface MemberMapper {

	public Member findById(String memberId);

	public void addPoint(int memberId, int point);

	public void addStamp(int memberId);

	public int stampCount(int memberId);

	public void register(Member member);

	public Member loginCheck(String userId);

	public void resetStamp(int memberId);

	public void updateEvent(@Param("memberId")Integer memberId, @Param("grade")Integer grade);

}
