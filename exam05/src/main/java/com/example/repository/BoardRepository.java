package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ExBoard;

public interface BoardRepository extends JpaRepository<ExBoard, Long> {
	
	List<ExBoard> findByTitleIgnoreCaseContainingOrderByNoAsc(String txt, Pageable pageable);

	long countByTitleIgnoreCaseContaining(String txt);

}
