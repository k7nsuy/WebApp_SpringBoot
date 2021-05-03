package org.fkpk.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Shop {
	private Integer shopId;
	private String shopName;
	private String shopAddress;
	private String shopTel;
	private String shopLat;//위도
	private String shopLng;//경도

}
