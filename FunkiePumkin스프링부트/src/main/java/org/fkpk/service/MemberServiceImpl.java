package org.fkpk.service;

import org.fkpk.domain.Event;
import org.fkpk.domain.Member;
import org.fkpk.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberMapper memberMapper;

	@Override
	public Member findById(String memberId) {
		return memberMapper.findById(memberId);
	}

	@Override
	public void addPoint(int memberId, int point) {
		memberMapper.addPoint(memberId,point);
		
	}

	@Override
	public void addStamp(int memberId) {
		memberMapper.addStamp(memberId);		
	}

	@Override
	public int stampCount(int memberId) {
		return memberMapper.stampCount(memberId);
	}

	@Override
	public void register(Member member) {
		memberMapper.register(member);
		
	}

	@Override
	public Member loginCheck(String userId) {
		return memberMapper.loginCheck(userId);
	}

	@Override
	public void resetStamp(int memberId) {
		memberMapper.resetStamp(memberId);
		
	}

	

}
