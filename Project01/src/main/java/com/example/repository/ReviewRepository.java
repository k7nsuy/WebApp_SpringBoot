package com.example.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{

	List<Review> findByReviewTitleIgnoreCaseContainingOrderByReviewNumberAsc(String txt, Pageable pageable);

	long countByReviewTitleIgnoreCaseContaining(String txt);

}
