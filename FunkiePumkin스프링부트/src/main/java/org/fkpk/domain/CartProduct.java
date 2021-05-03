package org.fkpk.domain;

import lombok.Data;

@Data
public class CartProduct {
	private Integer cartId;
	private Integer productId;
	private Integer cartAmount;
	private Integer memberId;
	private String productName;
	private Integer productPrice;
	private String productImg;
}
