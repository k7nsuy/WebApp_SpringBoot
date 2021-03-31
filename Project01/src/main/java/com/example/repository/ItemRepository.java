package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ItemList;

public interface ItemRepository extends JpaRepository<ItemList, Long> {

	List<ItemList> findByItemNameIgnoreCaseContainingOrderByItemNumberAsc(String txt, Pageable pageable);

	long countByItemNameIgnoreCaseContaining(String txt);

}
