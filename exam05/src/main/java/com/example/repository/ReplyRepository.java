package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.ExBoardReply;

public interface ReplyRepository extends JpaRepository<ExBoardReply, Long> {

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM EXAM_BOARD_REPLY WHERE BRDNO = :no", nativeQuery=true)
	int sqlDeleteReplyByNo(@Param("no") Long no);
	
}
