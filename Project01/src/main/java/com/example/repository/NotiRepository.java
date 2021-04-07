package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Notification;

public interface NotiRepository extends JpaRepository<Notification, Long> {

	List<Notification> findByTitleIgnoreCaseContainingOrderByNoAsc(String txt, Pageable pageable);

	long countByTitleIgnoreCaseContaining(String txt);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM NOTIFICATION WHERE BRDNO = :no", nativeQuery=true)
	int sqlDeleteByNo(@Param("no") Long no);

}
