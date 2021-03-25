package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERTBL5")
public class User5 {

	@Id
	@Column(name = "USERID")
	private String userid;
	
	@Column(name = "USERNAME")
	private String username;
	
	@OneToMany(mappedBy = "user")
	private List<Order5> orderList = new ArrayList<>();
	
	public List<Order5> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order5> orderList) {
		this.orderList = orderList;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public User5() {
		super();
	}

	public User5(String userid, String username) {
		super();
		this.userid = userid;
		this.username = username;
	}

	@Override
	public String toString() {
		return "User5 [userid=" + userid + ", username=" + username + "]";
	}
	
	
}