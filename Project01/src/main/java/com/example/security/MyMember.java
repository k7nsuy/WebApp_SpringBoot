package com.example.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyMember extends User {

	public MyMember(String username, String password, Collection<? extends GrantedAuthority> authorities, String name) {
		super(username, password, authorities);
		this.userid = username;
		this.userpw = password;
		this.username = name;
	}
	
	private String userid = null;
	private String userpw = null;
	private String username = null;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

}
