package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
@SequenceGenerator(name = "SEQ" , 
sequenceName = "SEQ_Member_NO",
initialValue = 1,
allocationSize = 1)
public class Member {

	@Id
	@Column(name = "memberNum")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	private long memberNum;
	
	@Column(name = "userId", unique = true)
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
	
	@ManyToOne
	@JoinColumn(name = "GroupCode")
	private Authority auth;
	
	@OneToMany(mappedBy = "member")
	private	List<OrderList> order = new ArrayList<>();

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

	public Authority getAuth() {
		return auth;
	}

	public void setAuth(Authority auth) {
		this.auth = auth;
	}

	public List<OrderList> getOrder() {
		return order;
	}

	public void setOrder(List<OrderList> order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Member [memberNum=" + memberNum + ", userId=" + userId + ", userPass=" + userPass + ", userName="
				+ userName + ", userAdress=" + userAdress + ", userPhone=" + userPhone + ", userEmail=" + userEmail
				+ "]";
	}

	public Member(long memberNum, String userId, String userPass, String userName, String userAdress, String userPhone,
			String userEmail, Authority auth, List<OrderList> order) {
		super();
		this.memberNum = memberNum;
		this.userId = userId;
		this.userPass = userPass;
		this.userName = userName;
		this.userAdress = userAdress;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
		this.auth = auth;
		this.order = order;
	} 
	
	public Member() {
		super();
	}
	
}
