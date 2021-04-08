package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ItemList;
import com.example.entity.OrderList;

public interface OrderlistRepository extends JpaRepository<OrderList, Long> {

}
