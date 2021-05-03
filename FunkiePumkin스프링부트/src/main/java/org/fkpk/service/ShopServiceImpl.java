package org.fkpk.service;


import java.util.List;

import org.fkpk.domain.Shop;
import org.fkpk.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopMapper shopMapper;

	
	@Override
	public void shopRegister(Shop shop) throws Exception {
		shopMapper.shopRegister(shop);
		
	}

	@Override
	public List<Shop> shopList() {
		return shopMapper.shopList();
	}

}
