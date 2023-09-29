package com.dhanush.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhanush.controller.ProductFeign;

@Service
public class priceservice  {

	@Autowired
	ProductFeign productFeign;
	
	public Double findPriceById(int id) {
		return productFeign.getPriceById(id);
	}
	
}
