package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "itemList")
@SequenceGenerator(name = "SEQ",
		sequenceName = "SEQ_itemList_Num",
		initialValue = 1,
		allocationSize =1 )
public class ItemList {
	
	@Id
	@GeneratedValue(generator = "SEQ",strategy = GenerationType.SEQUENCE)
	@Column(name = "itemNumber")
	private long itemNumber;
	
	@Column(name = "itemName")
	private String itemName;
	
	@Column(name = "itemPrice")
	private long itemPrice;
	
	@Column(name = "itemQuantity")
	private long itemQuantity;
	
	@Column(name = "itemNutrition")
	private String itemNutrition;
	
	@Column(name = "itemDetail")
	private String itemDetail;
	
	@Column(name = "itemRecommend")
	private String itemRecommend;
	
	@Lob
	@Column(name = "itemImage")
	private byte[] itemImage;
	
	@Column(name = "itemHit")
	private long itemHit = 0;
	
	@Transient
	private String base64;
	
	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public ItemList(long itemNumber, String itemName, long itemPrice, long itemQuantity, String itemNutrition,
			String itemDetail, String itemRecommend, byte[] itemImage, long itemHit) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemNutrition = itemNutrition;
		this.itemDetail = itemDetail;
		this.itemRecommend = itemRecommend;
		this.itemImage = itemImage;
		this.itemHit = itemHit;
	}

	public byte[] getItemImage() {
		return itemImage;
	}

	public void setItemImage(byte[] itemImage) {
		this.itemImage = itemImage;
	}

	public ItemList(long itemHit) {
		super();
		this.itemHit = itemHit;
	}

	public long getItemHit() {
		return itemHit;
	}

	public void setItemHit(long itemHit) {
		this.itemHit = itemHit;
	}

	public long getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(long itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public long getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(long itemPrice) {
		this.itemPrice = itemPrice;
	}

	public long getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(long itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemNutrition() {
		return itemNutrition;
	}

	public void setItemNutrition(String itemNutrition) {
		this.itemNutrition = itemNutrition;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public String getItemRecommend() {
		return itemRecommend;
	}

	public void setItemRecommend(String itemRecommend) {
		this.itemRecommend = itemRecommend;
	}

	@Override
	public String toString() {
		return "ItemList [itemNumber=" + itemNumber + ", itemName=" + itemName + ", itemPrice=" + itemPrice
				+ ", itemQuantity=" + itemQuantity + ", itemNutrition=" + itemNutrition + ", itemDetail=" + itemDetail
				+ ", itemRecommend=" + itemRecommend + ", itemHit=" + itemHit + "]";
	}

	public ItemList(long itemNumber, String itemName, long itemPrice, long itemQuantity, String itemNutrition,
			String itemDetail, String itemRecommend) {
		super();
		this.itemNumber = itemNumber;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.itemNutrition = itemNutrition;
		this.itemDetail = itemDetail;
		this.itemRecommend = itemRecommend;
	}
	
	public ItemList() {
		super();
	}

}
