package org.fkpk.domain;

import lombok.Data;

@Data
public class OrderDetailProduct {
	private Integer orderdetailsId;
	private String orderId;
	private Integer productId;
	private Integer qty;
	private Integer productPrice;
	private String exp;

}
