package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
//오라클 테이블 명
@Table(name = "ORDERTBL5")
@SequenceGenerator(name = "SEQ" , 
		sequenceName = "SEQ_ORDERTBL5_NO",
		initialValue = 1,
		allocationSize = 1)

public class Order5 {

	@Column(name = "ORDNO")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	private Long no = 0L;
	
	// 물품명 ITMNAME, VARCHAR2
	@Column(name = "ORDQNT", length = 100)
	private long qnt = 0L;
	
	// 등록일자 ITMDATE, DATE
	//@UpdateTimestamp => update날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp // CURRENT_DATE => 최초의 등록날짜
	@Column(name = "ORDDATE")
	private Date orddate;
	
	@ManyToOne
	@JoinColumn (name = "ITMNO")
	private Item5 item;
	
	@ManyToOne
	@JoinColumn(name = "USERID")
	private User5 user;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public long getQnt() {
		return qnt;
	}

	public void setQnt(long qnt) {
		this.qnt = qnt;
	}

	public Date getOrddate() {
		return orddate;
	}

	public void setOrddate(Date orddate) {
		this.orddate = orddate;
	}

	public Item5 getItem() {
		return item;
	}

	public void setItem(Item5 item) {
		this.item = item;
	}

	public User5 getUser() {
		return user;
	}

	public void setUser(User5 user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order5 [no=" + no + ", qnt=" + qnt + ", orddate=" + orddate + ", item=" + item + ", user=" + user + "]";
	}

	public Order5(Long no, long qnt, Date orddate, Item5 item, User5 user) {
		super();
		this.no = no;
		this.qnt = qnt;
		this.orddate = orddate;
		this.item = item;
		this.user = user;
	}
	
	public Order5() {
		super();
	}
}
