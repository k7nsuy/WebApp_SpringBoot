package com.example.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

	Member findByUserId(String UserId);

	List<Member> findByUserNameIgnoreCaseContainingOrderByMemberNumAsc(String txt, Pageable pageable);

	long countByuserNameIgnoreCaseContaining(String txt);

}
