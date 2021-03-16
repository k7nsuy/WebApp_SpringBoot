package com.example.vo;

public class MemberVO {

	private String userid;
	private String userpw;
	private String username;
	private int userbirth;
	private String userphone;
	private String usergrade;
	private String regdate;
	
	
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userbirth="
				+ userbirth + ", userphone=" + userphone + ", usergrade=" + usergrade + ", regdate=" + regdate + "]";
	}

	public MemberVO() {
		
	}
	
	public MemberVO(String userid, String userpw, String username, int userbirth, String userphone, String usergrade,
			String regdate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userbirth = userbirth;
		this.userphone = userphone;
		this.usergrade = usergrade;
		this.regdate = regdate;
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
	public int getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(int userbirth) {
		this.userbirth = userbirth;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUsergrade() {
		return usergrade;
	}
	public void setUsergrade(String usergrade) {
		this.usergrade = usergrade;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
}
