package com.example.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User  {

	public MyUser(String username, String password,
			Collection<? extends GrantedAuthority> authorities,
			String name) {
		super(username, password,authorities);
		this.cstname = name; //username
		this.username = username; //userid
		this.password = password; //userpw
	}
	
	private String username = null;
	private String password = null;
	private String cstname = null;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCstname() {
		return cstname;
	}
	public void setCstname(String cstname) {
		this.cstname = cstname;
	}
	
	
	
}
