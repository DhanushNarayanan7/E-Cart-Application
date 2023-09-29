package com.dhanush.prod.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhanush.prod.model.Review;

public interface reviewdao extends JpaRepository<Review, Integer> {

	List<Review> findByProductId(int id);
	
}


