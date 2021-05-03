package org.fkpk.domain;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Order {
	private String orderId;
	private Integer memberId;
	private String status;
	private String orderAddr;
	private String orderPhone;
	private Integer totalOrderAmount;
	private String orderDate;
}
