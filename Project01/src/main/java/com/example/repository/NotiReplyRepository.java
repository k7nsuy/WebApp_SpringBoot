package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.NotificationReply;

public interface NotiReplyRepository extends JpaRepository<NotificationReply, Long> {

}
