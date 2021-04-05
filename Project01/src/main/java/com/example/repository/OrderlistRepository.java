package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ItemList;

public interface OrderlistRepository extends JpaRepository<ItemList, Long> {

}
