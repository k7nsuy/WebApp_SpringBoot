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

import com.example.security.MyMember;

@Entity
@Table(name = "orderList")
public class OrderList {
	
	@Id
	@Column(name = "orderNum")
	private Long orderNum;
	
	@Column(name = "orderName")
	private String orderName;
	
	@Column(name = "orderPrice")
	private Long orderPrice;
	
	@Column(name = "orderQuanity")
	private Long orderQuantity = 1L;
	
	@Column(name = "totalPrice")
	private Long totalPrice;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "orderDate")
	private Date orderDate;
	
	@ManyToOne
	@JoinColumn(name = "memberNum")
	private Member member;

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Long getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Long orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Long orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
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
		return "OrderList [orderNum=" + orderNum + ", orderName=" + orderName + ", orderPrice=" + orderPrice
				+ ", orderQuantity=" + orderQuantity + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate
				+ ", member=" + member + "]";
	}

	public OrderList(Long orderNum, String orderName, Long orderPrice, Long orderQuantity, Long totalPrice,
			Date orderDate, Member member) {
		super();
		this.orderNum = orderNum;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.member = member;
	}

	public OrderList() {
		super();
	}
	
}
