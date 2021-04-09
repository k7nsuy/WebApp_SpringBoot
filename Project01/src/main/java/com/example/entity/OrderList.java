package com.example.entity;

import java.sql.Date;

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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.security.MyMember;

@Entity
@Table(name = "orderList")
@SequenceGenerator(name = "SEQ",
sequenceName = "SEQ_ORDER_NUMBER",
allocationSize = 1,
initialValue = 1)
public class OrderList {
	
	@Id
	@GeneratedValue(generator = "SEQ",strategy = GenerationType.SEQUENCE)
	@Column(name = "orderNum")
	private long orderNum;
	
	@Column(name = "orderQuanity")
	private long orderQuantity = 1L;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
	@CreationTimestamp
	@Column(name = "orderDate")
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name = "memberNumber")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "itemNumber")
	private ItemList item;

	public long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(long orderNum) {
		this.orderNum = orderNum;
	}

	public long getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(long orderQuantity) {
		this.orderQuantity = orderQuantity;
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

	public ItemList getItem() {
		return item;
	}

	public void setItem(ItemList item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "OrderList [orderNum=" + orderNum + ", orderQuantity=" + orderQuantity + ", orderDate=" + orderDate
				+ "]";
	}

	public OrderList(long orderNum, long orderQuantity, Date orderDate, Member member, ItemList item) {
		super();
		this.orderNum = orderNum;
		this.orderQuantity = orderQuantity;
		this.orderDate = orderDate;
		this.member = member;
		this.item = item;
	}
	
	public OrderList() {
		super();
	}

}
