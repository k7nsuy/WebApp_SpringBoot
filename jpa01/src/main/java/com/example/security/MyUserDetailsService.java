package com.example.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	// /login화면에서 아이디와 비번이 이쪽으로 넘어온다.  
	
	@Autowired
	CustomerRepository cRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// username을 이용해서 정보 가져오기
		Customer vo = cRespository.findByCstid(username);
		
		
		System.out.println(vo.getCstpw());
		//가져온 권한정보를 문자열 배열로 만들기
		String[] strRoles = {vo.getCstrole() };
		// import org.springframework.security.core.userdetails.User;
				// String 배열을 Collection<GrantedAuthority>타입으로 바꾸기
		Collection<GrantedAuthority> roles
		= AuthorityUtils.createAuthorityList(strRoles);
		
		//가져온 정보에서 아이디, 암호, 권한,유저네임을 리턴함.
				//세션에서 아이디와 권한만 + 이름, 가입일자
		//MyUser객체로 리턴
		return new MyUser(vo.getCstid(), vo.getCstpw(), roles, vo.getCstname());
	}

}
