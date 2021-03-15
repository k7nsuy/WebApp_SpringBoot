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

import com.example.mapper.CustomerMapper;
import com.example.vo.CustomerVO;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	//customer/login화면에서 아이디와 비번이 이쪽으로 넘어온다.  
	
	@Autowired
	CustomerMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// username을 이용해서 정보 가져오기
		CustomerVO vo = userMapper.findByUsername(username);
		
		String[] usergrade = {vo.getUsergrade() };
		Collection<GrantedAuthority> roles
		= AuthorityUtils.createAuthorityList(usergrade);
		
		//User객체로 리턴
		return new User(vo.getUserid(),vo.getUserpw(),roles);
	}

}
