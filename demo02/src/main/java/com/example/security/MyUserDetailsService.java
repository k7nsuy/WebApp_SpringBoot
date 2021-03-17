package com.example.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mapper.MemberMapper;
import com.example.vo.MemberVO;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	//SECURITY 에서 CONTROLLER에서 SERVICE를 호출하고 SERVICE가 MAPPER를 호출한다.
	//즉 SECURITY에서 SERVICE가 CONTROLLER역할을 한다
	//사용자아이가 넘어오면 DB에서 사용자 아이디에 해당하는 정보(username)를 가져와서 특정 VO를 넘겨줘야함
	
	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//mapper를 이용하여 사용자 정보를 가져옴
		MemberVO vo = memberMapper.selectMemberLogin(username);
		
		//권한을 문자열 배열로
		String[] strGrades = { vo.getUsergrade() };
		
		// 문자열 배열을 Collection<GrangtedAuthority>타입으로 바꾸기
		Collection<GrantedAuthority> grades = AuthorityUtils.createAuthorityList(strGrades);
		
		//가져온 사용자 정보를 UserDetails에 해당하는 User객체로 변환
		User vo1 = new User(vo.getUserid(),vo.getUserpw(), grades );
		
		return vo1;
	}

	
}
