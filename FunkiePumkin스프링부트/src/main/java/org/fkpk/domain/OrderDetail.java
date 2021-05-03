package org.fkpk.domain;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderDetail {
	private Integer orderdetailsId;
	private String orderId;
	private Integer productId;
	private Integer qty;
}
