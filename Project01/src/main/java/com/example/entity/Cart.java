package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cart")
@SequenceGenerator(name = "SEQ",
sequenceName = "SEQ_CART_NUM",
allocationSize = 1,
initialValue = 1)
public class Cart {
	
	@Id
	@GeneratedValue(generator = "SEQ",strategy = GenerationType.SEQUENCE)
	@Column(name = "cartNum")
	private Long cartNum;

	@OneToMany(mappedBy = "cartItem")
	private List<ItemList> itemlist = new ArrayList<>();
	
	@OneToOne(mappedBy = "cartMember")
	private Member member;

	public Long getCartNum() {
		return cartNum;
	}

	public void setCartNum(Long cartNum) {
		this.cartNum = cartNum;
	}

	public List<ItemList> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<ItemList> itemlist) {
		this.itemlist = itemlist;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "Cart [cartNum=" + cartNum + "]";
	}

	public Cart(Long cartNum, List<ItemList> itemlist, Member member) {
		super();
		this.cartNum = cartNum;
		this.itemlist = itemlist;
		this.member = member;
	}

	public Cart() {
		super();
	}
	
}
