package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ItemList;
import com.example.entity.OrderList;

public interface OrderlistRepository extends JpaRepository<OrderList, Long> {

//	List<OrderList> findByItemList_ItemNumberAndMember_MemberNum(long no , long no2);

	List<OrderList> findByMember_MemberNum
	(long memberNum);
}
