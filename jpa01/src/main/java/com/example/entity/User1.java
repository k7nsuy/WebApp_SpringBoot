package com.example.entity;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="USERTBL1")
public class User1 {

	@Id
	@Column(name = "USERID")
	private String userid;
	
	@Column(name = "USERPW")
	private String userpw;
	
	@Column(name = "USERNAME")
	private String username;
	
	@Lob
	@Column(name = "USERIMG")
	public byte[] userimg;
	
	@Column(name = "USERGRADE")
	private String usergrade;
	
	@CreationTimestamp
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@Column(name = "USERDATE")
	private Date userdate;

	@Transient
	private String base64;
	
	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public User1(String usergrade) {
		super();
		this.usergrade = usergrade;
	}

	public String getUsergrade() {
		return usergrade;
	}

	public void setUsergrade(String usergrade) {
		this.usergrade = usergrade;
	}

	@Override
	public String toString() {
		return "User1 [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userimg="
				+ Arrays.toString(userimg) + ", usergrade=" + usergrade + ", userdate=" + userdate + "]";
	}

	public User1 () {
		super();
	}
	
	public User1(String userid, String userpw, String username, byte[] userimg, Date userdate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userimg = userimg;
		this.userdate = userdate;
	}

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

	public byte[] getUserImg() {
		return userimg;
	}

	public void setUserImg(byte[] img) {
		this.userimg = img;
	}

	public Date getUserdate() {
		return userdate;
	}

	public void setUserdate(Date userdate) {
		this.userdate = userdate;
	}
	
	
}
