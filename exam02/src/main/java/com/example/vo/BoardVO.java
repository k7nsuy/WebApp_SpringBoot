package com.example.vo;

public class BoardVO {
	
	private long brdno = 0;
	private String brdtitle = null;
	private String brdcontent = null;
	private int brdhit = 0;
	private String brdwriter = null;
	private String brddate = null;
	
	@Override
	public String toString() {
		return "BoardVO [brdno=" + brdno + ", brdtitle=" + brdtitle + ", brdcontent=" + brdcontent + ", brdhit="
				+ brdhit + ", brdwriter=" + brdwriter + ", brddate=" + brddate + "]";
	}

	public BoardVO() {
		
	}
	
	public BoardVO(long brdno, String brdtitle, String brdcontent, int brdhit, String brdwriter, String brddate) {
		super();
		this.brdno = brdno;
		this.brdtitle = brdtitle;
		this.brdcontent = brdcontent;
		this.brdhit = brdhit;
		this.brdwriter = brdwriter;
		this.brddate = brddate;
	}
	public long getBrdno() {
		return brdno;
	}
	public void setBrdno(long brdno) {
		this.brdno = brdno;
	}
	public String getBrdtitle() {
		return brdtitle;
	}
	public void setBrdtitle(String brdtitle) {
		this.brdtitle = brdtitle;
	}
	public String getBrdcontent() {
		return brdcontent;
	}
	public void setBrdcontent(String brdcontent) {
		this.brdcontent = brdcontent;
	}
	public int getBrdhit() {
		return brdhit;
	}
	public void setBrdhit(int brdhit) {
		this.brdhit = brdhit;
	}
	public String getBrdwriter() {
		return brdwriter;
	}
	public void setBrdwriter(String brdwriter) {
		this.brdwriter = brdwriter;
	}
	public String getBrddate() {
		return brddate;
	}
	public void setBrddate(String brddate) {
		this.brddate = brddate;
	}

}
