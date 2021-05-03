package org.fkpk.service;

import java.util.List;

import org.fkpk.domain.Shop;

public interface ShopService {

	public void shopRegister(Shop shop) throws Exception;
	
	public List<Shop> shopList();

}
