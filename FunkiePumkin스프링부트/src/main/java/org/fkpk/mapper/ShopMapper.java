package org.fkpk.mapper;

import java.util.List;

import org.fkpk.domain.Shop;

public interface ShopMapper {
	public void shopRegister(Shop shop);
	public List<Shop> shopList();
}
