package org.fkpk.service;

import org.fkpk.domain.Event;
import org.fkpk.domain.Member;

public interface MemberService {

	public Member findById(String memberId);

	public void addPoint(int memberId, int point);

	public void addStamp(int memberId);

	public int stampCount(int memberId);
	
	public void register(Member member);

	public Member loginCheck(String userId);

	public void resetStamp(int memberId);



}
