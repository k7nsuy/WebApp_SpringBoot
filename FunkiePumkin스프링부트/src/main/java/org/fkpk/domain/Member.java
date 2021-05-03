package org.fkpk.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Member {
	private Integer memberId;
	private String userName;
	private Integer isSeller;
	private String userId;
	private String userPassword;
	private String userAddress;
	private String userRegion;
	private String userTel;
	private String userRegdate;
	private Integer point;
	private Integer sales;
	private Integer isStamped;
	private Integer couponId;
	private Integer isjoinbykakao;
	private Integer isjoinbynaver;
}
