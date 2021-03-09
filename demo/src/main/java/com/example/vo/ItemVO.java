package com.example.vo;

import java.util.Arrays;

public class ItemVO {

	private long code = 0L;
	private String name = null;
	private long price = 10000L;
	private long quantity = 100L;
	private String regdate = null;
	
	@Override
	public String toString() {
		return "ItemVO [code=" + code + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", regdate="
				+ regdate + ", category=" + category + ", category2=" + Arrays.toString(category2) + "]";
	}

	public long getCode() {
		return code;
	}
	
	public ItemVO() {
		
	}
	
	public ItemVO(long code, String name, long price, long quantity, String regdate, String category,
			String[] category2) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.regdate = regdate;
		this.category = category;
		this.category2 = category2;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String[] getCategory2() {
		return category2;
	}
	public void setCategory2(String[] category2) {
		this.category2 = category2;
	}
	private String category = null;
	private String[] category2 = null;
	
}
