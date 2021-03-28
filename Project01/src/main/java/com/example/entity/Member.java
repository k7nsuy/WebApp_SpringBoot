package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Member")
@SequenceGenerator(name = "SEQ" , 
sequenceName = "SEQ_Member_NO",
initialValue = 1,
allocationSize = 1)
public class Member {

	@Id
	@Column(name = "memberNum")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	private long memberNum;
	
	@Column(name = "userId")
	private String userId;
	
	@Column(name = "userPass")
	private String userPass;
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userAdress")
	private String userAdress;
	
	@Column(name = "userPhone")
	private String userPhone;
	
	@Column(name = "userEmail")
	private String userEmail;

	public long getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(long memberNum) {
		this.memberNum = memberNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Member(long memberNum, String userId, String userPass, String userName, String userAdress, String userPhone,
			String userEmail) {
		super();
		this.memberNum = memberNum;
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userAdress = userAdress;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}
	
	public Member() {
		super();
	}

	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", userId=" + userId + ", userPass=" + userPass + ", userName="
				+ userName + ", userAdress=" + userAdress + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ "]";
	}
	
}
