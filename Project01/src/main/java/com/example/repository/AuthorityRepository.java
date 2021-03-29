package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Optional<Authority> findByGroupCode(long GroupCode);
}
