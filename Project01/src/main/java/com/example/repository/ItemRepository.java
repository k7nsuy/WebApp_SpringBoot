package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.ItemList;

public interface ItemRepository extends JpaRepository<ItemList, Long> {

	List<ItemList> findByItemNameIgnoreCaseContainingOrderByItemNumberAsc(String txt, Pageable pageable);

	long countByItemNameIgnoreCaseContaining(String txt);

	@Transactional
	int deleteByItemNumber(long no);

	Optional<ItemList> findByItemNumber(long itemno);

}
