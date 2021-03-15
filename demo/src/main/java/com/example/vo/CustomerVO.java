package com.example.vo;

public class CustomerVO {

	private String userid;
	private String userpw;
	private String username;
	private String userphone;
	private String userdate;
	private String usergrade;
	private byte[] userimg = null;
	
	//생성자
	
	public CustomerVO() {
		super();
	}
	
	public CustomerVO(String userid, String userpw, String username, String userphone, String userdate, String usergrade) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphone = userphone;
		this.userdate = userdate;
		this.usergrade = usergrade;
	}

	//get/setter
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

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUserdate() {
		return userdate;
	}

	public void setUserdate(String userdate) {
		this.userdate = userdate;
	}

	//toString()
	@Override
	public String toString() {
		return "CustomerVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", userphone="
				+ userphone + ", userdate=" + userdate + "]";
	}

	public byte[] getUserimg() {
		return userimg;
	}

	public void setUserimg(byte[] userimg) {
		this.userimg = userimg;
	}

	public String getUsergrade() {
		return usergrade;
	}

	public void setUsergrade(String usergrade) {
		this.usergrade = usergrade;
	}
	
	
}
