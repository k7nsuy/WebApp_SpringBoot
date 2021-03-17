package com.example.vo;

public class MemberVO {

	private String userid = null;
	private String userpw = null;
	private String username = "0";
	private int userbirth = 0;
	private String usergrade = "USER";
	private String regdate = null;
	
	
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userbirth="
				+ userbirth + ", usergrade=" + usergrade + ", regdate=" + regdate + "]";
	}

	public MemberVO() {
		super();
	}
	
	public MemberVO(String userid, String userpw, String username, int userbirth, String usergrade,
			String regdate) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userbirth = userbirth;
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
