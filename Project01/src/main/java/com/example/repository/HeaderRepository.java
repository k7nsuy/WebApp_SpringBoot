package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Member;

public interface HeaderRepository extends JpaRepository<Member, Long> {

}
