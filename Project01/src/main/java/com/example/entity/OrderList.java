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
	private Long orderNum;
	
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
	
	@ManyToOne
	@JoinColumn(name = "itemNumber")
	private ItemList itemlist;

	public Long getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Long orderNum) {
		this.orderNum = orderNum;
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

	public ItemList getItemlist() {
		return itemlist;
	}

	public void setItemlist(ItemList itemlist) {
		this.itemlist = itemlist;
	}

	@Override
	public String toString() {
		return "OrderList [orderNum=" + orderNum + ", orderQuantity=" + orderQuantity + ", totalPrice=" + totalPrice
				+ ", orderDate=" + orderDate + ", member=" + member + ", itemlist=" + itemlist + "]";
	}

	public OrderList(Long orderNum, Long orderQuantity, Long totalPrice, Date orderDate, Member member,
			ItemList itemlist) {
		super();
		this.orderNum = orderNum;
		this.orderQuantity = orderQuantity;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.member = member;
		this.itemlist = itemlist;
	}

	public OrderList() {
		super();
	}
}
