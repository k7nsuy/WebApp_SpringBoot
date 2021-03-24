package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TEAMTBL3")
public class Team1 {
	
	@Id
	@Column(name = "TEAMID")
	private Long id;
	
	@Column(name = "TEAMNAME", length = 100)
	private String name;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "TEAMDATE")
	private Date date;

	//추가한 부분
	@OneToMany(mappedBy = "team" ) //USER1의 team변수와 연결
	private List<User1> users = new ArrayList<>();
	
	public List<User1> getUsers() {
		return users;
	}

	public void setUsers(List<User1> users) {
		this.users = users;
	}

	public Team1() {
		super();
	}
	
	public Team1(Long id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Team1 [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
