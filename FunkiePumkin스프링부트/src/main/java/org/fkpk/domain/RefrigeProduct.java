package org.fkpk.domain;

import lombok.Data;

@Data
public class RefrigeProduct {
    private Integer refrigeId;
    private Integer memberId;
    private Integer productId;
    private String productName;
    private Integer productAmount;
    private String exp;
    private String productImg;
}
