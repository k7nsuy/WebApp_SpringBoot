package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.ExBoard;

public interface BoardRepository extends JpaRepository<ExBoard, Long> {
	
	List<ExBoard> findByTitleIgnoreCaseContainingOrderByNoAsc(String txt, Pageable pageable);

	long countByTitleIgnoreCaseContaining(String txt);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM EXAM_BOARD WHERE BRDNO = :no", nativeQuery=true)
	int sqlDeleteByNo(@Param("no") Long no);
	
}
