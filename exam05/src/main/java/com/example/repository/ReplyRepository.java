package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ExBoardReply;

public interface ReplyRepository extends JpaRepository<ExBoardReply, Long> {

}
