package com.example.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Member;
import com.example.repository.MemberRepository;


@Service
public class MyMemberDetailService implements UserDetailsService{
	
	//customer/login화면에서 아이디와 비번이 이쪽으로 넘어온다.  
	
	@Autowired
	MemberRepository memberRepository;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		
		System.out.println(userId);
		Member vo = memberRepository.findByUserId(userId);
		
		System.out.println(vo.toString());
		//가져온 권한정보를 문자열 배열로 만들기
		String[] strRoles = {vo.getAuthority().getMember()};
		// import org.springframework.security.core.userdetails.User;
				// String 배열을 Collection<GrantedAuthority>타입으로 바꾸기
		Collection<GrantedAuthority> roles
		= AuthorityUtils.createAuthorityList(strRoles);
		
		//가져온 정보에서 아이디, 암호, 권한,유저네임을 리턴함.
				//세션에서 아이디와 권한만 + 이름, 가입일자
		//MyUser객체로 리턴
		return new MyMember(vo.getUserId(), vo.getUserPass(), roles, vo.getMemberNum());
	}
}
