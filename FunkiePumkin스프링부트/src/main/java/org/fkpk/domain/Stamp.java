package org.fkpk.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Stamp {
	private Integer stampId;
	private Integer memberId;
	private Integer stampCount;
	private Integer stampRegdate;
}
