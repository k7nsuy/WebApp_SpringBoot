package com.example.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Notification")
@SequenceGenerator(allocationSize = 1,
initialValue = 1,
name = "SEQ",
sequenceName = "SEQ_NOTI_NUMBER")
public class Notification {

	@Id
	@Column(name = "BRDNO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	private Long no;
	
	@Column(name = "BRDTITLE" , length = 100)
	private String title = null;
	
	@Lob //용량 제한을 크게 늘린다. CLOB(TEXT) BLOB(FILE)
	@Column(name = "BRDCONTENT")
	private String content = null;
	
	@Column(name = "BRDWRITER" , length = 20)
	private String writer;
	
	@Column(name = "BRDHIT")
	private Long hit = 1L;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "BRDREGDATE")
	private Date regdate;
	
	@OneToMany(mappedBy = "noti")
	private List<NotificationReply> replyList = new ArrayList<>();

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Long getHit() {
		return hit;
	}

	public void setHit(Long hit) {
		this.hit = hit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public List<NotificationReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<NotificationReply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "Notification [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer + ", hit="
				+ hit + ", regdate=" + regdate + ", replyList=" + replyList + "]";
	}

	public Notification(Long no, String title, String content, String writer, Long hit, Date regdate,
			List<NotificationReply> replyList) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.hit = hit;
		this.regdate = regdate;
		this.replyList = replyList;
	}
	
	public Notification() {
		super();
	}
}
