package org.fkpk.domain;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Refrige {
	private Integer refrigeId;
	private Integer productId;
	private Integer memberId;
	private Integer productAmount;
}
