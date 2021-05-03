package org.fkpk.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cart {
	private Integer cartId;
	private Integer productId;
	private Integer cartAmount;
	private String cartRegdate;
	private Integer memberId;

}
