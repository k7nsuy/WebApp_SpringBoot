package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User5;

public interface User5Repository extends JpaRepository<User5, Long> {

	//기본적으로 제공하는 고객 아이디가 Long타입 밖에 없으니 String을 이용할 수 있게 String id 생성
	Optional<User5> findByUserid(String id);
}
