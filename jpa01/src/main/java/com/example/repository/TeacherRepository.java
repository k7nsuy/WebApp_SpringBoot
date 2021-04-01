package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Student;
import com.example.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	// 교사의 아이디가 일치하는 학생 목록
	List<Student> findByTeacher_TeacherId(String teacherId);
	
	// 페이지네이션 추가
	List<Student> findByTeacher_TeacherId(String teacherId, Pageable pageable);
	
	//25라인에서 정렬 추가
		List<Student> findByTeacher_TeacherIdOrderByTeacherIdAsc
			(String teacherId, Pageable pageable);
}
