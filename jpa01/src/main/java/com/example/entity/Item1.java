package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
//오라클 테이블 명
@Table(name = "ITEM1TBL")
@SequenceGenerator(name = "SEQ" , 
		sequenceName = "SEQ_ITEM1_NO",
		initialValue = 1,
		allocationSize = 1)

public class Item1 {

	@Column(name = "ITMNO")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
	private Long no;
	
	// 물품명 ITMNAME, VARCHAR2
	@Column(name = "ITMNAME", length = 100)
	private String name;
	
	// 물품가격 ITMPRICE, NUMBER
	@Column(name = "ITMPRICE")
	private Long price;
	
	// 물품수량 ITMQUANTITY, NUMBER
	@Column(name = "ITMQUANTITY")
	private Long quantity;
	
	// 등록일자 ITMDATE, DATE
	//@UpdateTimestamp => update날짜
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp // CURRENT_DATE => 최초의 등록날짜
	@Column(name = "ITMDATE")
	private Date itmdate;
	//byte[] base64 String으로 변경해서 보관할 변수
	private String base64;
	
	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public Item1() {
		super();
	}
	
	public Item1(Long no, String name, Long price, Long quantity, Date itmdate) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.itmdate = itmdate;
	}

	@Override
	public String toString() {
		return "Item1 [no=" + no + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", itmdate="
				+ itmdate + "]";
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Date getItmdate() {
		return itmdate;
	}

	public void setItmdate(Date itmdate) {
		this.itmdate = itmdate;
	}
	
	
}
