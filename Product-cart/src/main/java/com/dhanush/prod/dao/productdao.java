package com.dhanush.prod.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.dhanush.prod.model.Product;

public interface productdao extends JpaRepository<Product, Integer> {

	@Query(value="select * from Product p where p.name like %:keyword%", nativeQuery=true)
	List<Product> findByContaining(@Param ("keyword") String name);
	
	@Query(value="select price from product p where p.id = :id", nativeQuery=true)
	double findPriceById(@PathVariable ("id")int id);
}


