package org.fkpk.domain;



import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
	private Integer productId;
	private Integer memberId;
	private String productName;
	private Integer productPrice;
	private String productDes;
	private MultipartFile uploadFile;
	private String productImg;
	private Integer salesAmount;
	private Integer stock;
	private String category;
	private String exp;
}
