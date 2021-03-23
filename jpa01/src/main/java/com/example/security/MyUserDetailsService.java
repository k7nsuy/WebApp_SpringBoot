package com.example.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.entity.User1;
import com.example.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	//customer/login화면에서 아이디와 비번이 이쪽으로 넘어온다.  
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		
		// username을 이용해서 정보 가져오기
		User1 vo = userRepository.findByUserid(userid);
		
		String[] usergrade = {vo.getUsergrade() };
		Collection<GrantedAuthority> roles
		= AuthorityUtils.createAuthorityList(usergrade);
		
		//User객체로 리턴
		return new User(vo.getUserid(),vo.getUserpw(),roles);
	}

}
