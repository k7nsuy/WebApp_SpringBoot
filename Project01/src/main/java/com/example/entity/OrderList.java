package com.example.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orderList")
public class OrderList {
	
	@Id
	@Column(name = "orderNum")
	private long orderNum;
	
	@Column(name = "orderPrice")
	private String orederItem;
	
	@Column(name = "orderQuanity")
	private String orderQuantity;
	
	@Column(name = "totalPrice")
	private String totalPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "orderDate")
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name = "memberNum")
	private Member member;

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrederItem() {
		return orederItem;
	}

	public void setOrederItem(String orederItem) {
		this.orederItem = orederItem;
	}

	public String getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(String orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "OrderList [orderNum=" + orderNum + ", orederItem=" + orederItem + ", orderQuantity=" + orderQuantity
				+ ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + ", member=" + member + "]";
	}

	public OrderList(long orderNum, String orederItem, String orderQuantity, String totalPrice, Date orderDate,
			Member member) {
		super();
		this.orderNum = orderNum;
		this.orederItem = orederItem;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.member = member;
	}

	public OrderList() {
		super();
	}
}
